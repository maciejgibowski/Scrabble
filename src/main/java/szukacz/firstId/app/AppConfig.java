package szukacz.firstId.app;

import java.util.Locale;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

	
	@Configuration
	@EnableWebMvc
	@ComponentScan(basePackages = "szukacz.firstId")
	@EnableTransactionManagement
	@EnableJpaRepositories(basePackages = "szukacz.firstId.repository")
	public class AppConfig extends WebMvcConfigurerAdapter {
	 
	 //definicje beanów
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		   LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
		   emfb.setPersistenceUnitName("firstIdPersistenceUnit");
		   return emfb; 
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		   JpaTransactionManager tm = new JpaTransactionManager(emf);
		   return tm;
		   
	}
		
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
            new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;  
	}
	//załączanie statycznych elementow na stronie

	@Override
    public void configureDefaultServletHandling(
    DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
	}
	
	@Bean
	public Validator validator() {
	    return new LocalValidatorFactoryBean();
	}
	
	@Bean(name="localeResolver")
	public LocaleContextResolver getLocaleContextResolver() {
	    SessionLocaleResolver localeResolver = new SessionLocaleResolver();
	    localeResolver.setDefaultLocale(new Locale("pl","PL"));
	    return localeResolver; }
	
}
	



