package ua.com.khrypko.family.budget.web.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by maks on 19.11.17.
 */
//@Controller
public class ApiCabinetController {

    @RequestMapping(name = "/api/user/category", method = RequestMethod.POST)
    public ResponseEntity addCategoryToUser(){
        return new ResponseEntity(HttpStatus.OK);
    }

}
