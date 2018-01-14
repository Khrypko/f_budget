package ua.com.khrypko.family.budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.khrypko.family.budget.entity.budget.ExpenseEntry;

import java.util.List;

/**
 * Created by maks on 16.11.17.
 */
public interface ExpenseEntryRepository extends JpaRepository<ExpenseEntry, Long> {

}
