package ua.com.khrypko.family.budget.dto;

import java.util.List;
import java.util.Set;

/**
 * Created by maks on 19.11.17.
 */
public class FamilyDTO {

    private int id;
    private String name;

    private List<UserDTO> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
