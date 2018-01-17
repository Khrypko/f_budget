package ua.com.khrypko.family.budget.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.khrypko.family.budget.common.Options;
import ua.com.khrypko.family.budget.exception.NoSuchEntity;
import ua.com.khrypko.family.budget.user.repository.FamilyRepository;
import ua.com.khrypko.family.budget.user.dto.FamilyDto;
import ua.com.khrypko.family.budget.user.entity.Family;
import ua.com.khrypko.family.budget.user.entity.User;

import java.util.stream.Collectors;

/**
 * Created by maks on 19.11.17.
 */
@Service
@Transactional
public class FamilyServiceImpl implements FamilyService {

    private FamilyRepository familyRepository;

    private UserService userService;

    @Autowired
    public FamilyServiceImpl(FamilyRepository familyRepository, UserService userService) {
        this.familyRepository = familyRepository;
        this.userService = userService;
    }

    @Override
    public Family getFamily(long id) {
        return familyRepository.getOne(id);
    }

    @Override
    public Family getFamilyByUser(long userId) {
        return userService.getUser(userId).getFamily();
    }

    @Override
    public FamilyDto getFamilyDTO(long id, Options options) {
        return createDTO(getFamily(id));
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
        return createDTO(getFamilyByUser(userId));
    }

    @Override
    public Family createFamily(FamilyDto familyDTO) {
        Family family = new Family();
        family.setName(familyDTO.getName());
        return familyRepository.save(family);
    }

    @Override
    public Family addUser(long familyId, long userId) {
        Family family = familyRepository.getOne(familyId);
        User user = userService.getUser(userId);
        family.addUser(user);

        return familyRepository.save(family);
    }

    @Override
    public Family removeUser(long familyId, long userId) {
        Family family = familyRepository.getOne(familyId);
        User user = userService.getUser(userId);
        family.removeUser(user);

        return familyRepository.save(family);

    }

    @Override
    public Family updateFamily(FamilyDto familyDTO) {
        Family family = familyRepository.getOne(familyDTO.getId());
        if (family == null)
            throw new NoSuchEntity();
        family.setName(familyDTO.getName());
        return familyRepository.save(family);
    }
}
