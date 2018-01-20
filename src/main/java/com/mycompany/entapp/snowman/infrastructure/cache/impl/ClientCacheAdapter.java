/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.cache.impl;

import com.mycompany.entapp.snowman.infrastructure.cache.ClientCachePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

@Component
public class ClientCacheAdapter implements ClientCachePort {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientCacheAdapter.class);

    @CacheEvict(value = "clientFindCache", allEntries = true)
    @Override
    public void refreshCache() {
        LOGGER.info("Executing clearing Client Cache operation");
    }
}
