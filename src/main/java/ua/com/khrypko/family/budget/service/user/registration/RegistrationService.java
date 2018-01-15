package ua.com.khrypko.family.budget.service.user.registration;

import ua.com.khrypko.family.budget.dto.user.UserRequest;
import ua.com.khrypko.family.budget.entity.user.User;

/**
 * Created by Maks on 15.01.2018.
 */
public interface RegistrationService {

    void performCreateRequest(UserRequest userRequest);

    User confirmRegistration(String uniqueUrl);

}
