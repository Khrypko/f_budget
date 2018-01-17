package ua.com.khrypko.family.budget.expense.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.khrypko.family.budget.expense.dto.ExpenseDTO;
import ua.com.khrypko.family.budget.category.entity.Category;
import ua.com.khrypko.family.budget.expense.entity.Expense;
import ua.com.khrypko.family.budget.category.service.CategoryService;
import ua.com.khrypko.family.budget.user.entity.Family;
import ua.com.khrypko.family.budget.exception.NoSuchEntity;
import ua.com.khrypko.family.budget.expense.repository.ExpenseRepository;
import ua.com.khrypko.family.budget.user.service.FamilyService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by maks on 22.11.17.
 */
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;
    private CategoryService categoryService;
    private FamilyService familyService;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository, CategoryService categoryService, FamilyService familyService) {
        this.expenseRepository = expenseRepository;
        this.categoryService = categoryService;
        this.familyService = familyService;
    }

    @Override
    public List<Expense> getFamilyExpenses(int familyId) {
        return expenseRepository.findByFamilyIdAndActiveIs(familyId, true);
    }

    @Override
    public List<Expense> getFamilyInactiveExpenses(int familyId) {
        return expenseRepository.findByFamilyIdAndActiveIs(familyId, false);
    }

    @Override
    public Expense getExpense(long expenseId) {
        Expense expense = expenseRepository.getOne(expenseId);
        if (expense == null)
            throw new NoSuchEntity();
        return expense;
    }

    @Override
    public List<ExpenseDTO> getFamilyExpensesDTO(int familyId) {
        return createDTOs(getFamilyExpenses(familyId));
    }

    private List<ExpenseDTO> createDTOs(List<Expense> familyExpenses) {
        return familyExpenses.stream().map(this::createDTO).collect(Collectors.toList());
    }

    private ExpenseDTO createDTO(Expense expense){
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setId(expense.getId());
        expenseDTO.setName(expense.getName());
        expenseDTO.setActive(expense.isActive());
        expenseDTO.setCategoryId(expense.getCategory().getId());
        expenseDTO.setFamilyId(expense.getFamily().getId());

        return expenseDTO;
    }

    @Override
    public List<ExpenseDTO> getFamilyInactiveExpensesDTO(int familyId) {
        return createDTOs(getFamilyInactiveExpenses(familyId));
    }

    @Override
    public ExpenseDTO getExpenseDTO(long expenseId) {
        return createDTO(getExpense(expenseId));
    }

    @Override
    public Expense createExpense(ExpenseDTO expenseDTO) {

        Expense expense = new Expense();
        expense = updateFromDTO(expense, expenseDTO);
        expense.setActive(true);
        expense.setCategory(getCategory(expenseDTO.getCategoryId()));
        expense.setFamily(getFamily(expenseDTO.getFamilyId()));

        return expenseRepository.save(expense);
    }

    private Family getFamily(long familyId) {
        return familyService.getFamily(familyId);
    }

    private Category getCategory(long categoryId) {
        return categoryService.getCategory(categoryId);
    }

    private Expense updateFromDTO(Expense expense, ExpenseDTO expenseDTO) {
        expense.setName(expenseDTO.getName());
        expense.setComment(expenseDTO.getComment());
        return expense;
    }

    @Override
    public Expense updateExpense(ExpenseDTO expenseDTO) {
        Expense expense = getExpense(expenseDTO.getId());
        expense = updateFromDTO(expense, expenseDTO);

        return expenseRepository.save(expense);
    }

    @Override
    public void disableExpense(long expenseId) {
        Expense expense = getExpense(expenseId);
        expense.setActive(false);
        expenseRepository.save(expense);
    }

    @Override
    public void enableExpense(long expenseId) {
        Expense expense = getExpense(expenseId);
        expense.setActive(true);
        expenseRepository.save(expense);
    }
}
