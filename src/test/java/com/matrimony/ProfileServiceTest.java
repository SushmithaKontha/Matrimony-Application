package com.matrimony;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.matrimony.dao.ProfileDao;
import com.matrimony.entity.Profile;
import com.matrimony.exception.UserNotFoundException;
import com.matrimony.service.ProfileService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileServiceTest {

    @Autowired
    private ProfileService profileService;

    @MockBean
    private ProfileDao profileDao;

    @Test
    public void addNewProfileTest() {
        Profile profile = new Profile();
        profile.setFullName("John Doe");
        profile.setAge(25);
        profile.setGender("Male");

        Mockito.when(profileDao.save(profile)).thenReturn(profile);

        Profile savedProfile = profileService.addNewProfile(profile);

        Assert.assertEquals(savedProfile.getFullName(), profile.getFullName());
        Assert.assertEquals(savedProfile.getAge(), profile.getAge());
        Assert.assertEquals(savedProfile.getGender(), profile.getGender());
    }

    @Test
    public void getAllProfilesTest() {
        List<Profile> profiles = new ArrayList<>();
        Profile profile1 = new Profile();
        profile1.setpId(1);
        profile1.setFullName("John Doe");
        profile1.setAge(25);
        profile1.setGender("Male");

        Profile profile2 = new Profile();
        profile2.setpId(2);
        profile2.setFullName("Jane Doe");
        profile2.setAge(23);
        profile2.setGender("Female");

        profiles.add(profile1);
        profiles.add(profile2);

        Mockito.when(profileDao.findAll()).thenReturn(profiles);

        List<Profile> fetchedProfiles = profileService.getAllProfiles();

        Assert.assertEquals(fetchedProfiles.size(), 2);
        Assert.assertEquals(fetchedProfiles.get(0).getpId(), profile1.getpId());
        Assert.assertEquals(fetchedProfiles.get(1).getpId(), profile2.getpId());
    }
    @Test
    public void deleteProfileDetailsTest() {
        int id = 1;
        profileService.deleteProfileDetails(id);

        Mockito.verify(profileDao, Mockito.times(1)).deleteById(id);
    }

    @Test
    public void getProfileByIdTest() {
        int id = 1;
        Profile profile = new Profile();
        profile.setpId(id);
        profile.setFullName("John Doe");
        profile.setAge(25);
        profile.setGender("Male");

        Mockito.when(profileDao.findById(id)).thenReturn(Optional.of(profile));

        Profile fetchedProfile = profileService.getProfileById(id);

        Assert.assertEquals(fetchedProfile.getpId(), profile.getpId());
        Assert.assertEquals(fetchedProfile.getFullName(), profile.getFullName());
        Assert.assertEquals(fetchedProfile.getAge(), profile.getAge());
        Assert.assertEquals(fetchedProfile.getGender(), profile.getGender());
    }
    @Test
    public void updateProfileTest() throws UserNotFoundException {
        int id = 1;
        Profile existingProfile = new Profile();
        existingProfile.setpId(id);
        existingProfile.setFullName("John Doe");
        existingProfile.setAge(25);
        existingProfile.setGender("Male");

        Profile updatedProfile = new Profile();
        updatedProfile.setpId(id);
        updatedProfile.setFullName("Jane Doe");
        updatedProfile.setAge(23);
        updatedProfile.setGender("Female");

        Mockito.when(profileDao.findById(id)).thenReturn(Optional.of(existingProfile));
        Mockito.when(profileDao.save(existingProfile)).thenReturn(updatedProfile);

        Profile savedProfile = profileService.updateProfile(id, updatedProfile);

        Assert.assertEquals(savedProfile.getpId(), updatedProfile.getpId());
        Assert.assertEquals(savedProfile.getFullName(), updatedProfile.getFullName());
        Assert.assertEquals(savedProfile.getAge(), updatedProfile.getAge());
        Assert.assertEquals(savedProfile.getGender(), updatedProfile.getGender());
    }
    

}