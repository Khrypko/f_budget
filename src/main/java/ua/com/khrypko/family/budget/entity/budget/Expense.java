package ua.com.khrypko.family.budget.entity.budget;

import org.hibernate.annotations.Type;
import ua.com.khrypko.family.budget.entity.user.Family;
import ua.com.khrypko.family.budget.entity.user.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Ира on 22.08.2017.
 */
@Entity
@Table(name = "EXPENSE")
public class Expense {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String name;
    private String comment;

    private boolean active;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Family family;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
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

        Expense expense = (Expense) o;

        if (id != expense.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
