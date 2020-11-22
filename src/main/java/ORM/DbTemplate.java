package ORM;

import JDBC.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class DbTemplate {

    public DbTemplate(JdbcTemplate jdbcTemplate, String s) {
    }

    public User get(Class<User> userClass, long id) {
        return null;
    }

    public void insert(User user) {
    }
}
