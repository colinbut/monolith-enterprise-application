/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.db.dao.impl;

import com.mycompany.entapp.snowman.infrastructure.db.dao.AbstractJDBCDao;
import com.mycompany.entapp.snowman.infrastructure.db.dao.ApplicationInfoDao;
import com.mycompany.entapp.snowman.domain.model.AppInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ApplicationInfoDaoImpl extends AbstractJDBCDao implements ApplicationInfoDao {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationInfoDaoImpl.class);

    private static final String SELECT_FROM_APP_INFO_QUERY = "SELECT * FROM app_info";

    @Override
    public List<AppInfo> loadApplicationInfos() {

        LOG.info("Loading Application Infos from the database...");

        List<AppInfo> appInfos = new ArrayList<>();

        Statement stmt = null;
        Connection connection = null;

        try {
            setupDBDriver();
            connection = getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_FROM_APP_INFO_QUERY);

            while(rs.next()) {
                AppInfo appInfo = new AppInfo();
                appInfo.setId(rs.getInt("id"));
                appInfo.setVersion(rs.getString("version"));
                appInfos.add(appInfo);
            }

        } catch (SQLException e) {
            LOG.error("{}", e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                LOG.error("{}", e);
            }
         }

        return appInfos;
    }
}
