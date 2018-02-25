package ua.com.khrypko.family.budget.user.facade;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import ua.com.khrypko.family.budget.user.dto.FamilyDto;
import ua.com.khrypko.family.budget.user.dto.FamilyDtoWithUsers;
import ua.com.khrypko.family.budget.user.dto.UserDTO;
import ua.com.khrypko.family.budget.user.dto.UserRequest;
import ua.com.khrypko.family.budget.user.entity.Family;
import ua.com.khrypko.family.budget.user.entity.User;
import ua.com.khrypko.family.budget.user.service.FamilyService;
import ua.com.khrypko.family.budget.user.service.UserFacadeImpl;
import ua.com.khrypko.family.budget.user.service.UserService;

import java.util.Collections;

import static ua.com.khrypko.family.budget.user.UserTestUtil.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Maks on 17.01.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserFacadeImplTest {

    private static final String UNIQUE_URL = "testUniqueUrl";
    private UserFacadeImpl userFacade;

    @Mock
    private UserService userService;

    @Mock
    private FamilyService familyService;

    @Before
    public void setUp(){
        userFacade = new UserFacadeImpl(userService, familyService);
    }

    @Test
    public void testCreateNewUserWithoutFamilySuccessful(){
        when(userService.createUser(any())).thenReturn(getUser());
        when(userService.updateUser(any(User.class))).thenAnswer(i -> i.getArguments()[0]);
        when(familyService.createFamily(any())).thenReturn(testFamily());

        User user = userFacade.createUser(userRequest());

        verify(userService, times(1)).createUser(any());
        verify(userService, times(1)).updateUser(any(User.class));

        assertEquals(testFamily(), user.getFamily());
        assertUserHasSameFieldsAsRequest(userRequest(), user);
    }

    @Test
    public void testCreateWithSpecifiedAndJoinFamily(){
        when(userService.createUser(any())).thenReturn(getUser());
        when(userService.updateUser(any(User.class))).thenAnswer(i -> i.getArguments()[0]);
        Family family = testFamily();
        family.setUniqueUrl(UNIQUE_URL);
        when(familyService.getFamilyByUniqueUrl(UNIQUE_URL)).thenReturn(family);

        UserRequest userRequest = userRequest();
        userRequest.setFamilyUrl(UNIQUE_URL);
        User user = userFacade.createUser(userRequest);

        verify(userService, times(1)).createUser(any());
        verify(userService, times(1)).updateUser(any(User.class));
        verify(familyService, times(1)).getFamilyByUniqueUrl(UNIQUE_URL);
        assertEquals(family, user.getFamily());
        assertUserHasSameFieldsAsRequest(userRequest(), user);
    }

}