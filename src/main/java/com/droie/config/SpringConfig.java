package com.droie.config;

import com.droie.util.PropertyReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"com.droie.service", "com.droie.dao"})
public class SpringConfig {

    private static Properties properties = new PropertyReader().getProperties("/Users/droie/Practice/AtmSpringMvc/src/main/resources/db.properties");

    private static final String DRIVER = properties.getProperty("driver");
    private static final String URL = properties.getProperty("url");
    private static final String USER = properties.getProperty("username");
    private static final String PASS =properties.getProperty("password");

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASS);
        return dataSource;
    }

}
