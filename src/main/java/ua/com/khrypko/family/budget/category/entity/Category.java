package ua.com.khrypko.family.budget.category.entity;

import ua.com.khrypko.family.budget.user.entity.Family;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by maks on 16.11.17.
 */
@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;
    private CategoryType type;

    @OneToOne
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private Set<Category> childs;

    @ManyToMany
//    @JoinTable (
//            name="user_categories",
//            joinColumns = {@JoinColumn(name="user_id")},
//            inverseJoinColumns = {@JoinColumn(name="category_id")}
//    )
    private Set<Family> families;

    private boolean active;

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

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public Set<Category> getChilds() {
        return childs;
    }

    public void setChilds(Set<Category> childs) {
        this.childs = childs;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Family> getFamilies() {
        return families;
    }

    public void setFamilies(Set<Family> families) {
        this.families = families;
    }
}
