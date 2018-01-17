package ua.com.khrypko.family.budget.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.khrypko.family.budget.user.repository.UserRepository;
import ua.com.khrypko.family.budget.user.entity.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Ира on 22.08.2017.
 */
//@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/test")
    public List<User> getTestUsers(Authentication authentication){
        UserDetails currentUser = (UserDetails) authentication.getPrincipal();
        System.out.println(currentUser.getUsername());
        System.out.println(currentUser.getAuthorities());
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());

    }

}
