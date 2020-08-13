package br.com.financeiro.controlefinanceiro.config;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Profile("prod")
public class JPAProductionConfiguration {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public Properties additionalProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		props.setProperty("hibernate.show_sql", "true"); // show sql in console
		props.setProperty("hibernate.hbm2ddl.auto", "update");// update database
		return props;
	}
	
	@Bean
	private DriverManagerDataSource dataSource() throws URISyntaxException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.postgresql.Driver");
		
		
		URI dbUrl = new URI(environment.getProperty("DATABASE_URL"));
		dataSource.setUrl("jdbc:postgre://"+dbUrl.getHost()
		+":"+dbUrl.getPort()+dbUrl.getPath());
		dataSource.setUsername(dbUrl.getUserInfo().split(":")[0]);
		dataSource.setPassword(dbUrl.getUserInfo().split(":")[1]);
        
		return dataSource;
	}

}
