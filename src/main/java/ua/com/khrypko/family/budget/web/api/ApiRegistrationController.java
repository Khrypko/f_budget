package ua.com.khrypko.family.budget.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.khrypko.family.budget.exception.ValidationException;
import ua.com.khrypko.family.budget.user.dto.UserRequest;
import ua.com.khrypko.family.budget.user.exception.SuchUserAlreadyExists;
import ua.com.khrypko.family.budget.user.exception.UserConfirmationFailed;
import ua.com.khrypko.family.budget.user.registration.RegistrationService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maks on 24.02.2018.
 */
@RestController
@RequestMapping("/api/registration")
public class ApiRegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Value("${registration.fail_url}")
    private String failUrl;

    @Value("${registration.success_url}")
    private String successUrl;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createRegistrationRequest(@RequestBody UserRequest registrationRequest){
        try {
            registrationService.performCreateRequest(registrationRequest);
            return new ResponseEntity(HttpStatus.OK);
        } catch (ValidationException e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } catch (SuchUserAlreadyExists e){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/confirm/{uniqueUrl}", method = RequestMethod.GET)
    public void confirmRegistration(@PathVariable("uniqueUrl") String uniqueUrl, HttpServletResponse response) throws IOException {
        try {
            registrationService.confirmRegistration(uniqueUrl);
            response.sendRedirect(successUrl);
        } catch (UserConfirmationFailed e){
            response.sendRedirect(failUrl);
        }
    }

}
