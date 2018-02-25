package ua.com.khrypko.family.budget.user.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ua.com.khrypko.family.budget.exception.NoSuchEntity;
import ua.com.khrypko.family.budget.user.dto.FamilyDto;
import ua.com.khrypko.family.budget.user.dto.FamilyDtoWithUsers;
import ua.com.khrypko.family.budget.user.entity.Family;
import ua.com.khrypko.family.budget.user.repository.FamilyRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static ua.com.khrypko.family.budget.user.UserTestUtil.*;

/**
 * Created by Maks on 25.02.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class FamilyServiceImplTest {

    public static final String NEW_NAME = "test_changed";
    private FamilyService familyService;

   @Mock private FamilyRepository familyRepository;

    @Before
    public void setUp() throws Exception {
        familyService = new FamilyServiceImpl(familyRepository);
    }

    @Test(expected = NoSuchEntity.class)
    public void testGetNonExistingFamilyThrowsException() throws Exception {
        when(familyRepository.getOne(anyLong())).thenReturn(null);
        familyService.getFamily(1L);
    }

    @Test
    public void testGetNonExistingFamilySuccessful() throws Exception {
        when(familyRepository.getOne(anyLong())).thenReturn(new Family());
        familyService.getFamily(1L);
    }

    @Test(expected = NoSuchEntity.class)
    public void testGetNonExistingFamilyByUserThrowsException() throws Exception {
        when(familyService.getFamilyByUser(anyLong())).thenReturn(null);
        familyService.getFamilyByUser(1L);
    }

    @Test
    public void testCreateFamilyWithoutNameSuccessful() throws Exception {
        when(familyRepository.save(any(Family.class))).thenAnswer(i -> i.getArguments()[0]);

        FamilyDto familyDto = createFamilyDTO();
        familyDto.setName(null);

        Family family = familyService.createFamily(familyDto);

        verify(familyRepository, times(1)).save(any(Family.class));
        assertNotNull(family.getUniqueUrl());
        assertNotNull(family.getName());
    }

    @Test
    public void testCreateFamilyWithNameSuccessful() throws Exception {
        when(familyRepository.save(any(Family.class))).thenAnswer(i -> i.getArguments()[0]);

        FamilyDto familyDto = createFamilyDTO();

        Family family = familyService.createFamily(familyDto);

        verify(familyRepository, times(1)).save(any(Family.class));
        assertNotNull(family.getUniqueUrl());
        assertNotNull(family.getName());
        assertEquals(familyDto.getName(), family.getName());
    }

    @Test
    public void testUniqueIdWontBeDuplicatedWhenCreateFamily(){
        when(familyRepository.existsByUniqueUrl(anyString())).thenReturn(true).thenReturn(false);

        familyService.createFamily(createFamilyDTO());

        verify(familyRepository, times(2)).existsByUniqueUrl(anyString());
    }

    @Test
    public void testUpdateFamilySuccessful(){
        when(familyRepository.save(any(Family.class))).thenAnswer(i -> i.getArguments()[0]);

        Family family = testFamily();
        family.setName(NEW_NAME);
        family.addUser(getUser());
        Family familyAfterUpdate = familyService.updateFamily(family);

        verify(familyRepository, times(1)).save(any(Family.class));
        assertEquals(NEW_NAME, familyAfterUpdate.getName());
        assertTrue(familyAfterUpdate.getUsers().size() == 1);
        assertTrue(familyAfterUpdate.getUsers().contains(getUser()));
    }

}