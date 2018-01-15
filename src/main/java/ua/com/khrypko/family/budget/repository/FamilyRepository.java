package ua.com.khrypko.family.budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.khrypko.family.budget.entity.user.Family;

/**
 * Created by maks on 19.11.17.
 */
public interface FamilyRepository extends JpaRepository<Family, Long> {
}
