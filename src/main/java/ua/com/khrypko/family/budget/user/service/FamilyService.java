package ua.com.khrypko.family.budget.user.service;

import ua.com.khrypko.family.budget.common.Options;
import ua.com.khrypko.family.budget.user.dto.FamilyDto;
import ua.com.khrypko.family.budget.user.entity.Family;

import java.util.Set;

/**
 * Created by maks on 19.11.17.
 */
public interface FamilyService {

    Family getFamily(long id);
    Set<Family> getFamilyByUser(long userId);

    Family createFamily(FamilyDto familyDTO);
    Family addUser(long familyId, long userId);
    Family removeUser(long familyId, long userId);
    Family updateFamily(FamilyDto familyDTO);

}
