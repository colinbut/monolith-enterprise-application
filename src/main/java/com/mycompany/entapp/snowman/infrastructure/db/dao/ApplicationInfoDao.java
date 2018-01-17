/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.db.dao;

import com.mycompany.entapp.snowman.domain.model.AppInfo;

import java.util.List;

public interface ApplicationInfoDao {
    List<AppInfo> loadApplicationInfos();
}
