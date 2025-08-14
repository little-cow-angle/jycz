package gene.recombine.stuhubsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("gene.recombine.stuhubsys.mapper")
public class StuHubSysApplication {
    public static void main(String[] args) {
        SpringApplication.run(StuHubSysApplication.class, args);
    }
}
