/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.service;

import com.mycompany.entapp.snowman.model.User;

public interface UserService {
    User findUser(String userId);
}
