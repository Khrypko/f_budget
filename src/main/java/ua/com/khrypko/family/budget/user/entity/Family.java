package ua.com.khrypko.family.budget.user.entity;

import ua.com.khrypko.family.budget.category.entity.Category;
import ua.com.khrypko.family.budget.expense.entity.Expense;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by maks on 19.11.17.
 */
@Entity
public class Family {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "family")
    private Set<User> users = new HashSet<>();

    @ManyToMany(mappedBy = "families")
    private Set<Category> categories = new HashSet<>();

    @OneToMany
    private Set<Expense> familyExpenses;

    @Column(name = "uniqueId")
    private String uniqueUrl;

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void removeUser(User user){
        this.users.remove(user);
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category){
        categories.add(category);
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Expense> getFamilyExpenses() {
        return familyExpenses;
    }

    public void setFamilyExpenses(Set<Expense> familyExpenses) {
        this.familyExpenses = familyExpenses;
    }

    public String getUniqueUrl() {
        return uniqueUrl;
    }

    public void setUniqueUrl(String uniqueUrl) {
        this.uniqueUrl = uniqueUrl;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Family family = (Family) o;

        if (id != family.id) return false;
        if (active != family.active) return false;
        if (!name.equals(family.name)) return false;
        return uniqueUrl.equals(family.uniqueUrl);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + uniqueUrl.hashCode();
        result = 31 * result + (active ? 1 : 0);
        return result;
    }
}
