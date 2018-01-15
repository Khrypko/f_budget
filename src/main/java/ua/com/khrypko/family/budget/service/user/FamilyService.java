package ua.com.khrypko.family.budget.service.user;

import ua.com.khrypko.family.budget.dto.user.FamilyDTO;
import ua.com.khrypko.family.budget.entity.user.Family;

/**
 * Created by maks on 19.11.17.
 */
public interface FamilyService {

    Family getFamily(long id);
    Family getFamilyByUser(long userId);

    FamilyDTO getFamilyDTO(long id);
    FamilyDTO getFamilyDTOByUser(long userId);

    Family createFamily(FamilyDTO familyDTO);
    Family addUser(long familyId, long userId);
    Family removeUser(long familyId, long userId);
    Family updateFamily(FamilyDTO familyDTO);

}
