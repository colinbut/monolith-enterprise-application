/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.rest.endpoint;

import com.mycompany.entapp.snowman.domain.model.User;
import com.mycompany.entapp.snowman.domain.service.impl.UserServiceImpl;
import com.mycompany.entapp.snowman.infrastructure.rest.mappers.UserResourceMapper;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.UserResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserResourceMapper.class)
public class UserRestEndpointUTest {

    @Mock
    private UserServiceImpl userService;

    @InjectMocks
    private UserRestEndpoint classInTest = new UserRestEndpoint();


    @Test
    public void getUserWithUserIdShouldReturnTheUser() {
        User user = new User();

        UserResource userResource = new UserResource();
        userResource.setUserId(1);
        userResource.setUsername("Username");
        userResource.setPassword("Password");
        userResource.setFirstName("Firstname");
        userResource.setSecondName("Secondname");
        userResource.setEmail("Email");

        Mockito.when(userService.findUser("1")).thenReturn(user);

        PowerMockito.mockStatic(UserResourceMapper.class);

        PowerMockito.when(UserResourceMapper.mapUserToUserResource(user)).thenReturn(userResource);

        ResponseEntity<UserResource> responseEntity = classInTest.getUser("1");

        assertTrue(responseEntity.getStatusCode() == HttpStatus.OK);
        assertEquals(userResource, responseEntity.getBody());
    }

    @Test
    public void createUserShouldCreateUser(){

        UserResource userResource = new UserResource();

        User user = new User();
        user.setUserId(1);
        user.setUsername("Username");
        user.setPassword("Password");
        user.setFirstname("Firstname");
        user.setLastname("Lastname");
        user.setEmail("Email");

        PowerMockito.mockStatic(UserResourceMapper.class);

        PowerMockito.when(UserResourceMapper.mapUserResourceToUser(userResource)).thenReturn(user);
        Mockito.doNothing().when(userService).createUser(user);

        classInTest.createNewUser(userResource);

        Mockito.verify(userService, Mockito.times(1)).createUser(user);
    }

    @Test
    public void testUpdateUser(){
        UserResource userResource = new UserResource();

        User user = new User();
        user.setUserId(1);
        user.setUsername("Username");
        user.setPassword("Password");
        user.setFirstname("Firstname");
        user.setLastname("Lastname");
        user.setEmail("Email");

        PowerMockito.mockStatic(UserResourceMapper.class);

        PowerMockito.when(UserResourceMapper.mapUserResourceToUser(userResource)).thenReturn(user);
        Mockito.doNothing().when(userService).updateUser(user);

        classInTest.updateExistingUser(userResource);

        Mockito.verify(userService, Mockito.times(1)).createUser(user);
    }

    @Test
    public void testDeleteUser(){
        int userId = 1;

        Mockito.doNothing().when(userService).deleteUser(userId);

        classInTest.deleteUser(userId);

        Mockito.verify(userService, Mockito.times(1)).deleteUser(userId);
    }
}
