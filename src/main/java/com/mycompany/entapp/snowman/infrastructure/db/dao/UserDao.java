/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.db.dao;

import com.mycompany.entapp.snowman.domain.model.User;

public interface UserDao {
    User findUser(int userId);

    void saveUser(User user);

    void removeUser(int userId);
}
