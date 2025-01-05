package Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "Api")
@EnableJpaRepositories(basePackages = "Api.repository")
@EntityScan(basePackages = "Api.entity")
public class ApiTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiTaskApplication.class, args);
    }
}