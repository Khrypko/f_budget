package ua.com.khrypko.family.budget.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.khrypko.family.budget.expense.entity.Expense;

import java.util.List;

/**
 * Created by Ира on 22.08.2017.
 */
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByFamilyIdAndActiveIs(Integer id, boolean active);

}
