/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.repository.impl;

import com.mycompany.entapp.snowman.domain.model.AppInfo;
import com.mycompany.entapp.snowman.domain.repository.ApplicationInfoRepository;
import com.mycompany.entapp.snowman.infrastructure.db.dao.ApplicationInfoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ApplicationInfoRepositoryImpl implements ApplicationInfoRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationInfoRepositoryImpl.class);

    @Autowired
    private ApplicationInfoDao applicationInfoDao;

    // using an in-memory collection (map) to load this static data upon app startup
    private Map<Integer, AppInfo> appInfoMap = new HashMap<>();

    @PostConstruct
    public void initialize() {
        LOGGER.info("Loading AppInfo from Database");

        List<AppInfo> appInfos = applicationInfoDao.loadApplicationInfos();
        for (AppInfo appInfo : appInfos) {
            appInfoMap.put(appInfo.getId(), appInfo);
        }
    }

    @Override
    public Map<Integer, AppInfo> getAppInfoMap() {
        return appInfoMap;
    }
}
