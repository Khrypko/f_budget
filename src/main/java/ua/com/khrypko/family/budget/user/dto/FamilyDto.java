package ua.com.khrypko.family.budget.user.dto;

import java.util.List;

/**
 * Created by maks on 19.11.17.
 */
public class FamilyDto {

    private long id;
    private String name;
    private String uniqueId;

    public static FamilyDto empty(){
        return new FamilyDto();
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

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

}
