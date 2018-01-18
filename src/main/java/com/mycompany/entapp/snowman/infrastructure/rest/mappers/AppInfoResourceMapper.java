/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.rest.mappers;

import com.mycompany.entapp.snowman.domain.model.AppInfo;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.AppInfoResource;

public final class AppInfoResourceMapper {

    private AppInfoResourceMapper(){
    }

    public static AppInfoResource mapAppInfoToResource(AppInfo appInfo) {
        AppInfoResource appInfoResource = new AppInfoResource();
        appInfoResource.setId(appInfo.getId());
        appInfoResource.setVersion(appInfo.getVersion());
        return appInfoResource;
    }
}
