package br.com.financeiro.controlefinanceiro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.financeiro.controlefinanceiro.controllers.FinanceiroController;
import br.com.financeiro.controlefinanceiro.dao.FinanceiroDAO;

@EnableWebMvc
@ComponentScan(basePackageClasses = {FinanceiroController.class, FinanceiroDAO.class})
public class AppWebConfig extends WebMvcConfigurerAdapter {
	
	//locate views and specify extension
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	
	//Use Servlet to access css
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	    configurer.enable();
	}

}
