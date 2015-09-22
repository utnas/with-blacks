package com.withblacks.repository;

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
public class Config {

    @Value("${spring.database.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String dbUserName;
    @Value("${spring.datasource.password}")
    private String dbPassword;

    public void connection() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    dbUrl, dbUserName, dbPassword);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
