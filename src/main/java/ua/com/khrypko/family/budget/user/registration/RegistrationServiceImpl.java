package ua.com.khrypko.family.budget.user.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import ua.com.khrypko.family.budget.common.RandomStringGenerator;
import ua.com.khrypko.family.budget.user.dto.UserRequest;
import ua.com.khrypko.family.budget.user.entity.User;
import ua.com.khrypko.family.budget.exception.MailSendingProblem;
import ua.com.khrypko.family.budget.user.exception.SuchUserAlreadyExists;
import ua.com.khrypko.family.budget.user.exception.UserConfirmationFailed;
import ua.com.khrypko.family.budget.user.registration.request.RegistrationRequest;
import ua.com.khrypko.family.budget.user.service.UserFacade;
import ua.com.khrypko.family.budget.user.service.UserService;
import ua.com.khrypko.family.budget.user.service.UserUtils;

/**
 * Created by Maks on 15.01.2018.
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Value("${mailtext.registration_subject}")
    private String registrationSubject;
    @Value("${mailtext.registration_text}")
    private String registrationText;
    @Value("${mailtext.domain}")
    private String domain;
    @Value("${mailtext.url}")
    private String url;

    private MailSender mailSender;

    private UserFacade userFacade;

    private TemporaryUserContainer container;

    @Autowired
    public RegistrationServiceImpl(MailSender mailSender, UserFacade userFacade) {
        container = new TemporaryUserContainer();
        this.userFacade = userFacade;
        this.mailSender = mailSender;
    }

    public RegistrationServiceImpl(MailSender mailSender, UserFacade userFacade, TemporaryUserContainer container) {
        this.mailSender = mailSender;
        this.userFacade = userFacade;
        this.container = container;
    }

    @Override
    public void performCreateRequest(UserRequest userRequest) {
        UserUtils.validateRequest(userRequest);

        checkIfUserWithSuchEmailExists(userRequest.getEmail());

        String newRandomUrl = RandomStringGenerator.generateRandomUrlString();
        RegistrationRequest registrationRequest = new RegistrationRequest(userRequest, newRandomUrl);

        container.addRegistrationRequest(newRandomUrl, registrationRequest);

        sendRegistrationEmail(registrationRequest, newRandomUrl);
    }

    private void sendRegistrationEmail(RegistrationRequest registrationRequest, String newRandomUrl) {
        String email = registrationRequest.getUserRequest().getEmail();
        String mailText = prepareRegistrationEmail(newRandomUrl);
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

    private String prepareRegistrationEmail(String confirmationUrl) {
        return String.format(registrationText, "http://" + domain + url + confirmationUrl);

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
        if (userFacade.userExist(email))
            throw new SuchUserAlreadyExists();
    }

    @Override
    public User confirmRegistration(String uniqueUrl) {
        RegistrationRequest registrationRequest = container.getRegistrationRequest(uniqueUrl);
        if (registrationRequest == null)
            throw new UserConfirmationFailed();

        User user = userFacade.createUser(registrationRequest.getUserRequest());

        container.removeRegistrationRequest(uniqueUrl);

        return user;
    }

    public RegistrationServiceImpl setRegistrationSubject(String registrationSubject) {
        this.registrationSubject = registrationSubject;
        return this;
    }

    public RegistrationServiceImpl setRegistrationText(String registrationText) {
        this.registrationText = registrationText;
        return this;
    }

    public RegistrationServiceImpl setDomain(String domain) {
        this.domain = domain;
        return this;
    }
}
