package ua.com.khrypko.family.budget.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.khrypko.family.budget.common.Options;
import ua.com.khrypko.family.budget.common.RandomStringGenerator;
import ua.com.khrypko.family.budget.exception.NoSuchEntity;
import ua.com.khrypko.family.budget.user.repository.FamilyRepository;
import ua.com.khrypko.family.budget.user.dto.FamilyDto;
import ua.com.khrypko.family.budget.user.entity.Family;
import ua.com.khrypko.family.budget.user.entity.User;

import java.util.Set;
import java.util.stream.Collectors;

import static ua.com.khrypko.family.budget.common.RandomStringGenerator.generateRandomUrlString;

/**
 * Created by maks on 19.11.17.
 */
@Service
@Transactional
public class FamilyServiceImpl implements FamilyService {

    private static final String DEFAULT_NAME = "Нова сім'я";
    private FamilyRepository familyRepository;

    @Autowired
    public FamilyServiceImpl(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    @Override
    public Family getFamily(long id) {
        Family family = familyRepository.getOne(id);
        if (family == null) throw new NoSuchEntity();
        return family;
    }

    @Override
    public Family getFamilyByUser(long userId) {
        Family family = familyRepository.findFamilyByUsersIdContaining(userId);
        if (family == null) throw new NoSuchEntity();
        return family;
    }

    @Override
    public Family getFamilyByUniqueUrl(String uniqueUrl) {
        Family family = familyRepository.findByUniqueUrl(uniqueUrl);
        if (family == null) throw new NoSuchEntity();
        return family;
    }


    @Override
    public Family createFamily(FamilyDto familyDTO) {
        Family family = new Family();
        family.setName(familyDTO.getName() == null ? DEFAULT_NAME : familyDTO.getName());
        family.setUniqueUrl(generateUniqueUrl());
        return familyRepository.save(family);
    }

    private String generateUniqueUrl() {
        String randomUrl = generateRandomUrlString();
        while (urlAlreadyExists(randomUrl)){
            randomUrl = generateRandomUrlString();
        }
        return randomUrl;
    }

    private boolean urlAlreadyExists(String randomUrl) {
        return familyRepository.existsByUniqueUrl(randomUrl);
    }

    @Override
    public Family updateFamily(Family family) {
        return familyRepository.save(family);
    }
}
