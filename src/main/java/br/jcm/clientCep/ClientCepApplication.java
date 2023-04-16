package br.jcm.clientCep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ClientCepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientCepApplication.class, args);
	}

}
