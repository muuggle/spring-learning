package AOP.BIKENG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class MaailService {
    @Autowired
    UsserService userService;

    public String sendMail() {
        ZoneId zoneId = userService.getZoneId();
        String dt = ZonedDateTime.now(zoneId).toString();
        return "Hello, it is " + dt;
    }
}
