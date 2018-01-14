package ua.com.khrypko.family.budget.service.user;

import ua.com.khrypko.family.budget.dto.UserDTO;
import ua.com.khrypko.family.budget.entity.user.User;

/**
 * Created by Ира on 24.08.2017.
 */
public interface UserService {

    User getUser(int userId);

    UserDTO createDTO(User user);

}
