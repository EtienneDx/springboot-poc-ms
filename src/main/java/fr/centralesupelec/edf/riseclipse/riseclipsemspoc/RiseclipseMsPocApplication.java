package fr.centralesupelec.edf.riseclipse.riseclipsemspoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RiseclipseMsPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiseclipseMsPocApplication.class, args);
	}

}
