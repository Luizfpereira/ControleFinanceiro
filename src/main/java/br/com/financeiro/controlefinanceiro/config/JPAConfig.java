package br.com.financeiro.controlefinanceiro.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JPAConfig {
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
	    return new JpaTransactionManager(emf);
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

		factoryBean.setJpaVendorAdapter(vendorAdapter);

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("1234"); 
		dataSource.setUrl("jdbc:mysql://localhost:3306/financeiro");
		//access to database "financeiro"
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		factoryBean.setDataSource(dataSource);
		
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.show_sql", "true"); // show sql in console
		props.setProperty("hibernate.hbm2ddl.auto", "update");// update database
		factoryBean.setJpaProperties(props);

		factoryBean.setPackagesToScan("br.com.financeiro.controlefinanceiro.model");
		//scan classes marked with entity in package model
		return factoryBean;

	}
	
}
