package ua.com.khrypko.family.budget.user.facade;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import ua.com.khrypko.family.budget.user.dto.FamilyDto;
import ua.com.khrypko.family.budget.user.dto.FamilyDtoWithUsers;
import ua.com.khrypko.family.budget.user.dto.UserDTO;
import ua.com.khrypko.family.budget.user.entity.Family;
import ua.com.khrypko.family.budget.user.entity.User;
import ua.com.khrypko.family.budget.user.service.FamilyService;
import ua.com.khrypko.family.budget.user.service.UserService;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.*;

/**
 * Created by Maks on 17.01.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserFacadeImplTest {

    private static final String familyName = "test";
    private static final String uniqueId = "someUniqueId12345";

    private UserFacadeImpl userFacade;

    @Mock
    private UserService userService;

    @Mock
    private FamilyService familyService;

    @Before
    public void setUp(){
        userFacade = new UserFacadeImpl(userService, familyService);
    }

    private FamilyDtoWithUsers createFamilyDTO() {
        FamilyDtoWithUsers dto = new FamilyDtoWithUsers();
        dto.setName(familyName);
        dto.setUniqueId(uniqueId);
        return dto;
    }

    @Test
    @Ignore
    public void testCreateFamily(){

        when(userService.getUser(1L)).thenReturn(getUser());
        when(familyService.createFamily(any())).thenReturn(testFamily());

        FamilyDtoWithUsers familyDtoWithUsers = createFamilyDTO();
        familyDtoWithUsers.setUsers(Collections.singletonList(new UserDTO(1L, null, null, null, 0)));
        FamilyDto createdFamily = userFacade.createFamily(familyDtoWithUsers);

        Assert.assertNotNull(createdFamily.getId());
        Assert.assertNotNull(createdFamily.getUniqueId());
        Assert.assertEquals(familyDtoWithUsers.getName(), createdFamily.getName());

    }

    private Family testFamily() {
        Family family = new Family();
        family.setName(familyName);
        family.setUniqueUrl(uniqueId);
        family.addUser(getUser());

        return family;
    }

    private User getUser() {
         User user = new User();
         user.setId(1L);
         return user;
    }

}