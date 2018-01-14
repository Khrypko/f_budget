package ua.com.khrypko.family.budget.entity.user;

import ua.com.khrypko.family.budget.entity.budget.Category;
import ua.com.khrypko.family.budget.entity.budget.Expense;

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
    private int id;
    private String name;

    @OneToMany
    private Set<User> users = new HashSet<>();

    @ManyToMany(mappedBy = "families")
    private Set<Category> categories = new HashSet<>();

    @OneToMany
    private Set<Expense> familyExpenses;

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
}
