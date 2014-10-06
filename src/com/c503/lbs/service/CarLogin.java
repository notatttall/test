package com.c503.lbs.service;

import java.util.Iterator;
import java.util.Set;

import com.c503.lbs.entity.Car;
import com.c503.lbs.entity.RTLocation;

public class CarLogin {
	
	public static boolean login(Car car){
		RTLocation.carRT.put(car.getId(), car);
		return false;
	}

	public static void test() {
		Car car = new Car();
		car.setId("黑A0001");
		car.setLatitude("1111");
		car.setLongitude("222");
		login(car);
		
		Car car3 = new Car();
		car3.setId("黑A0001");
		car3.setLatitude("1121");
		car3.setLongitude("2112");
		login(car3);
		
		Car car4 = new Car();
		car4.setId("黑A23215");
		car4.setLatitude("111111");
		car4.setLongitude("222");
		login(car4);
		
		Car car5 = new Car();
		car5.setId("黑A1111");
		car5.setDriverIDCard("23902349029432424");
		car5.setWarkingStatus("正常");
		car5.setDriverName("小明");
		car5.setLatitude("112.1110");
		car5.setLongitude("211.1120");
		car5.setSpeed(23);
		car5.setOil(34);
		car5.setTirePressure("234");
		login(car5);
		
	
		
			
	}
}
