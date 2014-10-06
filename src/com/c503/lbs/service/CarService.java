package com.c503.lbs.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.c503.lbs.dao.Dao;
import com.c503.lbs.entity.Car;

/**
 * 
 * 单例--车辆操作
 * @author huchaofeng
 *
 */
public class CarService {

	private static CarService carService = null;
	private CarService() {
	}
	public static CarService getInstance() {
	   if (carService == null) {
		   carService = new CarService();
	   }
	   return carService;
	}

	
	/**
	 * 根据车牌号创建一张表
	 * @param carId  车牌号
	 * @return
	 */
	public boolean createCarTable(String carId){
		Dao dao = Dao.getInstance();
		String sql = "CREATE TABLE " + carId +" (keyId int  NOT NULL AUTO_INCREMENT,id varchar(20) not null,status varchar(20),warkingStatus varchar(20)," +
				" driverName varchar(20),driverIDCard varchar(50),certificate varchar(50),organization varchar(50)," +
				"speed int,longitude varchar(20),latitude varchar(20),elevation varchar(20)," +
				"time varchar(20),oil varchar(20),tirePressure varchar(20),pathID varchar(20),gasSolubility varchar(20)," +
				"primary key (keyId));";
		System.out.println(sql);
		if (dao.createSQL(sql) == true) {
			System.out.println("创建成功");
			return true;
		}
		return false;
	}
	
	/**
	 * 添加车辆实时信息
	 * @param car  车辆实时信息
	 * @return   是否添加成功
	 */
	public boolean addCarRTInfo(Car car){
		Dao dao = Dao.getInstance();
		
		String insert = "insert into " +car.getId()+ "(id,status,warkingStatus,driverName," +
				"driverIDCard,certificate,organization,speed,longitude,latitude,elevation,time,oil" +
				",tirePressure,pathID,gasSolubility" + ")values('" + car.getId()+"','"+car.getStatus()+"','"+car.getWarkingStatus()+"','"+car.getDriverName()
				+"','" + car.getDriverIDCard() + "','" + car.getCertificate() + "','"+ car.getOrganization() + "','"  + car.getSpeed()+"','"+car.getLongitude()+"','"+car.getLatitude()
				+"','" + car.getElevation()+"','"+car.getTime()+"','"+car.getOil()
				+"','"+car.getTirePressure()+"','"+car.getPathID() + "','" + car.getGasSolubility() + "')";
		System.out.println(insert);
		return dao.insertSQL(insert);
		
	}
	
	/**
	 * 根据车牌号查找车辆轨迹号
	 * @param carId  车辆号
	 * @return  车辆轨迹号
	 */
	public List<String> findPathId(String carId){
		List<String> pathIds = new ArrayList<String>();
		
		String s = "select distinct(pathId) from " + carId ;
		Dao dao = Dao.getInstance();
		ResultSet rs = dao.selectSQL(s);
		
		try {
			while (rs.next()) {
				String pathId = rs.getString(1);
				System.out.println(pathId);
				pathIds.add(pathId);
			}
		} catch (SQLException e) {
			System.out.println("显示时数据库出错。");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("显示出错。");
			e.printStackTrace();
		}
		return pathIds;
	}
	
	/**
	 * 根据轨迹号查找轨迹
	 * @param carId   车牌号
	 * @param pathId  轨迹号
	 * @return List<Car> 车辆信息列表
	 */
	public List<Car> findByPathId(String carId,String pathId){
		
		String s = "select * from " + carId + " where pathId='" + pathId+"'";
		System.out.println(s);
		Dao dao = Dao.getInstance();
		ResultSet rs = dao.selectSQL(s);
		List<Car> carPath = new ArrayList<Car>();
		try {
			while (rs.next()) {
				Car car = new Car();
				car.setId(rs.getString(2));
				car.setSpeed(rs.getInt(9));
				car.setLongitude(rs.getString(10));
				car.setLatitude(rs.getString(11));
				car.setElevation(rs.getString(12));
				car.setTime(rs.getString(13));
				car.setPathID(rs.getString(16));
				carPath.add(car);
			}
		} catch (SQLException e) {
			System.out.println("显示时数据库出错。");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("显示出错。");
			e.printStackTrace();
		}
		return carPath;
	}
	

	
	public static void main(String[] args) {
		CarService cs = CarService.getInstance();
		
		//创建车辆表测试
		//cs.createCarTable("黑A1111");
		
		//添加车辆实时信息测试
	/*	Car car = new Car("黑A1111","zhang三","12321312313","A级","好人中心","0002","1001",23,"125","9","5","201409221821",34,"42","20140922210","0001");
		cs.addCarRTInfo(car);
		Car car1 = new Car("黑A1111","zhang三","12321312313","A级","好人中心","0002","1001",23,"126","9","6","201409221821",34,"42","20140922210","0001");
		cs.addCarRTInfo(car1);
		Car car2 = new Car("黑A1111","zhang三","12321312313","A级","好人中心","0002","1001",23,"127","6","7","201409221821",34,"42","20140922210","0001");
		cs.addCarRTInfo(car2);
		Car car3 = new Car("黑A1111","zhang三","12321312313","A级","好人中心","0002","1001",23,"128","7","8","201409221821",34,"42","20140922210","0001");
		cs.addCarRTInfo(car3);
		Car car4 = new Car("黑A1111","zhang三","12321312313","A级","好人中心","0002","1001",23,"129","8","9","201409221821",34,"42","20140922210","0001");
		cs.addCarRTInfo(car4);*/
		
		//根据轨迹号获取轨迹测试
		/*List<Car>  path = cs.findByPathId("黑A1111","0001");
		for(int i=0;i<path.size();i++){
			String ev = path.get(i).getElevation();
			String la = path.get(i).getLatitude();
			String lo = path.get(i).getLongitude();
			int sp  = path.get(i).getSpeed();
			String tm = path.get(i).getTime();
			System.out.println("  纬度：" + la + "  精度："+lo + "高程：" + ev+ " 速度："+ sp + " 时间："+tm);
		}*/
		
		
		//获取轨迹号测试
	/*	List<String>  pathList = cs.findPathId("黑A1111");
		for(int i=0;i < pathList.size();i++){
			String pathId = pathList.get(i);
			System.out.println("pathId:"+pathId);
		}*/
		
	}
	
}
