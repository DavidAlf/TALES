package com.spb.Aplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
scanBasePackages = {"com.spb.Aplication",
					"com.spb.controller",
					"com.spb.Service",
					"com.spb.Service.Impl",
					"com.spb.Dao",
					"com.spb.Dao.Impl"}
)
public class EmployeesProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesProjectApplication.class, args);
	}

}
