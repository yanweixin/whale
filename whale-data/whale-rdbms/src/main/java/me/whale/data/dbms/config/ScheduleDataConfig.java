package me.whale.data.dbms.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
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
import java.util.HashMap;
import java.util.Map;

@Configuration(proxyBeanMethods = false)
@EnableJpaRepositories(basePackages = {"me.whale.data.dbms.repository.schedule"},
        entityManagerFactoryRef = "scheduleEntityManagerFactory", transactionManagerRef = "scheduleTransactionManager")
public class ScheduleDataConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean scheduleEntityManagerFactory(DataSource backendDataSource,
                                                                               JpaProperties jpaProperties) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.default_schema", "schedule");
        EntityManagerFactoryBuilder builder = createEntityManagerFactoryBuilder(jpaProperties);
        return builder.dataSource(backendDataSource)
                .packages("me.whale.data.dbms.domain.schedule")
                .properties(properties)
                .persistenceUnit("scheduleDs")
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
    public PlatformTransactionManager scheduleTransactionManager(@Qualifier("scheduleEntityManagerFactory") LocalContainerEntityManagerFactoryBean scheduleEntityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(scheduleEntityManagerFactory.getObject());
        return transactionManager;
    }
}
