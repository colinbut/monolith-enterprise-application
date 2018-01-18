/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.rest.endpoint;

import com.mycompany.entapp.snowman.domain.exception.BusinessException;
import com.mycompany.entapp.snowman.domain.model.AppInfo;
import com.mycompany.entapp.snowman.domain.service.ApplicationInfoService;
import com.mycompany.entapp.snowman.infrastructure.rest.mappers.AppInfoResourceMapper;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.AppInfoResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({AppInfoResourceMapper.class})
public class AppInfoRestEndpointUTest {

    @Mock
    private ApplicationInfoService applicationInfoService;

    @InjectMocks
    private AppInfoRestEndpoint classUnderTest = new AppInfoRestEndpoint();

    @Test
    public void testGetApplicationInformation() throws BusinessException {
        PowerMockito.mockStatic(AppInfoResourceMapper.class);

        AppInfoResource appInfoResource = new AppInfoResource();
        appInfoResource.setId(1);
        appInfoResource.setVersion("1.0.0");

        AppInfo appInfo = new AppInfo();
        appInfo.setId(1);
        appInfo.setVersion("1.0.0");

        Mockito.when(applicationInfoService.getAppInfo()).thenReturn(appInfo);
        PowerMockito.when(AppInfoResourceMapper.mapAppInfoToResource(appInfo)).thenReturn(appInfoResource);

        ResponseEntity<AppInfoResource> responseEntity = classUnderTest.getApplicationInformation();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(appInfoResource, responseEntity.getBody());

    }

    @Test(expected = RuntimeException.class)
    public void testGetApplicationInformation_throwsException() throws BusinessException {
        Mockito.doThrow(BusinessException.class).when(applicationInfoService).getAppInfo();

        classUnderTest.getApplicationInformation();
    }

}
