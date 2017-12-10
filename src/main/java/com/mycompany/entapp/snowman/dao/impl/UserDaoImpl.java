/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.dao.impl;

import com.mycompany.entapp.snowman.dao.UserDao;
import com.mycompany.entapp.snowman.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
// TODO change this with JPA - Hibernate (for ORM)
public class UserDaoImpl implements UserDao {

    private Map<Integer, User> userMap = new HashMap<>();

    @Override
    public User findUser(int userId) {
        return userMap.get(userId);
    }
}
