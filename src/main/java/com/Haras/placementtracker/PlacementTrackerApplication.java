package com.Haras.placementtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PlacementTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlacementTrackerApplication.class, args);
	}


}
