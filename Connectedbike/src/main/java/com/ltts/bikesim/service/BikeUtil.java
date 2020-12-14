package com.ltts.bikesim.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class BikeUtil {
	
	public static int id=0;
	
	public Integer getRandomNumber(int min, int max) {
		Integer randomNumber = (int)(Math.random() * (max - min + 1) + min);
		return randomNumber;
	}
	public Double getRandomNumberDouble(int min, int max) {
		DecimalFormat df = new DecimalFormat("###.##");
		Double randomNumber = (Math.random() * (max - min + 1) + min);
		return Double.parseDouble(df.format(randomNumber));
	}
	
	public Long getRandomNumberLong(int min , int max)
	{
		
		Random rd = new Random(); // creating Random object
		Long randomNumber = (long) (Math.random() * (max - min + 1) + min);
	     return randomNumber ;
		
	}
	
	/**
	 * getRandomElement Storing engine_status in Array 
	 * 
	 */
	public String getRandomElement() 
    { 
		String[] engine_status = new String[]{"ON" ,"OFF"};
        Random rand = new Random(); 
	return engine_status[rand.nextInt(engine_status.length)]; 
    } 
	
	public Integer getEventId() 
    { 
      
        id = id + 1;
        return id;
    } 
	
	public static Date NewDate()
    {
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         Date date = new Date();
         return date;
         
    }
	
}
