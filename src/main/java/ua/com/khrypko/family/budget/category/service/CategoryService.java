package ua.com.khrypko.family.budget.category.service;

import ua.com.khrypko.family.budget.category.dto.CategoryDTO;
import ua.com.khrypko.family.budget.category.entity.Category;

import java.util.List;

/**
 * Created by maks on 16.11.17.
 */
public interface CategoryService {

    public Category getCategory(long id);
    public List<Category> getAllCategories();
    public List<Category> getCategoryByCriteria(CategoryDTO example);

    public List<Category> getCategoriesByFamilyId(long userId);
    public List<CategoryDTO> getCategoriesDTOsByFamilyId(long userId);

    public CategoryDTO getCategoryDTO(long id);
    public List<CategoryDTO> getAllCategoriesDTO();
    public List<CategoryDTO> getCategoryDTOByCriteria(CategoryDTO example);

    public Category createCategory(CategoryDTO categoryDTO);
    public Category updateCategory(CategoryDTO categoryDTO);
    public Category remapCategory(long categoryWhichRemapId, long parentCategoryId);

    public CategoryDTO createDTO(Category category);

    public void disableCategory(long categoryId);


}
