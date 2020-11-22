package ORM;

import JDBC.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UserService {
    @Autowired
    DbTemplate db;

    public User getUserById(long id) {
        return db.get(User.class, id);
    }

//    public User getUserByEmail(String email) {
//        return db.from(User.class).where("email=?", email).unique();
//    }
//
//    public List<User> getUser(int pageIndex){
//        int pageSize=100;
//        return db.from(User.class).orderby("id").limit((pageIndex-1)*pageSize,pageSize)
//                .list();
//    }

    public User register(String email,String password,String name){
        User user=new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setCreatedAt(System.currentTimeMillis());
        db.insert(user);
        return user;
    }

}
