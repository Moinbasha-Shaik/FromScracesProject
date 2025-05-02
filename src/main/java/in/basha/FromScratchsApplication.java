package in.basha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FromScratchsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FromScratchsApplication.class, args);
	}

}
