package ua.com.khrypko.family.budget.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.khrypko.family.budget.dto.user.UserRequest;
import ua.com.khrypko.family.budget.entity.user.Family;
import ua.com.khrypko.family.budget.exception.ValidationException;
import ua.com.khrypko.family.budget.repository.FamilyRepository;
import ua.com.khrypko.family.budget.repository.UserRepository;
import ua.com.khrypko.family.budget.dto.user.UserDTO;
import ua.com.khrypko.family.budget.entity.user.User;
import ua.com.khrypko.family.budget.exception.NoSuchEntity;
import ua.com.khrypko.family.budget.secutity.SecurityUser;

import javax.transaction.Transactional;

/**
 * Created by Ира on 24.08.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService{

    private UserRepository userRepository;
    private FamilyRepository familyRepository;

    @Autowired
    public UserServiceImpl(FamilyRepository familyRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.familyRepository = familyRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findOneByEmail(s).orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", s)));
        return new SecurityUser(user);
    }



    @Override
    public User getUser(long userId) {
        return userRepository.findById(userId).orElseThrow(NoSuchEntity::new);
    }

    @Override
    public User fetchUserByEmail(String email) {
        return userRepository.findOneByEmail(email).orElseThrow(NoSuchEntity::new);
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

    @Override
    public User createUser(UserRequest request) {
        UserUtils.validateRequest(request);

        User user = new User();
        user = updateFromDTO(user, request);
        user.setPassword(request.getPassword());
        user.setFamily(loadFamily(request));

        return userRepository.save(user);
    }

    private User updateFromDTO(User user ,UserDTO request) {
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        return user;
    }

    private Family loadFamily(UserDTO request) {
        if (request.getFamily() == 0)
            return null;
        return familyRepository.getOne(request.getFamily());
    }

    //TODO
    @Override
    public User updateUser(UserDTO userDTO) {
        return null;
    }
}
