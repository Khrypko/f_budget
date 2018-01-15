package ua.com.khrypko.family.budget.secutity;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Created by Ира on 24.08.2017.
 */
public class SecurityUser extends User {

    private ua.com.khrypko.family.budget.entity.user.User user;

    public SecurityUser(ua.com.khrypko.family.budget.entity.user.User user) {
        super(user.getName(), user.getPassword(), AuthorityUtils.createAuthorityList("USER"));
        this.user = user;
    }

    public long getId() {
        return user.getId();
    }

    public String getName() {
        return user.getName();
    }
}
