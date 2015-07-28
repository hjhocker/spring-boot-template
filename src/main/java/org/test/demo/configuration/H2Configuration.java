package org.test.demo.configuration;

import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//@Profile("dev")
//@PropertySource(value="classpath:application-dev.properties")
@Configuration
@EnableJpaRepositories(
		entityManagerFactoryRef = "h2EntityManagerFactory",
		transactionManagerRef = "h2TransactionManager",
		basePackages = "org.test.demo.repository")
@EnableTransactionManagement
public class H2Configuration {
	
	@Bean(name="h2DataSource")
	@Primary
    public DataSource dataSource() throws SQLException {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        builder.setName("demo");
        return builder.setType(EmbeddedDatabaseType.H2).build();
    }
	
    @Bean(name="h2EntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("org.test.demo.domain");
        factory.setPersistenceUnitName("h2PersistenceUnit");
        factory.setDataSource(dataSource());
        Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.show_sql", "true");
		jpaProperties.put("hibernate.format_sql", "true");
		factory.setJpaProperties(jpaProperties);
        factory.afterPropertiesSet();

        return factory;
    }
    
    @Bean(name="h2EntityManager")
    @Primary
    public EntityManager entityManager(@Qualifier("h2EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }
    
    /**
     * @see http://docs.spring.io/spring/docs/3.1.x/javadoc-api/org/springframework/transaction/annotation/EnableTransactionManagement.html
     * @return
     * @throws SQLException 
     */
    @Bean(name="h2TransactionManager")
    @Primary
    public PlatformTransactionManager transactionManager() throws SQLException {
    	JpaTransactionManager txManager = new JpaTransactionManager();
    	EntityManagerFactory factory = entityManagerFactory().getNativeEntityManagerFactory();
        txManager.setEntityManagerFactory(factory );
        return txManager;
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }
    
    /**
     * Register an endpoint for an H2 console.
     * 
     * To access the console for the in-memory database
     * <ul>
     *  <li>Navigate to /console</li>
     *  <li>Enter 
     * @return
     */	
    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/console/*");
        return registration;
    }
}
