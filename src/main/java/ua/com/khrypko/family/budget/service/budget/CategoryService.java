package ua.com.khrypko.family.budget.service.budget;

import ua.com.khrypko.family.budget.dto.CategoryDTO;
import ua.com.khrypko.family.budget.entity.budget.Category;

import java.util.List;

/**
 * Created by maks on 16.11.17.
 */
public interface CategoryService {

    public Category getCategory(long id);
    public List<Category> getAllCategories();
    public List<Category> getCategoryByCriteria(CategoryDTO example);

    public List<Category> getCategoriesByFamilyId(int userId);
    public List<CategoryDTO> getCategoriesDTOsByFamilyId(int userId);

    public CategoryDTO getCategoryDTO(long id);
    public List<CategoryDTO> getAllCategoriesDTO();
    public List<CategoryDTO> getCategoryDTOByCriteria(CategoryDTO example);

    public Category createCategory(CategoryDTO categoryDTO);
    public Category updateCategory(CategoryDTO categoryDTO);
    public Category remapCategory(long categoryWhichRemapId, long parentCategoryId);

    public CategoryDTO createDTO(Category category);

    public void disableCategory(long categoryId);


}
