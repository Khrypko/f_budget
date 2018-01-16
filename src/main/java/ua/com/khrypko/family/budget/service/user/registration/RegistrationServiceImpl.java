package ua.com.khrypko.family.budget.service.user.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import ua.com.khrypko.family.budget.dto.user.UserRequest;
import ua.com.khrypko.family.budget.entity.user.User;
import ua.com.khrypko.family.budget.exception.MailSendingProblem;
import ua.com.khrypko.family.budget.exception.NoSuchEntity;
import ua.com.khrypko.family.budget.exception.user.SuchUserAlreadyExists;
import ua.com.khrypko.family.budget.exception.user.UserConfirmationFailed;
import ua.com.khrypko.family.budget.service.user.UserService;
import ua.com.khrypko.family.budget.service.user.UserUtils;

import javax.annotation.PostConstruct;
import java.util.Random;

/**
 * Created by Maks on 15.01.2018.
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private static final int RANDOM_STRING_LENGTH = 40;

    @Value("${mailtext.registration_subject}")
    private String registrationSubject;
    @Value("${mailtext.registration_text}")
    private String registrationText;
    @Value("${mailtext.domain}")
    private String domain;

    @Autowired
    private MailSender mailSender;

    @Autowired
    private UserService userService;

    private TemporaryUserContainer container;

    @PostConstruct
    private void initialize(){
        container = new TemporaryUserContainer();
    }

    @Override
    public void performCreateRequest(UserRequest userRequest) {
        UserUtils.validateRequest(userRequest);

        checkIfUserWithSuchEmailExists(userRequest.getEmail());

        String newRandomUrl = generateRandomUrlString();
        RegistrationRequest registrationRequest = new RegistrationRequest(userRequest, newRandomUrl);

        container.addRegistrationRequest(newRandomUrl, registrationRequest);

        sendRegistrationEmail(registrationRequest, newRandomUrl);
    }

    private void sendRegistrationEmail(RegistrationRequest registrationRequest, String newRandomUrl) {
        String email = registrationRequest.getUserRequest().getEmail();
        String mailText = prepareRegistrationEmail(email, newRandomUrl);
        String subject = getRegistrationSubject();

        sendEmail(email, mailText, subject);
    }

    private void sendEmail(String email, String mailText, String subject) {
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setTo(email);
        msg.setText(mailText);
        msg.setSubject(subject);

        try {
            mailSender.send(msg);
        } catch (MailException e){
            throw new MailSendingProblem(e);
        }
    }

    private String getRegistrationSubject() {
        return registrationSubject;
    }

    private String prepareRegistrationEmail(String email, String confirmationUrl) {
        String mailMessage = String.format(registrationText, "http://" + domain + "/registration/confirm/"+confirmationUrl);
        return mailMessage;

    }

    private String generateRandomUrlString() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz_1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }

        return sb.toString();
    }

    private void checkIfUserWithSuchEmailExists(String email) {
        checkIfSuchUserAlreadyInRegistrationProcess(email);
        checkIfUserPresentInDB(email);
    }

    private void checkIfSuchUserAlreadyInRegistrationProcess(String email) {
        for (RegistrationRequest request : container.getAllCurrentRequests())
            if (request.getUserRequest().getEmail().equals(email))
                throw new SuchUserAlreadyExists();
    }

    private void checkIfUserPresentInDB(String email) {

        try {
            User user = userService.fetchUserByEmail(email);
            throw new SuchUserAlreadyExists();
        } catch (NoSuchEntity e){}
    }

    @Override
    public User confirmRegistration(String uniqueUrl) {
        RegistrationRequest registrationRequest = container.getRegistrationRequest(uniqueUrl);
        if (registrationRequest == null)
            throw new UserConfirmationFailed();

        User user = userService.createUser(registrationRequest.getUserRequest());

        container.removeRegistrationRequest(uniqueUrl);

        return user;
    }
}
