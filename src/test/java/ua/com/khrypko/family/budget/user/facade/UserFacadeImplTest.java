package ua.com.khrypko.family.budget.user.facade;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.com.khrypko.family.budget.user.dto.FamilyDto;
import ua.com.khrypko.family.budget.user.dto.FamilyDtoWithUsers;
import ua.com.khrypko.family.budget.user.dto.UserDTO;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Maks on 17.01.2018.
 */
public class UserFacadeImplTest {

    private UserFacadeImpl userFacade;

    @Before
    public void setUp(){
        userFacade = new UserFacadeImpl();
    }

    private FamilyDtoWithUsers createFamilyDTO() {
        FamilyDtoWithUsers dto = new FamilyDtoWithUsers();
        dto.setName("test");
        dto.setUniqueId("someUniqueId12345");
        return dto;
    }

    @Test
    public void testCreateFamily(){
        FamilyDtoWithUsers familyDtoWithUsers = createFamilyDTO();
        familyDtoWithUsers.setUsers(Collections.singletonList(new UserDTO(1L, null, null, null, 0)));
        FamilyDto createdFamily = userFacade.createFamily(familyDtoWithUsers);

        Assert.assertNotNull(createdFamily.getId());
        Assert.assertNotNull(createdFamily.getUniqueId());
        Assert.assertEquals(familyDtoWithUsers.getName(), createdFamily.getName());

    }

}