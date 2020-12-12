package com.consumer.services;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@PropertySource({"classpath:application.properties"})
    @Component
    public class TopicConsumer {

 
    	@Value("${url}")
    	private String url;
    	
        @Value("${user}")
    	private String user;

    	@Value("${password}")
    	private String password;
    	
                private final List<String> messages = new ArrayList<>();

 

				/*
				 * private final String url = "jdbc:postgresql://localhost/Bike"; private final
				 * String user = "postgres"; private final String password = "postgres123";
				 */

        public Connection connect() {
        Connection conn = null;
         try {
                 conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to the PostgreSQL server successfully.");
         	 } 
         catch (SQLException e) {
                   System.out.println(e.getMessage());
               }
         return conn;
        }

    @KafkaListener(topics = "Bike", groupId = "kafka-sandbox")
     public void listen(String message) {
    	Object file = JSONValue.parse(message);
    	JSONObject jsonObjectdecode = (JSONObject)file;
    	String vin =(String)jsonObjectdecode.get("vin");
        String engine_status=(String)jsonObjectdecode.get("engine_status");
        Long latitude=(Long)jsonObjectdecode.get("latitude");
        String name = (String)jsonObjectdecode.get("name");
       Long odometer=(Long)jsonObjectdecode.get("odometer");
        Long engine_rpm=(Long)jsonObjectdecode.get("engine_rpm");
        Long speed=(Long)jsonObjectdecode.get("speed");
       Long fuel_capacity=(Long)jsonObjectdecode.get("fuel_capacity");
        
        Long engine_load=(Long)jsonObjectdecode.get("engine_load");
        Long longitude=(Long)jsonObjectdecode.get("longitude");
        Long fuel_consumption=(Long)jsonObjectdecode.get("fuel_consumption");
        Long engine_temp=(Long)jsonObjectdecode.get("engine_temp");

            TopicConsumer topicConsumer = new TopicConsumer();
            Connection conn = topicConsumer.connect();
            try {
                    Statement stmnt = null;
                    stmnt = connect().createStatement();
                    String query = "INSERT INTO bike(vin, engine_status, latitude,name,engine_rpm,speed,fuel_capacity,engine_load,longitude,fuel_consumption,engine_temp,odometer) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pst = conn.prepareStatement(query);       
                    pst.setString(1,vin);
                    pst.setString(2,engine_status);
                    pst.setLong(3,latitude);
                    pst.setString(4, name);
                    pst.setLong(5,engine_rpm);
                    pst.setLong(6,speed);
                    pst.setLong(7,fuel_capacity); 
                    pst.setLong(8,engine_load);
                    pst.setLong(9,longitude);
                    pst.setLong(10,fuel_consumption);
                    pst.setLong(11,engine_temp);
                    pst.setLong(12,odometer);
                    
                    System.out.println("after insert");
// stmnt.execute(query);
                    pst.executeUpdate();
                    System.out.println("Afterupdate");
 
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            synchronized (messages) {
                    messages.add(message);
                }
      }

 

 
        public List<String> getMessages() {
    
                return messages;

 

            }

 

}
 