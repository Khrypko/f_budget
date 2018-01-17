package ua.com.khrypko.family.budget.user.facade;

import ua.com.khrypko.family.budget.user.dto.FamilyDto;
import ua.com.khrypko.family.budget.user.dto.FamilyDtoWithUsers;

/**
 * Created by Maks on 17.01.2018.
 */
public interface UserFacade {

    FamilyDto createFamily(FamilyDtoWithUsers familyDtoWithUsers);
}
