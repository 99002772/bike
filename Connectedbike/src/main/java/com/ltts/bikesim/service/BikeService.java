package com.ltts.bikesim.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ltts.bikesim.bean.Bike;
import com.ltts.bikesim.bean.BikeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	private static final String TOPICBIKE = "Bike";
	private static final String TOPICBIKEEVENT = "BikeEvent";

	/**
	 * Adding VehicelSimulation as a object into VehicleSimulationMap
   */
	public void addSimulation(Bike bike){	
		bikeMap.put(bike.getVin(), bike);
	}
	
	/**
	 * Removing  VehicelSimulation object from VehicleSimulationMap
	 */
	public void removeSimulation(Bike bike) throws InterruptedException{
		bikeMap.remove(bike.getVin());
	}
	
	public Map<String, Bike> getBikeMap() {
		return bikeMap;
	}

	public void setBikeMap(Map<String, Bike> bikeMap) {
		this.bikeMap = bikeMap;
	}

	/*
	 * public void postBike(Bike bike) { // TODO Auto-generated method stub
	 * bikeMap.put(bike.getVin(),bike); // System.out.println(boatMap);
	 * kafkaTemplate.send(TOPIC, bike);
	 * 
	 * }
	 */



	public void postBike(Bike bike) {
		// TODO Auto-generated method stub
		bikeMap.put(bike.getVin(),bike);
		// System.out.println(boatMap);
		kafkaTemplate.send(TOPICBIKE, bike);
		
	}
	
	public void postBikeEvent(BikeEvent bikeEvent) {
		// TODO Auto-generated method stub
		bikeEventMap.put(bikeEvent.getId(),bikeEvent);
		// System.out.println(boatMap);
		kafkaTemplateBikeEvent.send(TOPICBIKEEVENT, bikeEvent);
		
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
