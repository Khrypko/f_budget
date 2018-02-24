package ua.com.khrypko.family.budget.exception;

/**
 * Created by Maks on 15.01.2018.
 */
public class ValidationException extends RuntimeException {

    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }
}
