package com.example.DemoCamundaAlurKerja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.alurkerja" , "com.example.DemoCamundaAlurKerja"})
@EnableJpaRepositories(basePackages = {"com.alurkerja", "com.example.DemoCamundaAlurKerja"})
@EntityScan(basePackages = {"com.alurkerja", "com.example.DemoCamundaAlurKerja"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
