package com.springdemo.bootboard.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration // root-context.xml 파일과 같은 기능 : bean 관리 설정
@PropertySource("classpath:/application.properties")
@EnableTransactionManagement // 어노테이션 기반 트랜잭션 관리 활성화
public class DatabaseConfig {
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
	@Bean // <bean id="hikariConfig" class="...HikariConfig">
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		
		HikariConfig config = new HikariConfig();
//		config.setDriverClassName("oracle.jdbc.OracleDriver");
		
		return config;
		
	}	
	
	@Bean// <bean id="dataSource" class="...HikariDataSource">
	public DataSource dataSource() {
		DataSource dataSource = new HikariDataSource(hikariConfig());
		return dataSource;
	}
	
	/////////////////////////////////////////////////
	
	@Bean
	@ConfigurationProperties(prefix="spring.jpa")
	public Properties hibernateConfig() {		
		return new Properties();
	}


}









