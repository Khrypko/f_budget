package ua.com.khrypko.family.budget.dto;

import ua.com.khrypko.family.budget.entity.budget.Category;
import ua.com.khrypko.family.budget.entity.budget.CategoryType;

/**
 * Created by maks on 16.11.17.
 */
public class CategoryDTO {

    private long id;
    private String name;
    private CategoryType type;
    private long parentId;
    private boolean active;
    private long familyId;

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

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(long familyId) {
        this.familyId = familyId;
    }

    public static CategoryDTO createFromCategory(Category category){
        CategoryDTO dto = new CategoryDTO();
        dto.id = category.getId();
        dto.name = category.getName();
        dto.parentId =  category.getParent() != null ? category.getParent().getId() : 0;
        dto.type = category.getType();
        dto.active = category.isActive();

        return dto;
    }
}
