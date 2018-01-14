package ua.com.khrypko.family.budget.dto;

/**
 * Created by maks on 19.11.17.
 */
public class UserDTO {

    private int id;
    private String name;
    private int family;

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

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
    }
}
