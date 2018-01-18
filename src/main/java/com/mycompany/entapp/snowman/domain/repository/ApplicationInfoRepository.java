/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.repository;

import com.mycompany.entapp.snowman.domain.model.AppInfo;

import java.util.Map;

public interface ApplicationInfoRepository {
    Map<Integer, AppInfo> getAppInfoMap();
}
