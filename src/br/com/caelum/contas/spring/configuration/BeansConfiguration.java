package br.com.caelum.contas.spring.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration{

	@Bean
	public DataSource dataSource(){
		
		BasicDataSource ds = new BasicDataSource();
		
		ds.setDriverClassName("org.hsqldb.jdbcDriver");
		ds.setUrl("jdbc:hsqldb:file:contas.db");
		ds.setUsername("sa");
		ds.setPassword("");
		
		return ds;
	}
	
}
