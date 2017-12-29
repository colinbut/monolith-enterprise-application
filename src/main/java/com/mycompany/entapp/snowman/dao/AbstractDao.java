/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDao {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractDao.class);

    private static final String DATABASE_HOST = "localhost";
    private static final String DATABASE_PORT = "3306";
    private static final String DATABASE = "snowman";

    private static final String DATABASE_CONNECTION_URL = "jdbc:mysql://" + DATABASE_HOST + ":" + DATABASE_PORT + "/" + DATABASE;
    private static final String DATABASE_USERNAME = "username";
    private static final String DATABASE_PASSWORD = "password";

    @Autowired
    private SessionFactory sessionFactory;

    // TODO separate raw - JDBC and Hibernate setup code into 2 separate Abstract Daos
    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    protected void setupDBDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LOG.error("{}", e); // TODO should throw a business exception back up
        }
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE_CONNECTION_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (SQLException e) {
            LOG.error("{}", e); // TODO should throw a business exception back up
        }

        return connection;
    }
}
