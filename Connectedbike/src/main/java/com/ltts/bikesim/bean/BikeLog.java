package com.ltts.bikesim.bean;

public class BikeLog {
	
			private String vin;
			private String name;
			private String engine_status;
			private Double latitude;
			private Double longitude;
			private Integer engine_rpm;
			private Double engine_fuel_rate = 2000.0;
			private Double calculated_engine_load;
			private Long odometer = 250L;
			private String timestamp;
			private boolean flag = false;
			
			public boolean isFlag() {
				return flag;
			}
			public void setFlag(boolean flag) {
				this.flag = flag;
			}
			public String getVin() {
				return vin;
			}
			public void setVin(String string) {
				this.vin = string;
			}
			public String getEngine_status() {
				return engine_status;
			}
			public void setEngine_status(String engine_status) {
				this.engine_status = engine_status;
			}
			public Double getLatitude() {
				return latitude;
			}
			public void setLatitude(Double latitude) {
				this.latitude = latitude;
			}
			public Double getLongitude() {
				return longitude;
			}
			public void setLongitude(Double longitude) {
				this.longitude = longitude;
			}
			public Integer getEngine_rpm() {
				return engine_rpm;
			}
			public void setEngine_rpm(Integer engine_rpm) {
				this.engine_rpm = engine_rpm;
			}
			public Double getEngine_fuel_rate() {
				return engine_fuel_rate;
			}
			public void setEngine_fuel_rate(Double engine_fuel_rate) {
				this.engine_fuel_rate = engine_fuel_rate;
			}
			public Double getCalculated_engine_load() {
				return calculated_engine_load;
			}
			public void setCalculated_engine_load(Double calculated_engine_load) {
				this.calculated_engine_load = calculated_engine_load;
			}
			public Long getOdometer() {
				return odometer;
			}
			public void setOdometer(Long odometer) {
				this.odometer = odometer;
			}
			public String getTimestamp() {
				return timestamp;
			}
			public void setTimestamp(String timestamp) {
				this.timestamp = timestamp;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			

		}

