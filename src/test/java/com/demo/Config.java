package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class Config {

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource(@Value("${spring.datasource.username}") String name,
                                 @Value("${spring.datasource.password}") String pwd,
                                 @Value("${spring.datasource.url}") String url,
                                 @Value("${spring.datasource.driver-class-name}") String driverclass) {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUsername(name);
        driverManagerDataSource.setPassword(pwd);
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setDriverClassName(driverclass);
        return driverManagerDataSource;
    }
}
