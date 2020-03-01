package ebj.yujinkun.quote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class QuoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuoteApplication.class, args);
	}

}
