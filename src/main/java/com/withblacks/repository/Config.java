package com.withblacks.repository;

import com.google.common.base.Throwables;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan
@EnableJpaRepositories(basePackages = "com.withblacks.repository")
@EnableAutoConfiguration
@PropertySource("classpath:database.properties")
@EntityScan(basePackages = {"com.withblacks.business.entities"})
class Config {

    private static final Logger LOGGER = Logger.getLogger(Config.class);

    @Value("${spring.database.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${spring.datasource.username}")
    private String databaseUserName;

    @Value("${spring.datasource.password}")
    private String databasePassword;

    public void connection() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection(databaseUrl, databaseUserName, databasePassword);
            connection.close();
        } catch (SQLException e) {
            LOGGER.error(e);
            Throwables.propagate(e);
        }
    }
}
