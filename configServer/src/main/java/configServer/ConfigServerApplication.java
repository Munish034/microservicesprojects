package configServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
<<<<<<< HEAD

@SpringBootApplication
@EnableConfigServer
=======




@SpringBootApplication
	@EnableConfigServer
>>>>>>> d57170f9f6543b743e2f3a858d884da59b5876b3
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
