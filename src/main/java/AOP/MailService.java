package AOP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MailService {
    @Autowired(required = false)
    @Value("#{smtpConfig.host}")
    private String smtpHost;
    @Value("#{smtpConfig.port}")
    private int smtpPort;
    //    @Qualifier("z")
    private ZoneId zoneId = ZoneId.systemDefault();

    @PostConstruct
    public void init() {
        System.out.println(("Init mail service with ZoneID = " + this.zoneId));
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("shutdown mail service");
    }

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }

    public String getTime() {
        return ZonedDateTime.now(this.zoneId).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }

    @MetricTime("loginMail")
    public void sendLoginMail(User user) {
        System.err.printf("Hi, %s! You are logged in at %s%n", user.getName(), getTime());
    }

    public void sendRegistrationMail(User user) {
        System.err.printf("Welcome, %s!%n", user.getName());

    }
}
