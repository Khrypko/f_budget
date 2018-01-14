package ua.com.khrypko.family.budget.dto;

/**
 * Created by maks on 03.12.17.
 */
public class ExpenseEntryDTO {

    private String expenseDate;
    private String amount;
    private int expense;

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }
}
