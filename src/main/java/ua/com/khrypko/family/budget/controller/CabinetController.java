package ua.com.khrypko.family.budget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Ира on 24.08.2017.
 */
@Controller
public class CabinetController {

    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
    public String getCabinetMain() {
        return "cabinet/cabinet";
    }

}
