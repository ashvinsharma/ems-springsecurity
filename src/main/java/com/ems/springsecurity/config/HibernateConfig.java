package com.ems.springsecurity.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Logger;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.ems.springsecurity.config"})
@PropertySource(value = {"classpath:application.properties"})
public class HibernateConfig {
    private final Logger LOGGER = Logger.getLogger(HibernateConfig.class.getName());

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.ems.springsecurity.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        try {
            properties.put("hibernate.dialect", Objects.requireNonNull(environment.getProperty("hibernate.dialect")));
            properties.put("hibernate.show_sql", Objects.requireNonNull(environment.getProperty("hibernate.show_sql")));
            properties.put("hibernate.format_sql", Objects.requireNonNull(environment.getProperty("hibernate.format_sql")));
        } catch (NullPointerException e) {
            LOGGER.severe("Null hibernate configuration properties.");
        }
        return properties;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        try {
            dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("jdbc.driverClassName")));
            dataSource.setUrl(environment.getProperty("jdbc.url"));
            dataSource.setUsername(environment.getProperty("jdbc.username"));
            dataSource.setPassword(environment.getProperty("jdbc.password"));
        } catch (NullPointerException e) {
            LOGGER.severe("Null data source properties.");
        }
        return dataSource;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        return new HibernateTransactionManager(s);
    }
}
