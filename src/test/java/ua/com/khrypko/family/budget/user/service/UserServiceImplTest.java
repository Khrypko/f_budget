package ua.com.khrypko.family.budget.user.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ua.com.khrypko.family.budget.exception.NoSuchEntity;
import ua.com.khrypko.family.budget.exception.ValidationException;
import ua.com.khrypko.family.budget.user.dto.UserRequest;
import ua.com.khrypko.family.budget.user.entity.User;
import ua.com.khrypko.family.budget.user.repository.UserRepository;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static ua.com.khrypko.family.budget.user.UserTestUtil.*;

/**
 * Created by Maks on 24.02.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    private UserServiceImpl userService;

    @Mock private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void testFetchUserByEmailSuccessful(){
        when(userRepository.findOneByEmail(anyString())).thenReturn(getTestUser());
        User user = userService.fetchUserByEmail("test");
        assertNotNull(user);
    }

    @Test(expected = NoSuchEntity.class)
    public void testNoUserFound(){
        when(userRepository.findOneByEmail(anyString())).thenReturn(Optional.empty());
        userService.fetchUserByEmail("test");
    }

    @Test
    public void testCheckUserExistsSuccessful(){
        when(userRepository.existsByEmail(anyString())).thenReturn(true);
        boolean result = userService.userExist("test");
        assertTrue(result);
    }

    @Test
    public void testUserExistReturnsFalseIfNoSuchUserInRepo(){
        boolean result = userService.userExist("test");
        assertFalse(result);
    }

    @Test
    public void testCreateUserSuccessfully(){
        // returning passed user
        when(userRepository.save(any(User.class))).thenAnswer(i -> i.getArguments()[0]);

        UserRequest request = userRequest();
        User user = userService.createUser(request);

        verify(userRepository, times(1)).save(any(User.class));

        assertUserHasSameFieldsAsRequest(request, user);
        assertTrue(user.isActive());
    }

    @Test(expected = ValidationException.class)
    public void testCreateUserFailsWithoutName(){
        UserRequest request = userRequest();
        request.setName(null);
        userService.createUser(request);
    }

    @Test(expected = ValidationException.class)
    public void testCreateUserFailsWithoutEmail(){
        UserRequest request = userRequest();
        request.setEmail(null);
        userService.createUser(request);
    }
    @Test(expected = ValidationException.class)
    public void testCreateUserFailsWithoutPassword(){
        UserRequest request = userRequest();
        request.setPassword(null);
        userService.createUser(request);
    }

    private Optional<User> getTestUser() {
        return Optional.of(new User());
    }
}