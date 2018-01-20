/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.application.cache.impl;

import com.mycompany.entapp.snowman.application.cache.ClientCacheService;
import com.mycompany.entapp.snowman.infrastructure.cache.ClientCachePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientCacheServiceImpl implements ClientCacheService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientCacheServiceImpl.class);

    @Autowired
    private ClientCachePort clientCachePort;

    @Override
    public void clearCache() {
        LOGGER.info("Clearing Client Cache");
        clientCachePort.refreshCache();
        LOGGER.info("Cleared Client Cache");
    }
}
