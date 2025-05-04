package com.cinema.cinema;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = "com")
@RequiredArgsConstructor
@Slf4j
public class SpringProjectCinemaApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringProjectCinemaApplication.class, args);
	}

}
