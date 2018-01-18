/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.exception.BusinessException;
import com.mycompany.entapp.snowman.domain.repository.ApplicationInfoRepository;
import com.mycompany.entapp.snowman.domain.model.AppInfo;
import com.mycompany.entapp.snowman.domain.service.ApplicationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ApplicationInfoServiceImpl implements ApplicationInfoService {

    @Autowired
    private ApplicationInfoRepository applicationInfoRepository;

    @Override
    public AppInfo getAppInfo() throws BusinessException {
        Map<Integer, AppInfo> appInfoMap = applicationInfoRepository.getAppInfoMap();

        if (appInfoMap == null || appInfoMap.isEmpty()) {
            throw new BusinessException("AppInfo is null or empty");
        }

        if (appInfoMap.size() != 1) {
            throw new BusinessException("There are more than one entry in AppInfo");
        }

        return appInfoMap.entrySet().iterator().next().getValue();
    }
}
