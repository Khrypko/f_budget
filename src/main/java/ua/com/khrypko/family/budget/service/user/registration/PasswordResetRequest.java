package ua.com.khrypko.family.budget.service.user.registration;

import java.util.Date;

/**
 * Created by max on 16.03.17.
 */
public class PasswordResetRequest extends AbstractRegistrationRequest {

    private long userId;

    public PasswordResetRequest(long userId, String uniqueId) {
        super(new Date(),uniqueId);
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }


}
