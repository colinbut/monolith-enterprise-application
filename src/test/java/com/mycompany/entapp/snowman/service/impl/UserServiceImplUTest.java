/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.service.impl;

import com.mycompany.entapp.snowman.dao.UserDao;
import com.mycompany.entapp.snowman.service.UserService;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class UserServiceImplUTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Test
    public void testUserServiceFindUserShouldReturnUserFromDao() {

    }

}
