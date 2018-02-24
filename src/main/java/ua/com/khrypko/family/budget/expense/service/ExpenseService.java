package ua.com.khrypko.family.budget.expense.service;


import ua.com.khrypko.family.budget.common.Interval;
import ua.com.khrypko.family.budget.expense.dto.ExpenseDTO;
import ua.com.khrypko.family.budget.expense.entity.Expense;

import java.util.List;

public interface ExpenseService {

    List<Expense> getFamilyExpenses(int familyId, Interval interval);

    Expense createExpense(ExpenseDTO expenseDTO);

    Expense updateExpense(ExpenseDTO expenseDTO);

    Expense getExpense(long expenseId);

}
