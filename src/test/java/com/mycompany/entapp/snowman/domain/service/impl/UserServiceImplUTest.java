/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.model.User;
import com.mycompany.entapp.snowman.infrastructure.db.dao.UserDao;
import com.mycompany.entapp.snowman.domain.service.UserService;
import com.mycompany.entapp.snowman.infrastructure.rest.mappers.UserResourceMapper;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.UserResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplUTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Test
    public void testUserServiceFindUserShouldReturnUserFromDao() {

        int userId = 9;

        User user = getUser(userId);

        Mockito.when(userDao.findUser(userId)).thenReturn(user);

        User actualUser = userService.findUser("9");

        assertEquals(user, actualUser);
        Mockito.verify(userDao, Mockito.times(1)).findUser(userId);
    }
    @Test
    public void testCreateNewUser() {
        User user = getUser(1);

        Mockito.doNothing().when(userDao).saveUser(user);

        userService.createUser(user);

        Mockito.verify(userDao, Mockito.times(1)).saveUser(user);
    }

    @Test
    public void testUpdateUser() {
        User user = getUser(1);

        Mockito.doNothing().when(userDao).saveUser(user);

        userService.createUser(user);

        Mockito.verify(userDao, Mockito.times(1)).saveUser(user);
    }

    @Test
    public void testDeleteUser(){
        int userId = 1;
        User user = getUser(1);

        Mockito.doNothing().when(userDao).removeUser(userId);

        userService.deleteUser(userId);

        Mockito.verify(userService, Mockito.times(1)).deleteUser(userId);
    }

    private User getUser(int userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUsername("UserName");
        user.setPassword("Password");
        user.setEmail("Email");
        user.setFirstname("Firstname");
        user.setLastname("Lastname");
        return user;
    }

}
