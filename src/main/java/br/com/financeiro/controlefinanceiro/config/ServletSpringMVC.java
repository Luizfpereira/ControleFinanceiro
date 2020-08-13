package br.com.financeiro.controlefinanceiro.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class [] {AppWebConfig.class, JPAConfig.class,
				JPAProductionConfiguration.class};
		
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class [] {};
	}

	@Override
	protected String[] getServletMappings() {
		return new String [] { "/" };
	}

}
