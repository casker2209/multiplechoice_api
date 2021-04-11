package vn.usth.internship.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class InternshipApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternshipApiApplication.class, args);
	}

}
