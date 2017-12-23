/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.dao.impl;

import com.mycompany.entapp.snowman.dao.ApplicationInfoDao;
import com.mycompany.entapp.snowman.model.AppInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class ApplicationInfoDaoImpl implements ApplicationInfoDao {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationInfoDaoImpl.class);

    @Override
    public AppInfo loadApplicationInfo() {

        Statement stmt = null;
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/snowman", "username", "password");
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECY * FROM app_info");

            while(rs.next()) {
                AppInfo appInfo = new AppInfo();
                appInfo.setId(rs.getInt("id"));
                appInfo.setVersion(rs.getString("version"));
                return appInfo;
            }

        } catch (ClassNotFoundException | SQLException e) {
            LOG.error("{}", e);
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (stmt != null) {
                stmt.close();
            }
         }

        return null;
    }
}
