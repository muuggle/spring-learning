package JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class RegisterController {
    @Autowired
    UserService userService;



}
