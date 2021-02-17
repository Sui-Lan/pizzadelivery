package com.pizzas;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.pizzas")
@PropertySource(value = { "classpath:database.properties" })
public class AppConfig {

    @Autowired
    Environment environment;
    
    @Bean
    DataSource dataSource() {
	DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	driverManagerDataSource.setUsername(environment.getProperty("usuario"));
	driverManagerDataSource.setUrl(environment.getProperty("url"));
	driverManagerDataSource.setPassword(environment.getProperty("clave"));
	driverManagerDataSource.setDriverClassName(environment.getProperty("driver"));
	return driverManagerDataSource;
    }
    
    
}
