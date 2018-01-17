package ua.com.khrypko.family.budget.secutity.registration;

import java.util.Date;

/**
 * Created by max on 16.03.17.
 */
public abstract class AbstractRegistrationRequest {

    private static final long MAX_WAIT_TIME = 1000000;
    private Date requestDate;
    private String uniqueId;

    public AbstractRegistrationRequest(Date requestDate, String uniqueId) {
        this.requestDate = requestDate;
        this.uniqueId = uniqueId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public boolean expired(){
        long currentTime = System.currentTimeMillis();
        if (currentTime - requestDate.getTime() > MAX_WAIT_TIME)
            return true;

        return false;
    }

    public String getUniqueId() {
        return uniqueId;
    }

}
