package cn.boom.pojo;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import cn.boom.util.JsonDateSerializer;

public class Car {
	private Integer carId;

	private String carPlate;

	private String carMark;

	private String carColor;

	private Integer carMileage;

	private Integer carLimit;

	private Date carAge;

	private String carPhoto;

	private Integer carUserid;

	private String reserve1;

	private String reserve2;

	private String reserve3;

	private String reserve4;

	private String reserve5;

	/****/
	private String userName;

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getCarPlate() {
		return carPlate;
	}

	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate == null ? null : carPlate.trim();
	}

	public String getCarMark() {
		return carMark;
	}

	public void setCarMark(String carMark) {
		this.carMark = carMark == null ? null : carMark.trim();
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor == null ? null : carColor.trim();
	}

	public Integer getCarMileage() {
		return carMileage;
	}

	public void setCarMileage(Integer carMileage) {
		this.carMileage = carMileage;
	}

	public Integer getCarLimit() {
		return carLimit;
	}

	public void setCarLimit(Integer carLimit) {
		this.carLimit = carLimit;
	}

	// 使用自定义的date转json转换器
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getCarAge() {
		return carAge;
	}

	public void setCarAge(Date carAge) {
		this.carAge = carAge;
	}

	public String getCarPhoto() {
		return carPhoto;
	}

	public void setCarPhoto(String carPhoto) {
		this.carPhoto = carPhoto == null ? null : carPhoto.trim();
	}

	public Integer getCarUserid() {
		return carUserid;
	}

	public void setCarUserid(Integer carUserid) {
		this.carUserid = carUserid;
	}

	public String getReserve1() {
		return reserve1;
	}

	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1 == null ? null : reserve1.trim();
	}

	public String getReserve2() {
		return reserve2;
	}

	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2 == null ? null : reserve2.trim();
	}

	public String getReserve3() {
		return reserve3;
	}

	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3 == null ? null : reserve3.trim();
	}

	public String getReserve4() {
		return reserve4;
	}

	public void setReserve4(String reserve4) {
		this.reserve4 = reserve4 == null ? null : reserve4.trim();
	}

	public String getReserve5() {
		return reserve5;
	}

	public void setReserve5(String reserve5) {
		this.reserve5 = reserve5 == null ? null : reserve5.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carPlate=" + carPlate + ", carMark=" + carMark + ", carColor=" + carColor
				+ ", carMileage=" + carMileage + ", carLimit=" + carLimit + ", carAge=" + carAge + ", carPhoto="
				+ carPhoto + ", carUserid=" + carUserid + "]";
	}

}