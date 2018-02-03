/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.rest.mappers;

import com.mycompany.entapp.snowman.domain.model.User;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.UserResource;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserResourceMapperUTest {

    @Test
    public void testMapUserResourceToUser() {

        int userId = 1;
        String username = "Username";
        String password = "Password1";
        String email = "Email";
        String firstName = "Firstname";
        String secondName = "SecondName";

        UserResource userResource = new UserResource();
        userResource.setUserId(userId);
        userResource.setUsername(username);
        userResource.setPassword(password);
        userResource.setEmail(email);
        userResource.setFirstName(firstName);
        userResource.setSecondName(secondName);

        User user = UserResourceMapper.mapUserResourceToUser(userResource);

        assertEquals(userId, user.getUserId());
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        assertEquals(email, user.getEmail());
        assertEquals(firstName, user.getFirstname());
        assertEquals(secondName, user.getLastname());

    }

    @Test
    public void testMapUserToUserResource(){
        int userId = 1;
        String username = "Username";
        String password = "Password1";
        String email = "Email";
        String firstName = "Firstname";
        String secondName = "SecondName";

        User user = new User();
        user.setUserId(userId);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstname(firstName);
        user.setLastname(secondName);

        UserResource userResource = UserResourceMapper.mapUserToUserResource(user);

        assertEquals(userId, userResource.getUserId());
        assertEquals(username, userResource.getUsername());
        assertEquals(password, userResource.getPassword());
        assertEquals(email, userResource.getEmail());
        assertEquals(firstName, userResource.getFirstName());
        assertEquals(secondName, userResource.getSecondName());
    }
}
