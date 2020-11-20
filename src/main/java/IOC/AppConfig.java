package IOC;

import IOC.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@PropertySource("smtp.properties")
@EnableAspectJAutoProxy
public class AppConfig {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.login("bob@example.com", "password");
    }

//    @Bean
//    ZoneId createZoneId(@Value("${app.zone:Z}") String zoneId) {
//        return ZoneId.of(zoneId);
//    }
}
