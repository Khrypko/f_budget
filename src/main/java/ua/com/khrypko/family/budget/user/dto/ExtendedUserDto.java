package ua.com.khrypko.family.budget.user.dto;

import java.util.List;

public class ExtendedUserDto extends UserDTO {

    public ExtendedUserDto() {
    }

    public ExtendedUserDto(long id, String name, String surname, String email, int family, List<Long> families) {
        super(id, name, surname, email, family);
        this.families = families;
    }

    private List<Long> families;

    public List<Long> getFamilies() {
        return families;
    }

    public void setFamilies(List<Long> families) {
        this.families = families;
    }
}
