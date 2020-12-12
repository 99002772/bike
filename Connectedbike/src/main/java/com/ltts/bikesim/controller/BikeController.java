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
	/*
	  Logger logger = LoggerFactory.getLogger(BikeController.class);
	  Map<String, Bike> BikeMap = new HashMap<String, Bike>();
	 

	@Autowired
	private KafkaTemplate<String, Bike> kafkaTemplate;

	private static final String TOPIC = "Kafka_Example";

	/*
	 * public void addSimulation(Bike bike){ BikeMap.put(bike.getVin(), bike);
	 * kafkaTemplate.send(TOPIC, new Bike("abc","ON",29.5));
	 * //logger.info("vinnumber inside addSimulation" +bike.getVin()); }
	 */

/*	@GetMapping("/publish/{vin}")
	public String getdata(@PathVariable("vin") final String vin) {
		kafkaTemplate.send(TOPIC, new Bike(vin, "ON", 29.56465));

		// kafkaTemplate.send(TOPIC, new User(name, "Technology", 12000L));

		return "Published successfully";
	}
	
	@PostMapping("/publish")
	public String post(@RequestBody Bike bike) {

		kafkaTemplate.send(TOPIC, bike);
		return "Published successfully";
	}*/
	
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
	bikeservice.postBike(bike);
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
      kafkaTemplateBikeEvent.send(TOPICBIKEEVENT, bikeEvent);
      return "Published successfully";
  }
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
