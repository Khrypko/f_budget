package ua.com.khrypko.family.budget.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ua.com.khrypko.family.budget.dto.CategoryDTO;
import ua.com.khrypko.family.budget.entity.budget.Category;
import ua.com.khrypko.family.budget.secutity.SecurityUser;
import ua.com.khrypko.family.budget.service.budget.CategoryService;

import java.util.List;

/**
 * Created by maks on 19.11.17.
 */
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/api/category", method = RequestMethod.GET)
    public List<CategoryDTO> getUsersCategories(Authentication authentication){
        SecurityUser currentUser = (SecurityUser) authentication.getPrincipal();
        return categoryService.getCategoriesDTOsByFamilyId(currentUser.getId());
    }

    @RequestMapping(name = "/api/category", method = RequestMethod.POST)
    public ResponseEntity saveCategory(@RequestBody CategoryDTO categoryDTO){
        Category category = categoryService.createCategory(categoryDTO);
        return new ResponseEntity(categoryService.createDTO(category), HttpStatus.OK);
    }

}
