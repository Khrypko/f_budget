package ua.com.khrypko.family.budget.user.service;

import ua.com.khrypko.family.budget.common.Options;
import ua.com.khrypko.family.budget.user.dto.FamilyDto;
import ua.com.khrypko.family.budget.user.dto.FamilyDtoWithUsers;
import ua.com.khrypko.family.budget.user.dto.UserDTO;
import ua.com.khrypko.family.budget.user.dto.UserRequest;
import ua.com.khrypko.family.budget.user.entity.Family;
import ua.com.khrypko.family.budget.user.entity.User;

/**
 * Created by Maks on 17.01.2018.
 */
public interface UserFacade {

    User createUser(UserRequest request);

    FamilyDto updateFamilyName(FamilyDto familyDTO);

    FamilyDto addUserToFamily(long familyId, long userId);

    FamilyDto removeUserFromFamily(long familyId, long userId);

    boolean userExist(String email);
}
