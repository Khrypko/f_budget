package ua.com.khrypko.family.budget.service.budget;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ua.com.khrypko.family.budget.category.repository.CategoryRepository;
import ua.com.khrypko.family.budget.category.entity.Category;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTest extends TestCase {

    @Mock
    private CategoryRepository categoryRepository;

//    @Before
    public void setUp(){
        setUpEntriesInRepository();
    }

    public void testGetCategory() throws Exception {



    }

    public void testGetAllCategories() throws Exception {

    }

    public void testGetCategoryDTO() throws Exception {

    }

    public void testGetAllCategoriesDTO() throws Exception {

    }

    public void testCreateCategory() throws Exception {

    }

    public void testUpdateCategory() throws Exception {

    }

    public void testDisableCategory() throws Exception {

    }

    private void setUpEntriesInRepository() {
        List<Category> categories = new ArrayList<>();

    }
}