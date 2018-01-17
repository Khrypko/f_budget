package ua.com.khrypko.family.budget.user.dto;

import java.util.List;

/**
 * Created by Maks on 17.01.2018.
 */
public class FamilyDtoWithUsers extends FamilyDto {

    private List<UserDTO> users;

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
