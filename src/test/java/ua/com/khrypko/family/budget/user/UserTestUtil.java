package ua.com.khrypko.family.budget.user;

import ua.com.khrypko.family.budget.user.dto.FamilyDto;
import ua.com.khrypko.family.budget.user.dto.UserRequest;
import ua.com.khrypko.family.budget.user.entity.Family;
import ua.com.khrypko.family.budget.user.entity.User;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maks on 25.02.2018.
 */
public class UserTestUtil {

    private static final String NAME = "test";
    private static final String PASSWORD = "test_pass";
    private static final String EMAIL = "test@test.ua";
    private static final String SURNAME = "test_surname";
    private static final String FAMILY_NAME = "test";
    private static final String UNIQUE_ID = "someUniqueId12345";

    public static void assertUserHasSameFieldsAsRequest(UserRequest request, User user) {
        assertEquals(request.getName(), user.getName());
        assertEquals(request.getPassword(), user.getPassword());
        assertEquals(request.getEmail(), user.getEmail());
        assertEquals(request.getSurname(), user.getSurname());
    }

    public static UserRequest userRequest() {
        UserRequest request = new UserRequest();
        request.setName(NAME);
        request.setPassword(PASSWORD);
        request.setEmail(EMAIL);
        request.setSurname(SURNAME);
        return request;
    }

    public static User getUser() {
        User user = new User();
        user.setId(1L);
        user.setName(NAME);
        user.setPassword(PASSWORD);
        user.setSurname(SURNAME);
        user.setEmail(EMAIL);
        return user;
    }

    public static Family testFamily() {
        Family family = new Family();
        family.setId(1L);
        family.setName(FAMILY_NAME);
        family.setUniqueUrl(UNIQUE_ID);
        family.addUser(getUser());

        return family;
    }

    public static FamilyDto createFamilyDTO() {
        FamilyDto dto = new FamilyDto();
        dto.setName(FAMILY_NAME);
        dto.setUniqueId(UNIQUE_ID);
        return dto;
    }

}
