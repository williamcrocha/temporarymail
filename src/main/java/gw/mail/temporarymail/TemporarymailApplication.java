package gw.mail.temporarymail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TemporarymailApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemporarymailApplication.class, args);
    }

}
