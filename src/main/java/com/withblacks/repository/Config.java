package com.withblacks.repository;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan
@EnableJpaRepositories(basePackages = "com.withblacks.repository")
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.withblacks.business.entities"})
public class Config {

    public void connection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/test", "postgres", "admin");

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
