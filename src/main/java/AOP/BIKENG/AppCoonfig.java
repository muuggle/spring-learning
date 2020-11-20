package AOP.BIKENG;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
class AppCoonfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppCoonfig.class);
        MaailService mailService = context.getBean(MaailService.class);
        System.out.println(mailService.sendMail());
    }
}

