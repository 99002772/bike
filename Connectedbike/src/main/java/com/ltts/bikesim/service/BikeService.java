package com.ltts.bikesim.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ltts.bikesim.bean.Bike;
import com.ltts.bikesim.bean.BikeEvent;


@Service
public class BikeService {
	Map<String, Bike> bikeMap = new HashMap<String, Bike>();
	Map<Integer,BikeEvent> bikeEventMap = new HashMap<Integer, BikeEvent>();

	public BikeService() {
	super();
	// TODO Auto-generated constructor stub
	}

	@Autowired
	private KafkaTemplate<String, Bike> kafkaTemplate;
	
	@Autowired
	private KafkaTemplate<String, BikeEvent> kafkaTemplateBikeEvent;
	 
	 @Autowired
	 BikeUtil bikeUtil;
	 @Autowired
	 Bike bike;
	 

	private static final String TOPICBIKE = "Bike";
	private static final String TOPICBIKEEVENT = "BikeEvent";

	/**
	 * Adding VehicelSimulation as a object into VehicleSimulationMap
   */
	/*
	 * public void addSimulation(Bike bike){ bikeMap.put(bike.getVin(), bike); }
	 */
	
	/**
	 * Removing  VehicelSimulation object from VehicleSimulationMap
	 */
	/*
	 * public void removeSimulation(Bike bike) throws InterruptedException{
	 * bikeMap.remove(bike.getVin()); }
	 */
	
	public Map<String, Bike> getBikeMap() {
		return bikeMap;
	}

	public void setBikeMap(Map<String, Bike> bikeMap) {
		this.bikeMap = bikeMap;
	}

	
	/*
	 * public void postBike(Bike bike) { bikeMap.put(bike.getVin(),bike);
	 * kafkaTemplate.send(TOPICBIKE, bike); }
	 */
	
	public void postBikeEvent(BikeEvent bikeEvent) {
		bikeEventMap.put(bikeEvent.getId(),bikeEvent);
		kafkaTemplateBikeEvent.send(TOPICBIKEEVENT, bikeEvent);
		
	}
	
	
	public String post()
	{
		//bike.setSpeed(90);
		bikeRandom();
		kafkaTemplate.send(TOPICBIKE, bike);
		return "success";
	}
	
	public void bikeRandom() {
		 
		 bike.setVin("honda2010a7");
		 bike.setSpeed(bikeUtil.getRandomNumber(20,100));
		 bike.setEngine_status("off");
		 bike.setLatitude(bikeUtil.getRandomNumberLong(50,100));
		 bike.setLongitude(bikeUtil.getRandomNumberLong(25,30));
		 bike.setName("honda");
		 bike.setOdometer(bikeUtil.getRandomNumberLong(200,300));
		 bike.setEngine_rpm(bikeUtil.getRandomNumber(200,300));
		 bike.setFuel_capacity(bikeUtil.getRandomNumber(0,15));
		 bike.setEngine_load(bikeUtil.getRandomNumberLong(20,80));
		 bike.setFuel_consumption(bikeUtil.getRandomNumberLong(0,15));
		 bike.setEngine_temp(bikeUtil.getRandomNumberLong(69,100));
	 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * public String post() { // TODO Auto-generated method stub
	 * kafkaTemplate.send(TOPIC, new
	 * Bike(89,"off",25.99,789L,"him",9L,56,78,3,5L,67L,56L));
	 * 
	 * 
	 * 
	 * return "Published successfully";
	 * 
	 * }
	 */
}
