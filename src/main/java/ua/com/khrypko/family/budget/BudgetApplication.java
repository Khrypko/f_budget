package ua.com.khrypko.family.budget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:mailtext.properties")
public class BudgetApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetApplication.class, args);
	}
}
