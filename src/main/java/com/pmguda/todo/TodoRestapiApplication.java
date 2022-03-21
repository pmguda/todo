package com.pmguda.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class TodoRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoRestapiApplication.class, args);
	}

}
