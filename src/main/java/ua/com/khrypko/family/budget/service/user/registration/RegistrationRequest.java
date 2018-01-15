package ua.com.khrypko.family.budget.service.user.registration;

import ua.com.khrypko.family.budget.dto.user.UserRequest;

import java.util.Date;

/**
 * Created by max on 06.01.17.
 */
public class RegistrationRequest extends AbstractRegistrationRequest{

    private static final long MAX_WAIT_TIME = 1000000;

    private UserRequest userRequest;

    public RegistrationRequest(UserRequest userRequest, String uniqueId) {
        super(new Date(), uniqueId);
        this.userRequest = userRequest;
    }

    public UserRequest getUserRequest() {
        return userRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistrationRequest that = (RegistrationRequest) o;

        return userRequest.equals(that.userRequest);

    }

    @Override
    public int hashCode() {
        return userRequest.hashCode();
    }
}
