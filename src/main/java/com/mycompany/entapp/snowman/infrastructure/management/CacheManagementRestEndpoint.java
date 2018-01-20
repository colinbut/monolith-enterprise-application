/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.management;

import com.mycompany.entapp.snowman.application.cache.ClientCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheManagementRestEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheManagementRestEndpoint.class);

    @Autowired
    private ClientCacheService clientCacheService;

    @RequestMapping("/{cacheName}/clear")
    public ResponseEntity<CacheManagementResource> clearClientCache(@PathVariable String cacheName){
        LOGGER.info("About to clear {} cache", cacheName);
        clientCacheService.clearCache();
        return ResponseEntity.ok(
            new CacheManagementResource(HttpStatus.OK.value(), cacheName + " have been cleared"));
    }

    /**
     * Private inner class?
     */
    private class CacheManagementResource {
        private int statusCode;
        private String description;

        public CacheManagementResource(int statusCode, String description) {
            this.statusCode = statusCode;
            this.description = description;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
