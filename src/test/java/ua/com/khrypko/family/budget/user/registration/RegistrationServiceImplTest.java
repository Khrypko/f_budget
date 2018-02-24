package ua.com.khrypko.family.budget.user.registration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import ua.com.khrypko.family.budget.exception.NoSuchEntity;
import ua.com.khrypko.family.budget.exception.ValidationException;
import ua.com.khrypko.family.budget.user.dto.UserRequest;
import ua.com.khrypko.family.budget.user.entity.User;
import ua.com.khrypko.family.budget.user.exception.SuchUserAlreadyExists;
import ua.com.khrypko.family.budget.user.exception.UserConfirmationFailed;
import ua.com.khrypko.family.budget.user.registration.request.RegistrationRequest;
import ua.com.khrypko.family.budget.user.service.UserService;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

/**
 * Created by Maks on 24.02.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceImplTest {

    public static final String UNIQUE_ID = "test";
    private RegistrationService registrationService;

    @Mock
    private UserService userService;

    @Mock
    private MailSender mailSender;

    private TemporaryUserContainer container;

    @Before
    public void setUp(){
        container = Mockito.mock(TemporaryUserContainer.class);
        registrationService = new RegistrationServiceImpl(mailSender, userService, container)
                .setDomain("test")
                .setRegistrationSubject("registration")
                .setRegistrationText("test %s");
    }

    @Test
    public void testRegistrationRequestCreated(){

        when(userService.userExist(anyString())).thenReturn(false);

        registrationService.performCreateRequest(getUserRequest());

        verify(container, times(1)).addRegistrationRequest(anyString(), any());
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test(expected = SuchUserAlreadyExists.class)
    public void testFailsIfUserAlreadyExists(){
        when(userService.userExist(anyString())).thenReturn(true);
        registrationService.performCreateRequest(getUserRequest());
    }

    @Test(expected = ValidationException.class)
    public void testFailsIfUserEmailNotSet(){
        UserRequest userRequest = getUserRequest();
        userRequest.setEmail(null);
        registrationService.performCreateRequest(userRequest);
    }

    @Test(expected = ValidationException.class)
    public void testFailsIfUserPasswordNotSet(){
        UserRequest userRequest = getUserRequest();
        userRequest.setPassword(null);
        registrationService.performCreateRequest(userRequest);
    }

    @Test(expected = ValidationException.class)
    public void testFailsIfUserNameNotSet(){
        UserRequest userRequest = getUserRequest();
        userRequest.setName(null);
        registrationService.performCreateRequest(userRequest);
    }

    @Test
    public void testConfirmRegistrationSuccessful(){
        when(container.getRegistrationRequest(anyString())).thenReturn(registrationRequest());
        when(userService.createUser(any())).thenReturn(user());

        User user = registrationService.confirmRegistration(UNIQUE_ID);

        verify(userService, times(1)).createUser(any());
        assertNotNull(user);
        verify(container).removeRegistrationRequest(UNIQUE_ID);
    }

    @Test(expected = UserConfirmationFailed.class)
    public void testConfirmRegistrationFails_WrongUrl(){
        registrationService.confirmRegistration(UNIQUE_ID);
    }

    private User user() {
        return new User();
    }

    private RegistrationRequest registrationRequest() {
        return new RegistrationRequest(getUserRequest(), UNIQUE_ID);
    }

    private UserRequest getUserRequest() {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("test@test.ua");
        userRequest.setName("test");
        userRequest.setPassword("test");
        userRequest.setFamily(1);
        return userRequest;
    }
}