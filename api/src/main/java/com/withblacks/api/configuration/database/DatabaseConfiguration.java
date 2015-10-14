package com.withblacks.api.configuration.database;

import com.google.common.base.Throwables;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

@ComponentScan
@EnableJpaRepositories(basePackages = "com.withblacks.repository")
@PropertySource("classpath:database.properties")
@PropertySource("classpath:secret.properties")
@EntityScan(basePackages = {"com.withblacks.business.entities"})
class DatabaseConfiguration {

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
            Throwables.propagate(e);
        }
        Connection connection;
        try {
            connection = getConnection(databaseUrl, databaseUserName, databasePassword);
            connection.close();
        } catch (SQLException e) {
            Throwables.propagate(e);
        }
    }
}
