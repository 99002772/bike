package com.ltts.bikesim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltts.bikesim.bean.Bike;
import com.ltts.bikesim.bean.BikeEvent;
import com.ltts.bikesim.service.BikeService;

@RestController
@RequestMapping("kafka")
public class BikeController {
	
	@Autowired
	BikeService bikeservice;

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
	
	@Autowired
	private KafkaTemplate<String, BikeEvent> kafkaTemplateBikeEvent;

	private static final String TOPICBIKE = "Bike";
	private static final String TOPICBIKEEVENT = "BikeEvent";
	

	
	/*
	 * @GetMapping("/publish") public String post() { kafkaTemplate.send(TOPICBIKE,
	 * new Bike(38,"off",25.99,789L,"him",9L,56,78,3,5L,67L,56L));
	 * //kafkaTemplate.send(TOPIC, bike); return"Published successfully"; }
	 */
	 
	@PostMapping("/publish/bike")
	public String getUserId(@RequestBody Bike bike) { 
      kafkaTemplate.send(TOPICBIKE, bike);
      return "Published successfully";
  }
	
	
	@PostMapping("/publish/bikeevent")
	public String getBikeEvent(@RequestBody BikeEvent bikeEvent) {
		bikeservice.postBikeEvent(bikeEvent);
      //kafkaTemplateBikeEvent.send(TOPICBIKEEVENT, bikeEvent);
      return "Published successfully";
  }
	
	@GetMapping("/publish")
	public String post()
	{ 
			 
			bikeservice.post();
			 return"Published successfully";
			 }
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
