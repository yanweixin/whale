package me.whale.data.dbms.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
@EnableJpaRepositories(basePackages = {"me.whale.data.dbms.repository.backend"},
        entityManagerFactoryRef = "backendEntityManagerFactory", transactionManagerRef = "backendTransactionManager")
public class BackendDataConfig {

    @Bean
    @ConfigurationProperties("datasources.backend")
    public DataSourceProperties backendDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("datasources.backend.configuration")
    public HikariDataSource backendDataSource(DataSourceProperties backendDataSourceProperties) {
        return backendDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean backendEntityManagerFactory(DataSource backendDataSource,
                                                                              JpaProperties jpaProperties) {
        EntityManagerFactoryBuilder builder = createEntityManagerFactoryBuilder(jpaProperties);
        return builder.dataSource(backendDataSource)
                .packages("me.whale.data.dbms.domain.system")
                .persistenceUnit("backendDs")
                .build();
    }

    private EntityManagerFactoryBuilder createEntityManagerFactoryBuilder(JpaProperties jpaProperties) {
        JpaVendorAdapter jpaVendorAdapter = createJpaVendorAdapter(jpaProperties);
        return new EntityManagerFactoryBuilder(jpaVendorAdapter, jpaProperties.getProperties(), null);
    }

    private JpaVendorAdapter createJpaVendorAdapter(JpaProperties jpaProperties) {
        // ... map JPA properties as needed
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public PlatformTransactionManager backendTransactionManager(@Qualifier("backendEntityManagerFactory") LocalContainerEntityManagerFactoryBean backendEntityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(backendEntityManagerFactory.getObject());
        return transactionManager;
    }

}
