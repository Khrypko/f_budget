package ua.com.khrypko.family.budget.user.service;

import ua.com.khrypko.family.budget.user.dto.UserRequest;
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
