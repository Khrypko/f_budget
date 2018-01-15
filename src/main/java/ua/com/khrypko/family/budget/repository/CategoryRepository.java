package ua.com.khrypko.family.budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.khrypko.family.budget.entity.budget.Category;

import java.util.List;

/**
 * Created by maks on 16.11.17.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

    public List<Category> getCategoriesByFamiliesId(long familyId);

}
