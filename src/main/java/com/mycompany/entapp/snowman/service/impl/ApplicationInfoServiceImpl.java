/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.service.impl;

import com.mycompany.entapp.snowman.dao.ApplicationInfoDao;
import com.mycompany.entapp.snowman.model.AppInfo;
import com.mycompany.entapp.snowman.service.ApplicationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationInfoServiceImpl implements ApplicationInfoService {

    @Autowired
    private ApplicationInfoDao applicationInfoDao;

    @Override
    public AppInfo getAppInfo() {
        return applicationInfoDao.loadApplicationInfo();
    }
}
