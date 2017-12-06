/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.endpoint;

import com.mycompany.entapp.snowman.model.User;
import com.mycompany.entapp.snowman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserRestEndpoint {

    @Autowired
    private UserService userService;

    @RequestMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(userService.findUser(userId));
    }
}
