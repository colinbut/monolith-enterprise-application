/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.model.User;
import com.mycompany.entapp.snowman.infrastructure.db.dao.UserDao;
import com.mycompany.entapp.snowman.domain.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplUTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Test
    public void testUserServiceFindUserShouldReturnUserFromDao() {

        User user = new User();

        int userId = 9;

        Mockito.when(userDao.findUser(userId)).thenReturn(user);

        User actualUser = userService.findUser("9");

        assertEquals(user, actualUser);
        Mockito.verify(userDao, Mockito.times(1)).findUser(userId);
    }

}
