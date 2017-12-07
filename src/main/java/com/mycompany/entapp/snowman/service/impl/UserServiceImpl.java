/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.service.impl;

import com.mycompany.entapp.snowman.dao.UserDao;
import com.mycompany.entapp.snowman.model.User;
import com.mycompany.entapp.snowman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUser(String userId) {
        return userDao.findUser(Integer.parseInt(userId));
    }
}
