package ua.com.khrypko.family.budget.user.dto;

/**
 * Created by maks on 19.11.17.
 */
public class UserDTO {

    private long id;
    private String name;
    private String surname;
    private String email;
    private long family;

    public UserDTO() {
    }

    public UserDTO(long id, String name, String surname, String email, int family) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.family = family;
    }

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

    public long getFamily() {
        return family;
    }

    public void setFamily(long family) {
        this.family = family;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
