/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.rest.endpoint;

import com.mycompany.entapp.snowman.domain.exception.BusinessException;
import com.mycompany.entapp.snowman.domain.service.ApplicationInfoService;
import com.mycompany.entapp.snowman.infrastructure.rest.mappers.AppInfoResourceMapper;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.AppInfoResource;
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
    public ResponseEntity<AppInfoResource> getApplicationInformation() {
        try {
            AppInfoResource appInfoResource = AppInfoResourceMapper.mapAppInfoToResource(applicationInfoService.getAppInfo());
            return ResponseEntity.ok(appInfoResource);
        } catch (BusinessException e) {
            throw new RuntimeException(e);
        }
    }
}
