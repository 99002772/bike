package com.ltts.bikesim.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
//import java.util.logging.Logger;
import java.util.Map;
import java.util.Map.Entry;

 

//import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import com.ltts.bikesim.bean.Bike;
import com.ltts.bikesim.controller.BikeController;



@EnableScheduling
@Component
public class BikeScheduler {
	Logger logger = LoggerFactory.getLogger(BikeScheduler.class);

	@Autowired
	BikeController bikeController;

	/*
	 * @Scheduled(initialDelayString="${TIMEOUT_SCHEDULER_INTIAL_DELAY}",
	 * fixedRateString="${TIMEOUT_SCHEDULER_DELAY}")
	 * 
	 * @Scheduled(fixedDelay = 10000, initialDelay = 10000) public void
	 * fixedDelaySch() { SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); Date now = new Date(); String
	 * strDate = sdf.format(now); System.out.println("Fixed Delay scheduler:: " +
	 * strDate); }
	 */

	
	//@Scheduled(fixedDelay = 60000, initialDelay = 60000) 
	
	@Scheduled(initialDelayString="${TIMEOUT_SCHEDULER_INTIAL_DELAY}",
	 fixedRateString="${TIMEOUT_SCHEDULER_DELAY}") 
	 public void pushBikeData()
	 { 
		// bikeController.post();
	 
	 }
	
	
	
	 

	/*
	 * @Scheduled(initialDelayString="${TIMEOUT_SCHEDULER_INTIAL_DELAY}",
	 * fixedRateString="${TIMEOUT_SCHEDULER_DELAY}") public void pushVehicleData() {
	 * 
	 * 
	 * 
	 * try { Iterator<Entry<String, Bike>> entries =
	 * BikeSimulatorService.getBikeMap().entrySet().iterator(); while
	 * (entries.hasNext()) { Entry<String, Bike> entry = entries.next();
	 * BikeSimulatorService.addSimulation(entry.getValue()); } } catch(Exception e)
	 * { logger.error("Exception in push vehicle data",e);
	 * System.out.println("excep" +e); e.fillInStackTrace(); } }
	 */
	  	
}
