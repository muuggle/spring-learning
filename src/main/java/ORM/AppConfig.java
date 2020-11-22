package ORM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@EnableTransactionManagement
@PropertySource("jdbc.properties")
public class AppConfig {
    @Bean
    DataSource createDataSource(){
        return null;
    }

    @Bean
    JdbcTemplate createJdbcTemplate(@Autowired DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    DbTemplate createDbTemplate(@Autowired JdbcTemplate jdbcTemplate){
        return new DbTemplate(jdbcTemplate,"ORM.entity");
    }

    @Bean
    PlatformTransactionManager createTxManager(@Autowired DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
