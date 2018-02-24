package ua.com.khrypko.family.budget.user.service;

import ua.com.khrypko.family.budget.common.Options;
import ua.com.khrypko.family.budget.user.dto.UserDTO;
import ua.com.khrypko.family.budget.user.dto.UserRequest;
import ua.com.khrypko.family.budget.user.entity.User;

/**
 * Created by Ира on 24.08.2017.
 */
public interface UserService {

    User getUser(long userId);

    User fetchUserByEmail(String email);

    boolean userExist(String email);

    UserDTO createDTO(User user, Options<Options.StringOption> options);

    User createUser(UserRequest request);

    User updateUser(UserDTO userDTO);

}
