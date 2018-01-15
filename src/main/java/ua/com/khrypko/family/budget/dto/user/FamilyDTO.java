package ua.com.khrypko.family.budget.dto.user;

import java.util.List;

/**
 * Created by maks on 19.11.17.
 */
public class FamilyDTO {

    private long id;
    private String name;

    private List<UserDTO> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
