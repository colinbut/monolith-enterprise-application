/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.rest.mappers;

import com.mycompany.entapp.snowman.domain.model.User;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.UserResource;

public final class UserResourceMapper {
    private UserResourceMapper(){
    }

    public static User mapUserResourceToUser(UserResource userResource){
        User user = new User();
        user.setUserId(userResource.getUserId());
        user.setFirstname(userResource.getFirstName());
        user.setLastname(userResource.getSecondName());
        user.setUsername(userResource.getUsername());
        user.setPassword(userResource.getPassword());
        user.setEmail(userResource.getEmail());
        return user;
    }
}
