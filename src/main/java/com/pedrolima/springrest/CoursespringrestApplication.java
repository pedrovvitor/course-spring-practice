package com.pedrolima.springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.pedrolima.springrest.services.S3Service;


@SpringBootApplication
public class CoursespringrestApplication implements CommandLineRunner {
	
	@Autowired
	private S3Service s3Service;

	public static void main(String[] args) {
		SpringApplication.run(CoursespringrestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
		s3Service.uploadFile("C:\\Users\\pedro\\OneDrive\\Pictures\\cadastroOk.png");
	}
}
