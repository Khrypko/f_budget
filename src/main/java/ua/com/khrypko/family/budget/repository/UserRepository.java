package ua.com.khrypko.family.budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.khrypko.family.budget.entity.user.User;

import java.util.Optional;

/**
 * Created by Ира on 22.08.2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    //List<User> findByName(String name);

    Optional<User> findById(int id);

    Optional<User> findOneByName(String name);

}
