package com.c503.lbs.entity;

import java.io.Serializable;

/**
 * 实体类 --- 车
 * @author huchaofeng
 *
 */
public class Car implements Serializable{
	
	/**
	 * 可序列化
	 */
	private static final long serialVersionUID = 8934354093886775103L;

	/**
	 * 车牌号
	 */
	private String id;
	
	/**
	 * 驾驶员姓名
	 */
	private String driverName;
	
	/**
	 * 驾驶员身份证号
	 */
	private String driverIDCard;
	
	/**
	 * 证书名称
	 */
	private String certificate;
	
	/**
	 * 颁发机构名称
	 */
	private String organization;
	
	/**
	 * 车的状态
	 */
	private String status;
	
	/**
	 * 报警状态
	 */
	private String warkingStatus;
	
	/**
	 * 车速,单位km/h
	 */
	private int speed;
	
	/**
	 * 车位置的经度
	 */
	private String longitude;
	
	/**
	 * 车位置的纬度
	 */
	private String latitude;
	
	/**
	 * 高程
	 */
	private String elevation;
	
	/**
	 * 与经纬度对应的时间
	 */
	private String time;

	/**
	 * 油量：L
	 */
	private int  oil;
	
	/**
	 * 胎压
	 */
	private String tirePressure;
	
	/**
	 * 气体溶度
	 */
	private String gasSolubility;
	
	/**
	 * 轨迹编号
	 */
	private String pathID;
	
	/**
	 * 无参构造函数
	 */
	public Car() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}



	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getElevation() {
		return elevation;
	}

	public void setElevation(String elevation) {
		this.elevation = elevation;
	}

	public int getOil() {
		return oil;
	}

	public void setOil(int oil) {
		this.oil = oil;
	}

	public String getTirePressure() {
		return tirePressure;
	}

	public void setTirePressure(String tirePressure) {
		this.tirePressure = tirePressure;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPathID() {
		return pathID;
	}

	public void setPathID(String pathID) {
		this.pathID = pathID;
	}

	public String getDriverIDCard() {
		return driverIDCard;
	}

	public void setDriverIDCard(String driverIDCard) {
		this.driverIDCard = driverIDCard;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getWarkingStatus() {
		return warkingStatus;
	}

	public void setWarkingStatus(String warkingStatus) {
		this.warkingStatus = warkingStatus;
	}

	public String getGasSolubility() {
		return gasSolubility;
	}

	public void setGasSolubility(String gasSolubility) {
		this.gasSolubility = gasSolubility;
	}

	public Car(String id, String driverName, String driverIDCard,
			String certificate, String organization, String status,
			String warkingStatus, int speed, String longitude, String latitude,
			String elevation, String time, int oil, String tirePressure,
			String gasSolubility, String pathID) {
		super();
		this.id = id;
		this.driverName = driverName;
		this.driverIDCard = driverIDCard;
		this.certificate = certificate;
		this.organization = organization;
		this.status = status;
		this.warkingStatus = warkingStatus;
		this.speed = speed;
		this.longitude = longitude;
		this.latitude = latitude;
		this.elevation = elevation;
		this.time = time;
		this.oil = oil;
		this.tirePressure = tirePressure;
		this.gasSolubility = gasSolubility;
		this.pathID = pathID;
	}

	@Override
	public String toString() {
		return "Car [certificate=" + certificate + ", driverIDCard="
				+ driverIDCard + ", driverName=" + driverName + ", elevation="
				+ elevation + ", gasSolubility=" + gasSolubility + ", id=" + id
				+ ", latitude=" + latitude + ", longitude=" + longitude
				+ ", oil=" + oil + ", organization=" + organization
				+ ", pathID=" + pathID + ", speed=" + speed + ", status="
				+ status + ", time=" + time + ", tirePressure=" + tirePressure
				+ ", warkingStatus=" + warkingStatus + "]";
	}

	
}
