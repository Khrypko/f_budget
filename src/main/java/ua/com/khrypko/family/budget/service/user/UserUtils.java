package ua.com.khrypko.family.budget.service.user;

import ua.com.khrypko.family.budget.dto.user.UserRequest;
import ua.com.khrypko.family.budget.exception.ValidationException;

/**
 * Created by Maks on 15.01.2018.
 */
public class UserUtils {

    public static void validateRequest(UserRequest request) {
        if (request == null
                || emptyField(request.getEmail())
                || emptyField(request.getName())
                || emptyField(request.getPassword()))
            throw new ValidationException();

    }

    private static boolean emptyField(String string) {
        return string == null || string.isEmpty();
    }

}
