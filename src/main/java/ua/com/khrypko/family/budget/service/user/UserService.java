package ua.com.khrypko.family.budget.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.com.khrypko.family.budget.dto.user.UserDTO;
import ua.com.khrypko.family.budget.dto.user.UserRequest;
import ua.com.khrypko.family.budget.entity.user.User;

/**
 * Created by Ира on 24.08.2017.
 */
public interface UserService {

    User getUser(long userId);

    User fetchUserByEmail(String email);

    UserDTO createDTO(User user);

    User createUser(UserRequest request);

    User updateUser(UserDTO userDTO);

}
