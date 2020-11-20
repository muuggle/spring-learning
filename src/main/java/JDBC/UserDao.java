package JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.PostConstruct;

public class UserDao extends JdbcDaoSupport {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init(){
        super.setJdbcTemplate(jdbcTemplate);
    }
}

abstract class AbstractDao<T> extends JdbcDaoSupport{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Class<T> entityClass;
    private RowMapper<T> rowMapper;
    private String table;

    public AbstractDao(){
    }

    @PostConstruct
    public void init(){
        super.setJdbcTemplate(jdbcTemplate);
    }
}
