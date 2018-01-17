package ua.com.khrypko.family.budget.expense.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by maks on 16.11.17.
 */
@Entity
@Table(name = "EXPENSE_ENTRY")
public class ExpenseEntry {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Type(type="date")
    private Date date;

    private BigDecimal amount;

    @ManyToOne
    private Expense expense;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }
}
