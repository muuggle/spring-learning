package JDBC;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class UserService$$EnhancerBySpringCGLIB  extends UserService{
    UserService target=new UserService();
    PlatformTransactionManager txManager=new DataSourceTransactionManager();

    public User register(String email,String password,String name){
        TransactionStatus tx=null;

        try {
            tx=txManager.getTransaction(new DefaultTransactionDefinition());
            target.register(email,password,name);
            txManager.commit(tx);
        } catch (RuntimeException e){
            txManager.rollback(tx);
            throw e;
        }
        return null;
    }
}
