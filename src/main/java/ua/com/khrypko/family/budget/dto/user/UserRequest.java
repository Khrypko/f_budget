package ua.com.khrypko.family.budget.dto.user;

/**
 * Created by Ира on 24.08.2017.
 */
public class UserRequest extends UserDTO{

    private String password;
    private String repeatPassword;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
