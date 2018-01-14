package ua.com.khrypko.family.budget.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.khrypko.family.budget.repository.UserRepository;
import ua.com.khrypko.family.budget.dto.UserDTO;
import ua.com.khrypko.family.budget.entity.user.User;
import ua.com.khrypko.family.budget.exception.NoSuchEntity;
import ua.com.khrypko.family.budget.secutity.SecurityUser;

/**
 * Created by Ира on 24.08.2017.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findOneByName(s).orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", s)));
        return new SecurityUser(user);
    }

    @Override
    public User getUser(int userId) {
        return userRepository.findById(userId).orElseThrow(NoSuchEntity::new);
    }

    @Override
    public UserDTO createDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setFamily(user.getFamily().getId());

        System.out.println(userDTO);

        return userDTO;
    }
}
