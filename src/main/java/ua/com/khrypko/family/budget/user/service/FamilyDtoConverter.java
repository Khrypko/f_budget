package ua.com.khrypko.family.budget.user.service;

import ua.com.khrypko.family.budget.common.Options;
import ua.com.khrypko.family.budget.user.dto.FamilyDto;
import ua.com.khrypko.family.budget.user.dto.FamilyDtoWithUsers;
import ua.com.khrypko.family.budget.user.entity.Family;

import java.util.stream.Collectors;

/**
 * Created by Maks on 17.01.2018.
 */
public class FamilyDtoConverter {

    private static final String OPTION_NAME = "type";
    private static final String DTO_WITH_USER = "withUser";
    private UserDtoConverter userDtoConverter;

    public FamilyDtoConverter(UserDtoConverter userDtoConverter) {
        this.userDtoConverter = userDtoConverter;
    }

    public FamilyDto convertFrom(Family family, Options<Options.StringOption> options){
        if (options.get(OPTION_NAME) == null) return createSimpleDto(family);

        Options.StringOption option = options.get(OPTION_NAME);
        if (option.getValue().equals(DTO_WITH_USER)) return createDtoWithUsers(family);

        return createSimpleDto(family);
    }

    private FamilyDto createDtoWithUsers(Family family) {
        FamilyDtoWithUsers dto = new FamilyDtoWithUsers();
        dto.setId(family.getId());
        dto.setName(family.getName());
        dto.setUniqueId(family.getUniqueUrl());

        Options<Options.StringOption> options = new Options<>();
        options.add(OPTION_NAME, Options.stringOption("base"));
        dto.setUsers(family.getUsers().stream().map(user -> userDtoConverter.convertFrom(user, options)).collect(Collectors.toList()));

        return dto;
    }

    private FamilyDto createSimpleDto(Family family) {
        FamilyDto familyDto = new FamilyDto();
        familyDto.setId(family.getId());
        familyDto.setName(family.getName());
        familyDto.setUniqueId(family.getUniqueUrl());
        return familyDto;
    }

}
