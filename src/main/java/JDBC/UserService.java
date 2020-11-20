package JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

@Component
@Transactional
public class UserService {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public User getUserByID(long id) {
        return jdbcTemplate.execute((Connection conn) -> {
            try (var ps = conn.prepareStatement("SELECT * FROM users WHERE id = ?")) {
                ps.setObject(1, id);
                try (var rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return new User(
                                rs.getLong("id"),
                                rs.getString("email"),
                                rs.getString("password"), // password
                                rs.getString("name"));
                    }
                    throw new RuntimeException("user not fouded by id");
                }
            }
        });
    }

    public User getUserByName(String name) {
        return jdbcTemplate.execute("SELECT * FROM users WHERE name = ?",
                (PreparedStatement ps) -> {
                    ps.setObject(1, name);
                    try (var rs = ps.executeQuery()) {
                        if (rs.next()) {
                            return new User(
                                    rs.getLong("id"),
                                    rs.getString("email"),
                                    rs.getString("password"),
                                    rs.getString("name"));
                        }
                        throw new RuntimeException("user not found by id");
                    }
                });
    }

    public User getUserByEmail(String email) {
        return jdbcTemplate.queryForObject("select * from users where email=?", new Object[]
                        {email},
                (ResultSet rs, int rpwNum) -> {
                    return new User(
                            rs.getLong("id"), // id
                            rs.getString("email"), // email
                            rs.getString("password"), // password
                            rs.getString("name"));
                });
    }

    public void updateUser(User user) {
        if (1 != jdbcTemplate.update("update user set name=? where id=?", user.getName(),
                user.getId())) {
            throw new RuntimeException("user nod found by id");
        }
    }

//    @Transactional
    public User register(String email, String password, String name) {
        KeyHolder holder = new GeneratedKeyHolder();
        if (1 != jdbcTemplate.update((conn) -> {

                    var ps = conn.prepareStatement("INSERT INTO users(email,password,name) VALUES(?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);
                    ps.setObject(1, email);
                    ps.setObject(2, password);
                    ps.setObject(3, name);
                    return ps;
                },
                holder)
        ) {
            throw new RuntimeException("insert failed");

        }
        return new User(Objects.requireNonNull(holder.getKey()).longValue(), email, password, name);
    }
}



