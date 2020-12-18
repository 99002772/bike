package com.ltts.bikesim.controller;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltts.bikesim.bean.Bike;
import com.ltts.bikesim.bean.BikeEvent;
import com.ltts.bikesim.bean.BikeLog;
import com.ltts.bikesim.scheduler.BikeScheduler;
import com.ltts.bikesim.service.BikeService;
import com.ltts.bikesim.service.SimulatorStop;

@RestController
@RequestMapping("kafka")
public class BikeController {
	
	@Autowired
	BikeService bikeservice;
	
	@Autowired
	SimulatorStop simulatorStop;
	
	@Autowired
	private ScheduledAnnotationBeanPostProcessor postProcessor;

	@Autowired
	private BikeScheduler bikeScheduler;
	
	@Autowired
	private BikeLog bikeLog;

	@Autowired
	private ObjectMapper objectMapper;
	
	private static final String SCHEDULED_TASKS = "scheduledTasks";


	@GetMapping("/bike/get")
	public String getController()
	{
	return "get";
	}

	@PostMapping("/bike/post")
	public String postController(@RequestBody Bike bike)
	{
	System.out.println(" post");
	//bikeservice.postBike(bike);
	return"sucessfully posted";
	}

	@Autowired
	private KafkaTemplate<String, Bike> kafkaTemplate;
	
	private static final String TOPICBIKE = "Bike";
	
	 
	@PostMapping("/publish/bike")
	public String getUserId(@RequestBody Bike bike) { 
      kafkaTemplate.send(TOPICBIKE, bike);
      return "Published successfully";
  }
	/*
	 * @PostMapping("/publish/vehicle") public String publishVehicle(@RequestBody
	 * BikeLog bikeLog) { bikeservice.bikeRegister(bikeLog); return
	 * "Published successfully"; }
	 */
	
	@CrossOrigin
    @PostMapping("/publish/vehicle")
    public String postController(@RequestBody String vehicle)
    {
        Object file = JSONValue.parse(vehicle);
        JSONObject jsonObjectdecode = (JSONObject)file;
        String vid=(String)jsonObjectdecode.get("vin");
        
        System.out.println(vid);
        
        if(vid.isEmpty()) {
            return "please enter details";
        }
        else {
            String vin=(String)jsonObjectdecode.get("vin");
            String name=(String)jsonObjectdecode.get("name");
           
            bikeLog.setVin(vin);
            bikeLog.setName(name);
            bikeservice.bikeRegister(bikeLog);
       
            return"sucessfully posted";
       
          }
        
    }
	
	@PostMapping("/publish/bikeevent")
	public String getBikeEvent(@RequestBody BikeEvent bikeEvent) {
		bikeservice.postBikeEvent(bikeEvent);
      return "Published successfully";
  }
	
	@GetMapping("/publish")
	public String post() throws IOException
	{ 
			 bikeservice.post();
			 return"Published successfully";
	}
	
	
	@GetMapping("/publish/postbikeevent")
	public String bikeEvent()
	{ 
			 
			bikeservice.bikeEvent();
			 return"Published successfully";
	}
	





@GetMapping(value = "/stopScheduler")
public String stopSchedule(){
	
	 bikeservice.stopSimulation();
	 return"Simulation stopped successfully";
}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
