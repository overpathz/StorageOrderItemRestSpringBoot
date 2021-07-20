package com.pathz.boot.rest;

import com.pathz.boot.rest.util.FillPrimaryData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);

		// calling method from utility class for initializing primary data
		FillPrimaryData.execute();
	}

}
