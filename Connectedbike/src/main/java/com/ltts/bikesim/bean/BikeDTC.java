package com.ltts.bikesim.bean;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BikeDTC {
	private String vin;
	private String error_code;
	private Integer no_of_dtcs;
	List<String> dtc_list =new ArrayList<>();
	private String timestamp;

}
