package JDBC;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.apache.bcel.generic.RET;
import org.hibernate.SessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.management.MXBean;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan
@PropertySource("jdbc.properties")
@EnableTransactionManagement//启用声明式
public class AppConfig {
//    @Value("${jbdc.url}")
//    String jdbcUrl;
//    @Value("${jdbc.username}")
//    String jdbcUsername;
//    @Value("${jdbc.password}")
//    String jdbcPassword;
//
//    @Bean
//    DataSource createDataSource() {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl(jdbcUrl);
//        config.setUsername(jdbcUsername);
//        config.setPassword(jdbcPassword);
//        config.setPassword(jdbcPassword);
//        config.addDataSourceProperty("autoCommit", "true");
//        config.addDataSourceProperty("connectionTimeout", "5");
//        config.addDataSourceProperty("idleTimeout", "60");
//        return new HikariDataSource(config);
//    }

    @Bean
    SqlSessionFactoryBean createSqlSessionFactoryBean(@Autowired DataSource dataSource) {
        var sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    PlatformTransactionManager createTxManager(@Autowired DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }


//    @Bean
//    JdbcTemplate createJdbcTemplate(@Autowired DataSource dataSource) {
//        return new JdbcTemplate();
//    }
//
//    @Bean
//    PlatformTransactionManager createTxManager(@Autowired DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean
//    LocalSessionFactoryBean createSessionFactory(@Autowired DataSource dataSource) {
//        var props = new Properties();
//        props.setProperty("hibernate.hbm2ddl.auto", "update"); // 生产环境不要使用
//        props.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
//        props.setProperty("hibernate.show_sql", "true");
//        var sessionFactoryBean = new LocalSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource);
//        sessionFactoryBean.setPackagesToScan("JDBC");
//        sessionFactoryBean.setHibernateProperties(props);
//        return sessionFactoryBean;
//    }
//
//    @Bean
//    HibernateTemplate createhibernateTemplate(@Autowired SessionFactory sessionFactory) {
//        return new HibernateTemplate(sessionFactory);
//    }
//
//    @Bean
//    PlatformTransactionManager createTxManager(@Autowired SessionFactory sessionFactory) {
//        return new HibernateTransactionManager(sessionFactory);

}
