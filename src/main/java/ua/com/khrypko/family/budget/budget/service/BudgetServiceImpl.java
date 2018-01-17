package ua.com.khrypko.family.budget.budget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.khrypko.family.budget.category.entity.Category;
import ua.com.khrypko.family.budget.category.service.CategoryService;
import ua.com.khrypko.family.budget.user.entity.Family;
import ua.com.khrypko.family.budget.user.service.FamilyService;
import ua.com.khrypko.family.budget.user.service.UserService;

/**
 * Created by maks on 19.11.17.
 */
@Service
@Transactional
public class BudgetServiceImpl implements BudgetService {

    private CategoryService categoryService;
    private UserService userService;
    private FamilyService familyService;

    @Autowired
    public BudgetServiceImpl(CategoryService categoryService, UserService userService, FamilyService familyService) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.familyService = familyService;
    }

    @Override
    public void addCategoryToFamily(int familyId, long categoryId) {
        Category category = categoryService.getCategory(categoryId);

        Family family = familyService.getFamily(familyId);
        family.addCategory(category);
    }

}
