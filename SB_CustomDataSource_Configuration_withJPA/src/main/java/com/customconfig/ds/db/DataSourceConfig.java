package com.customconfig.ds.db;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
/*Enables Spring's annotation-driven transaction management capability,
similar to the support found in Spring's <tx:*> XML namespace. To be used on @Configuration classes.*/
//@EnableTransactionManagement
/*Annotation to enable JPA repositories. Will scan the package of the annotated configuration class for 
Spring Data repositories by default.*/
//@EnableJpaRepositories(
		/*Configures the name of the EntityManagerFactory bean definition to be used to create repositories 
		discovered through this annotation.*/
       // entityManagerFactoryRef = "appEntityManagerFactoryBean", 
        /*Configures the name of the PlatformTransactionManager bean definition
        to be used to create repositories discovered through this annotation.*/
       // transactionManagerRef = "appTransactionManager",
        /*Base packages to scan for annotated components.*/
       // basePackages = { "com.customconfig.ds.repository" })
public class DataSourceConfig {

	@Bean
	@ConfigurationProperties(prefix="datasource.api")
	public PoolProperties apiPoolProperties() {
	    return new org.apache.tomcat.jdbc.pool.PoolProperties();
	}
	
	/*@Bean(name = "apiDataSource")
	public DataSource apiDataSource(@Qualifier("apiPoolProperties") PoolProperties poolProperties) {
	    DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource(poolProperties);
	    //logger.info("Initialized API Datasource: {}", ds);
	    return ds;
	}*/
	
	@Bean(name="appDataSource")
    @ConfigurationProperties(prefix="app.datasource")
    public DataSource barDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	/*@Qualifier - This annotation may be used on a field or parameter as a qualifier for candidate beans when autowiring.
	It may also be used to annotate other custom annotations that can then in turn be used as qualifiers.*/

   /* @Bean(name = "appEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("appDataSource") DataSource appDataSource) {
        return builder
                .dataSource(appDataSource)
                .packages("com.customconfig.ds.model")
                .build();
    }

    @Bean(name = "appTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("appEntityManagerFactoryBean") EntityManagerFactory appEntityManagerFactoryBean) {
        return new JpaTransactionManager(appEntityManagerFactoryBean);
    }*/
}