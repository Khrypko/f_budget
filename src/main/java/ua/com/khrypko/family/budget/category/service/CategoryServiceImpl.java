package ua.com.khrypko.family.budget.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.khrypko.family.budget.category.repository.CategoryRepository;
import ua.com.khrypko.family.budget.category.dto.CategoryDTO;
import ua.com.khrypko.family.budget.category.entity.Category;
import ua.com.khrypko.family.budget.exception.NoSuchEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by maks on 16.11.17.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategory(long id) {
        Category category = categoryRepository.findOne(id);
        if (category != null)
            return category;

        throw new NoSuchEntity();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getCategoryByCriteria(CategoryDTO example) {
        //TODO implement
        return null;
    }

    @Override
    public List<Category> getCategoriesByFamilyId(long familyId) {
        return categoryRepository.getCategoriesByFamiliesId(familyId);
    }

    @Override
    public List<CategoryDTO> getCategoriesDTOsByFamilyId(long userId) {
        return getCategoriesByFamilyId(userId)
                .stream()
                .map(this::createCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryDTO(long id) {
        return createCategoryDTO(getCategory(id));
    }

    private CategoryDTO createCategoryDTO(Category category) {
        return CategoryDTO.createFromCategory(category);
    }

    @Override
    public List<CategoryDTO> getAllCategoriesDTO() {
        return getAllCategories().stream()
                .map(this::createCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryDTO> getCategoryDTOByCriteria(CategoryDTO example) {
        //TODO implement
        return null;
    }

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();

        category = updaterFor(category, categoryDTO)
                .updateName()
                .updateType()
                .updateParent()
                .updateActive(true)
                .update();

        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(CategoryDTO categoryDTO) {
        Category category = getCategory(categoryDTO.getId());

        category = updaterFor(category, categoryDTO)
                .updateName()
                .update();

        return categoryRepository.save(category);
    }

    @Override
    public Category remapCategory(long categoryWhichRemapId, long parentCategoryId) {
        Category category = getCategory(categoryWhichRemapId);
        Category parent = getCategory(parentCategoryId);

        category.setParent(parent);

        return categoryRepository.save(category);
    }

    @Override
    public CategoryDTO createDTO(Category category) {
        return createCategoryDTO(category);
    }

    @Override
    public void disableCategory(long categoryId) {
        Category category = getCategory(categoryId);
        category.setActive(false);
        categoryRepository.save(category);
    }

    private CategoryUpdater updaterFor(Category category, CategoryDTO categoryDTO){
        return new CategoryUpdater(category, categoryDTO);
    }

    private class CategoryUpdater {

        private Category category;
        private CategoryDTO categoryDTO;

        public CategoryUpdater(Category category, CategoryDTO categoryDTO) {
            this.category = category;
            this.categoryDTO = categoryDTO;
        }

        public CategoryUpdater updateName(){
            category.setName(categoryDTO.getName());
            return this;
        }

        public CategoryUpdater updateParent(){
            if (categoryDTO.getParentId() != 0)
                category.setParent(getCategory(categoryDTO.getParentId()));

            return this;
        }

        public CategoryUpdater updateActive(boolean active){
            category.setActive(active);
            return this;
        }

        public CategoryUpdater updateType(){
            category.setType(categoryDTO.getType());
            return this;
        }

        public Category update(){
            return category;
        }
    }
}
