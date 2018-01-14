package ua.com.khrypko.family.budget.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.khrypko.family.budget.exception.NoSuchEntity;
import ua.com.khrypko.family.budget.repository.FamilyRepository;
import ua.com.khrypko.family.budget.dto.FamilyDTO;
import ua.com.khrypko.family.budget.entity.user.Family;
import ua.com.khrypko.family.budget.entity.user.User;

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
    public Family getFamily(int id) {
        return familyRepository.getOne(id);
    }

    @Override
    public Family getFamilyByUser(int userId) {
        return userService.getUser(userId).getFamily();
    }

    @Override
    public FamilyDTO getFamilyDTO(int id) {
        return createDTO(getFamily(id));
    }

    private FamilyDTO createDTO(Family family) {
        FamilyDTO dto = new FamilyDTO();
        dto.setId(family.getId());
        dto.setName(family.getName());
        dto.setUsers(family.getUsers().stream().map(userService::createDTO).collect(Collectors.toList()));

        return dto;
    }

    @Override
    public FamilyDTO getFamilyDTOByUser(int userId) {
        return createDTO(getFamilyByUser(userId));
    }

    @Override
    public Family createFamily(FamilyDTO familyDTO) {
        Family family = new Family();
        family.setName(familyDTO.getName());
        return familyRepository.save(family);
    }

    @Override
    public Family addUser(int familyId, int userId) {
        Family family = familyRepository.getOne(familyId);
        User user = userService.getUser(userId);
        family.addUser(user);

        return familyRepository.save(family);
    }

    @Override
    public Family removeUser(int familyId, int userId) {
        Family family = familyRepository.getOne(familyId);
        User user = userService.getUser(userId);
        family.removeUser(user);

        return familyRepository.save(family);

    }

    @Override
    public Family updateFamily(FamilyDTO familyDTO) {
        Family family = familyRepository.getOne(familyDTO.getId());
        if (family == null)
            throw new NoSuchEntity();
        family.setName(familyDTO.getName());
        return familyRepository.save(family);
    }
}
