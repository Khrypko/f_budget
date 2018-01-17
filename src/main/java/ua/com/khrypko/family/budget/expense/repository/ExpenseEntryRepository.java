package ua.com.khrypko.family.budget.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.khrypko.family.budget.expense.entity.ExpenseEntry;

/**
 * Created by maks on 16.11.17.
 */
public interface ExpenseEntryRepository extends JpaRepository<ExpenseEntry, Long> {

}
