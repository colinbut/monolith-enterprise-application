/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.repository.impl;

import com.mycompany.entapp.snowman.domain.model.AppInfo;
import com.mycompany.entapp.snowman.infrastructure.db.dao.ApplicationInfoDao;
import com.mycompany.entapp.snowman.infrastructure.db.dao.impl.ApplicationInfoDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationInfoRepositoryImplUTest {

    @Mock
    private ApplicationInfoDao applicationInfoDao;

    @InjectMocks
    private ApplicationInfoRepositoryImpl classUnderTest = new ApplicationInfoRepositoryImpl();

    @Test
    public void testInitialize_shouldInitializeDataFromDatabase() {

        AppInfo appInfo = new AppInfo();
        appInfo.setId(1);
        appInfo.setVersion("1.0.0");

        List<AppInfo> appInfos = new ArrayList<>();
        appInfos.add(appInfo);

        Mockito.when(applicationInfoDao.loadApplicationInfos()).thenReturn(appInfos);

        classUnderTest.initialize();

        Map<Integer, AppInfo> appInfoMap = classUnderTest.getAppInfoMap();

        assertFalse(appInfoMap.isEmpty());
        assertEquals(appInfoMap.entrySet().iterator().next().getValue(), appInfo);
    }

}
