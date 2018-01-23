package ua.com.khrypko.family.budget.user.facade;

import org.springframework.stereotype.Service;
import ua.com.khrypko.family.budget.common.Options;
import ua.com.khrypko.family.budget.user.dto.FamilyDto;
import ua.com.khrypko.family.budget.user.dto.FamilyDtoWithUsers;
import ua.com.khrypko.family.budget.user.entity.Family;
import ua.com.khrypko.family.budget.user.service.FamilyService;
import ua.com.khrypko.family.budget.user.service.UserService;

/**
 * Created by Maks on 17.01.2018.
 */
@Service
public class UserFacadeImpl implements UserFacade {

    private UserService userService;
    private FamilyService familyService;

    public UserFacadeImpl(UserService userService, FamilyService familyService) {
        this.userService = userService;
        this.familyService = familyService;
    }

    @Override
    public FamilyDto createFamily(FamilyDtoWithUsers familyDtoWithUsers) {
        return null;
    }

    @Override
    public FamilyDto getFamilyDTO(long id, Options options) {
//        return createDTO(getFamily(id));
        return null;
    }

    private FamilyDto createDTO(Family family) {
        FamilyDto dto = new FamilyDto();
        dto.setId(family.getId());
        dto.setName(family.getName());

        //dto.setUsers(family.getUsers().stream().map(userService::createDTO).collect(Collectors.toList()));

        return dto;
    }

    @Override
    public FamilyDto getFamilyDTOByUser(long userId, Options options) {
        //return createDTO(getFamilyByUser(userId));
        return null;
    }
}
