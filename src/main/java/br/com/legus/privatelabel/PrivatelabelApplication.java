package br.com.legus.privatelabel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PrivatelabelApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrivatelabelApplication.class, args);
	}

}
