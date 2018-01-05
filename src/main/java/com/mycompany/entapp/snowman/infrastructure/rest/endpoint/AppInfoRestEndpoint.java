/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.rest.endpoint;

import com.mycompany.entapp.snowman.domain.model.AppInfo;
import com.mycompany.entapp.snowman.domain.service.ApplicationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppInfoRestEndpoint {

    @Autowired
    private ApplicationInfoService applicationInfoService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseEntity<AppInfo> getApplicationInformation() {
        return ResponseEntity.ok(applicationInfoService.getAppInfo());
    }
}
