/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.dao.impl;

import com.mycompany.entapp.snowman.dao.AbstractJDBCDao;
import com.mycompany.entapp.snowman.dao.UserDao;
import com.mycompany.entapp.snowman.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Use JDBCTemplate instead?
@Repository
public class UserDaoImpl extends AbstractJDBCDao implements UserDao {

    private static final Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);

    private static final String GET_USER_WITH_USERID_QUERY = "";

    @Override
    public User findUser(int userId) {

        Statement stmt = null;
        Connection connection = null;

        try {
            setupDBDriver();
            connection = getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(GET_USER_WITH_USERID_QUERY);

            while(rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("id"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                return user;
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
