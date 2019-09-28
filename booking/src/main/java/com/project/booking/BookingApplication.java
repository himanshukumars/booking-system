package com.project.booking;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
@Configuration
public class BookingApplication {
	

    private static final Class<BookingApplication> applicationClass = BookingApplication.class;
    private static final Logger logger = LoggerFactory.getLogger(applicationClass);


	public static void main(String[] args) {
		logger.info("Initialising application .. ");
		SpringApplication.run(BookingApplication.class, args);
	}
	
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
