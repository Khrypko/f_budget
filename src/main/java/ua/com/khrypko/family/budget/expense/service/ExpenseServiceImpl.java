package ua.com.khrypko.family.budget.expense.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ua.com.khrypko.family.budget.common.Interval;
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

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository, CategoryService categoryService) {
        this.expenseRepository = expenseRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<Expense> getFamilyExpenses(int familyId, Interval interval) {
        throw new NotImplementedException();
    }

    @Override
    public Expense getExpense(long expenseId) {
        Expense expense = expenseRepository.getOne(expenseId);
        if (expense == null)
            throw new NoSuchEntity();
        return expense;
    }

//    private List<ExpenseDTO> createDTOs(List<Expense> familyExpenses) {
//        return familyExpenses.stream().map(this::createDTO).collect(Collectors.toList());
//    }

//    private ExpenseDTO createDTO(Expense expense){
//        ExpenseDTO expenseDTO = new ExpenseDTO();
//        expenseDTO.setId(expense.getId());
//        expenseDTO.setName(expense.getName());
//        expenseDTO.setActive(expense.isActive());
//        expenseDTO.setCategoryId(expense.getCategory().getId());
//        expenseDTO.setFamilyId(expense.getFamily().getId());
//
//        return expenseDTO;
//    }


    @Override
    //TODO: implement
    public Expense createExpense(ExpenseDTO expenseDTO) {

        Expense expense = new Expense();
        expense = updateFromDTO(expense, expenseDTO);
        expense.setCategory(getCategory(expenseDTO.getCategoryId()));


        //return expenseRepository.save(expense);
        throw new NotImplementedException();
    }

    private Category getCategory(long categoryId) {
        return categoryService.getCategory(categoryId);
    }

    //TODO implement
    private Expense updateFromDTO(Expense expense, ExpenseDTO expenseDTO) {
        expense.setComment(expenseDTO.getComment());
        return expense;
    }

    @Override
    public Expense updateExpense(ExpenseDTO expenseDTO) {
        Expense expense = getExpense(expenseDTO.getId());
        expense = updateFromDTO(expense, expenseDTO);

        return expenseRepository.save(expense);
    }

}
