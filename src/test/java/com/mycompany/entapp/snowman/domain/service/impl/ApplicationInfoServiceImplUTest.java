/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.exception.BusinessException;
import com.mycompany.entapp.snowman.domain.model.AppInfo;
import com.mycompany.entapp.snowman.domain.repository.ApplicationInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationInfoServiceImplUTest {

    @Mock
    private ApplicationInfoRepository applicationInfoRepository;

    @InjectMocks
    private ApplicationInfoServiceImpl classUnderTest = new ApplicationInfoServiceImpl();

    @Test(expected = BusinessException.class)
    public void givenAppInfoMapIsNull_whenGetAppInfo_thenThrowBusinessException() throws BusinessException {
        Mockito.when(applicationInfoRepository.getAppInfoMap()).thenReturn(null);

        classUnderTest.getAppInfo();
    }

    @Test(expected = BusinessException.class)
    public void givenAppInfoMapIsEmtpy_whenGetAppInfo_thenThrowBusinessException() throws BusinessException {
        Mockito.when(applicationInfoRepository.getAppInfoMap()).thenReturn(Collections.<Integer, AppInfo>emptyMap());

        classUnderTest.getAppInfo();
    }

    @Test(expected = BusinessException.class)
    public void givenAppInfoMapSizeIsMoreThanOne_whenGetAppInfo_thenThrowBusinessException() throws BusinessException {
        Map<Integer, AppInfo> appInfoMap = new HashMap<>();
        appInfoMap.put(1, new AppInfo());
        appInfoMap.put(2, new AppInfo());

        Mockito.when(applicationInfoRepository.getAppInfoMap()).thenReturn(appInfoMap);

        classUnderTest.getAppInfo();
    }

    @Test
    public void givenAppInfoMap_whenGetAppInfo_thenReturnOneAndOnlyAppInfo() throws BusinessException {
        AppInfo appInfo = new AppInfo();
        appInfo.setId(1);
        appInfo.setVersion("1");

        Map<Integer, AppInfo> appInfoMap = new HashMap<>();
        appInfoMap.put(1, appInfo);

        Mockito.when(applicationInfoRepository.getAppInfoMap()).thenReturn(appInfoMap);

        AppInfo appInfo1 = classUnderTest.getAppInfo();

        assertEquals(appInfo, appInfo1);
    }
}
