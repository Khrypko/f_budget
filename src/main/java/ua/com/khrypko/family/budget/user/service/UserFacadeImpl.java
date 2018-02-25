package ua.com.khrypko.family.budget.user.service;

import org.springframework.stereotype.Service;
import ua.com.khrypko.family.budget.exception.NoSuchEntity;
import ua.com.khrypko.family.budget.user.dto.FamilyDto;
import ua.com.khrypko.family.budget.user.dto.UserDTO;
import ua.com.khrypko.family.budget.user.dto.UserRequest;
import ua.com.khrypko.family.budget.user.entity.Family;
import ua.com.khrypko.family.budget.user.entity.User;

import javax.transaction.Transactional;

/**
 * Created by Maks on 17.01.2018.
 */
@Service
@Transactional
public class UserFacadeImpl implements UserFacade {

    private UserService userService;
    private FamilyService familyService;

    public UserFacadeImpl(UserService userService, FamilyService familyService) {
        this.userService = userService;
        this.familyService = familyService;
    }

    @Override
    public User createUser(UserRequest request) {
        User user = userService.createUser(request);
        user.setFamily(loadOrCreateFamily(request));
        return userService.updateUser(user);
    }

    private Family loadOrCreateFamily(UserRequest request) {
        if (request.getFamilyUrl() == null)
            return createNewFamily();
        return familyService.getFamilyByUniqueUrl(request.getFamilyUrl());
    }

    private Family createNewFamily() {
        return familyService.createFamily(FamilyDto.empty());
    }

    @Override
    public FamilyDto addUserToFamily(long familyId, long userId) {
        Family family = familyService.getFamily(familyId);
        User user = userService.getUser(userId);
        family.addUser(user);

        return createFamilyDto(familyService.updateFamily(family));
    }

    //TODO: reimplement, maybe use FamilyDtoConverter
    private FamilyDto createFamilyDto(Family family) {
        FamilyDto familyDto = new FamilyDto();
        familyDto.setId(family.getId());
        familyDto.setName(family.getName());
        familyDto.setUniqueId(family.getUniqueUrl());
        return familyDto;
    }

    @Override
    public FamilyDto removeUserFromFamily(long familyId, long userId) {
        Family family = familyService.getFamily(familyId);
        User user = userService.getUser(userId);
        family.removeUser(user);

        return createFamilyDto(familyService.updateFamily(family));

    }

    @Override
    public boolean userExist(String email) {
        return userService.userExist(email);
    }

    @Override
    public FamilyDto updateFamilyName(FamilyDto familyDTO) {
        Family family = familyService.getFamily(familyDTO.getId());
        if (family == null)
            throw new NoSuchEntity();
        family.setName(familyDTO.getName());
        return createFamilyDto(familyService.updateFamily(family));
    }
}
