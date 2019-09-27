package ru.solon4ak.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.solon4ak.service.UserDetailServiceImpl;

import javax.sql.DataSource;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
@ComponentScan(basePackages = "ru.solon4ak")
@EnableTransactionManagement
@PropertySource("classpath:db/jdbc.properties")
public class RootContextConfiguration {

    @Value("${DB_DRIVER_CLASS}")
    private String driverClassName;
    @Value("${DB_URL}")
    private String url;
    @Value("${DB_USERNAME}")
    private String username;
    @Value("${DB_PASSWORD}")
    private String password;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = null;
        try {
            dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(driverClassName);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            return dataSource;
        } catch (Exception e) {
            Logger.getLogger(RootContextConfiguration.class.getName()).log(Level.WARNING, "Data source wasn't created.", e);
            return dataSource;
        }
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.use_sql_comments", true);
        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("ru.solon4ak.model");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.setDataSource(dataSource());
        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

}
