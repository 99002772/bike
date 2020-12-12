package com.ltts.bikesim.service;

import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class BikeUtil {
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
}
