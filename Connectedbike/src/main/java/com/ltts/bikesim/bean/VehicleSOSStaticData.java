package com.ltts.bikesim.bean;

import java.util.Date;

public class VehicleSOSStaticData {
	// Integer id;
	Integer id;
	String vin;
	Double latitude;
	Double longitude;
	Integer altitude;
	Integer heading;
	Integer speed;
	String brake_operation;
	String emergency_brake;
	Integer handle_angle;
	Boolean light_status;
	Integer tire_pressure_front;
	Integer tire_pressure_rear;
	String crash_events;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
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
	public Integer getAltitude() {
		return altitude;
	}
	public void setAltitude(Integer altitude) {
		this.altitude = altitude;
	}
	public Integer getHeading() {
		return heading;
	}
	public void setHeading(Integer heading) {
		this.heading = heading;
	}
	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	public String getBrake_operation() {
		return brake_operation;
	}
	public void setBrake_operation(String brake_operation) {
		this.brake_operation = brake_operation;
	}
	public String getEmergency_brake() {
		return emergency_brake;
	}
	public void setEmergency_brake(String emergency_brake) {
		this.emergency_brake = emergency_brake;
	}
	public Integer getHandle_angle() {
		return handle_angle;
	}
	public void setHandle_angle(Integer handle_angle) {
		this.handle_angle = handle_angle;
	}
	public Boolean getLight_status() {
		return light_status;
	}
	public void setLight_status(Boolean light_status) {
		this.light_status = light_status;
	}
	public Integer getTire_pressure_front() {
		return tire_pressure_front;
	}
	public void setTire_pressure_front(Integer tire_pressure_front) {
		this.tire_pressure_front = tire_pressure_front;
	}
	public Integer getTire_pressure_rear() {
		return tire_pressure_rear;
	}
	public void setTire_pressure_rear(Integer tire_pressure_rear) {
		this.tire_pressure_rear = tire_pressure_rear;
	}
	public String getCrash_events() {
		return crash_events;
	}
	public void setCrash_events(String crash_events) {
		this.crash_events = crash_events;
	}
		
//		public Integer getId() {
//			return id;
//		}
//		public void setId(Integer id) {
//			this.id = id;
//		}
		
		

}
