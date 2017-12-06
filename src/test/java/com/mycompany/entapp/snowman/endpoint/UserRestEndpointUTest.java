/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.endpoint;

import com.mycompany.entapp.snowman.model.User;
import com.mycompany.entapp.snowman.service.UserService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class UserRestEndpointUTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserRestEndpoint classInTest;

    @Test
    public void getUserWithUserIdShouldReturnTheUser() {
        User user = new User();

    }
}
