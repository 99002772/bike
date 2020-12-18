package com.ltts.bikesim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SimulatorStop {
	 @Autowired
	    private ApplicationContext context;

	    public void close() {
	    	System.out.println("Stopping simulation...");
	        SpringApplication.exit(context);
	    }
}
