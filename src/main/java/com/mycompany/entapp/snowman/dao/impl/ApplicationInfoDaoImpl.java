/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.dao.impl;

import com.mycompany.entapp.snowman.dao.AbstractJDBCDao;
import com.mycompany.entapp.snowman.dao.ApplicationInfoDao;
import com.mycompany.entapp.snowman.model.AppInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class ApplicationInfoDaoImpl extends AbstractJDBCDao implements ApplicationInfoDao {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationInfoDaoImpl.class);

    private static final String SELECT_FROM_APP_INFO_QUERY = "SELECT * FROM app_info";

    @Override
    public AppInfo loadApplicationInfo() {

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
                return appInfo;
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

        return null;
    }
}
