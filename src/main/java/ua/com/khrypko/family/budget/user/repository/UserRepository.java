package ua.com.khrypko.family.budget.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.khrypko.family.budget.user.entity.User;

import java.util.Optional;

/**
 * Created by Ира on 22.08.2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findById(long id);

    Optional<User> findOneByName(String name);

    Optional<User> findOneByEmail(String email);

    boolean existsByEmail(String email);

}
