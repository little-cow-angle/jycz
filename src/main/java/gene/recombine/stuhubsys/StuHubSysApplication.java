package gene.recombine.stuhubsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class StuHubSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuHubSysApplication.class, args);
    }

}
