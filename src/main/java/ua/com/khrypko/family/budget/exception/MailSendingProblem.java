package ua.com.khrypko.family.budget.exception;

/**
 * Created by Maks on 15.01.2018.
 */
public class MailSendingProblem extends RuntimeException {
    public MailSendingProblem(Throwable cause) {
        super(cause);
    }
}
