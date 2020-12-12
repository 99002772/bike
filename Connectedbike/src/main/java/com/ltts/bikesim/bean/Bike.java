package com.ltts.bikesim.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bike {
	
	private String vin;
	private String engine_status;
	private Double latitude;
	private Long longitude;
	private String name;
	private Long odometer;
	private Integer engine_rpm;
	private Integer speed; 
	private Integer fuel_capacity;
	private Long engine_load;
	private Long fuel_consumption;
	private Long engine_temp;

}
