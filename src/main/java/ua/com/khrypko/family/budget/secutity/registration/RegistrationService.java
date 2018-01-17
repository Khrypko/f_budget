package ua.com.khrypko.family.budget.secutity.registration;

import ua.com.khrypko.family.budget.user.dto.UserRequest;
import ua.com.khrypko.family.budget.user.entity.User;

/**
 * Created by Maks on 15.01.2018.
 */
public interface RegistrationService {

    void performCreateRequest(UserRequest userRequest);

    User confirmRegistration(String uniqueUrl);

}
