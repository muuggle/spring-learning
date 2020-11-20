package AOP.BIKENG;

import AOP.LoggingAspect;
import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Component
public class UsserService {
    // 成员变量:
    public final ZoneId zoneId = ZoneId.systemDefault();

    // 构造方法:
    public UsserService() {
        System.out.println("UserService(): init...");
        System.out.println("UserService(): zoneId = " + this.zoneId);
    }

    // public方法:
    public ZoneId getZoneId() {
        return zoneId;
    }

    // public final方法:
    public final ZoneId getFinalZoneId() {
        return zoneId;
    }
}

//class UsserService$$EnhancerBySpringCGLIB extends UsserService {
//    UsserService tartget;
//    LoggingAspect aspect;
//
//    public UsserService$$EnhancerBySpringCGLIB() {
//
//    }
//
//    public ZoneId getZoneId() {
//        aspect.doAccessCheck();
//        return tartget.getZoneId();
//    }
//}
