package ua.com.khrypko.family.budget.service.user;

import ua.com.khrypko.family.budget.dto.FamilyDTO;
import ua.com.khrypko.family.budget.entity.user.Family;

/**
 * Created by maks on 19.11.17.
 */
public interface FamilyService {

    Family getFamily(int id);
    Family getFamilyByUser(int userId);

    FamilyDTO getFamilyDTO(int id);
    FamilyDTO getFamilyDTOByUser(int userId);

    Family createFamily(FamilyDTO familyDTO);
    Family addUser(int familyId, int userId);
    Family removeUser(int familyId, int userId);
    Family updateFamily(FamilyDTO familyDTO);

}
