package ua.com.khrypko.family.budget.user.dto;

/**
 * Created by Ира on 24.08.2017.
 */
public class UserRequest extends UserDTO{

    private String password;
    private String repeatPassword;
    private String familyUrl;

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

    public String getFamilyUrl() {
        return familyUrl;
    }

    public void setFamilyUrl(String familyUrl) {
        this.familyUrl = familyUrl;
    }
}
