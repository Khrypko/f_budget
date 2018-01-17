package ua.com.khrypko.family.budget.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.khrypko.family.budget.user.dto.UserRequest;
import ua.com.khrypko.family.budget.secutity.registration.RegistrationService;

import java.util.Optional;

/**
 * Created by Ира on 24.08.2017.
 */
@Controller
public class LoginController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        return new ModelAndView("login", "error", error);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView getRegistrationPage(@RequestParam Optional<String> error) {
        return new ModelAndView("registration", "error", error);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("userRequest") UserRequest userRequest) {
        registrationService.performCreateRequest(userRequest);
        return "thanks_for_registration";
    }

    @RequestMapping(value = "/registration/confirm/{uniqueUrl}", method = RequestMethod.GET)
    public String confirmRegistration(@PathVariable("uniqueUrl") String uniqueUrl) {
        registrationService.confirmRegistration(uniqueUrl);
        return "redirect:/login";
    }

}
