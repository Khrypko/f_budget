package ua.com.khrypko.family.budget.service.budget;


import ua.com.khrypko.family.budget.dto.ExpenseDTO;
import ua.com.khrypko.family.budget.entity.budget.Expense;

import java.util.List;

public interface ExpenseService {

    List<Expense> getFamilyExpenses(int familyId);

    List<Expense> getFamilyInactiveExpenses(int familyId);

    Expense getExpense(long expenseId);

    List<ExpenseDTO> getFamilyExpensesDTO(int familyId);

    List<ExpenseDTO> getFamilyInactiveExpensesDTO(int familyId);

    ExpenseDTO getExpenseDTO(long expenseId);

    Expense createExpense(ExpenseDTO expenseDTO);

    Expense updateExpense(ExpenseDTO expenseDTO);

    void disableExpense(long expenseId);

    void enableExpense(long expenseId);

}
