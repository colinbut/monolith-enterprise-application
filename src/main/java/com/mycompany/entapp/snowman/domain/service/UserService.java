/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.service;

import com.mycompany.entapp.snowman.domain.model.User;

public interface UserService {
    User findUser(String userId);
    void createUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);
}
