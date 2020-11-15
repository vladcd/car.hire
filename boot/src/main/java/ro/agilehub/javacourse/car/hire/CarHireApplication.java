package ro.agilehub.javacourse.car.hire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages = "ro.agilehub.javacourse.car.hire")
@EnableJpaRepositories
@EnableTransactionManagement
@SpringBootApplication
public class CarHireApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CarHireApplication.class, args);
    }
}
