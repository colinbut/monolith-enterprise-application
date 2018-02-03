/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.rest.endpoint;

import com.mycompany.entapp.snowman.domain.model.User;
import com.mycompany.entapp.snowman.domain.service.UserService;
import com.mycompany.entapp.snowman.infrastructure.rest.mappers.UserResourceMapper;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserRestEndpoint {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<UserResource> getUser(@PathVariable("userId") String userId) {
        User user = userService.findUser(userId);
        UserResource userResource = UserResourceMapper.mapUserToUserResource(user);
        return ResponseEntity.ok(userResource);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity createNewUser(@Valid UserResource userResource) {
        User user = UserResourceMapper.mapUserResourceToUser(userResource);
        userService.createUser(user);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity updateExistingUser(@Valid UserResource userResource){
        User user = UserResourceMapper.mapUserResourceToUser(userResource);
        userService.updateUser(user);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "{userId}/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
