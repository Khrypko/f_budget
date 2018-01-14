package ua.com.khrypko.family.budget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.khrypko.family.budget.repository.UserRepository;
import ua.com.khrypko.family.budget.entity.user.User;

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
