package com.pension.vo;

import java.util.Date;
import java.util.List;

public class ReserveVO {
	private int year;
	private int month;
	private int day;
	private String yearToString;
	private String monthToString;
	private String dayToString;
	private int lastDay;
	private String date;
	private int idx;
	private int optionIndex;
	private String optionName;
	private int optionPrice;
	private int night;
	private int peopleAdult;
	private int peopleChild;
	private int peopleInfant;
	
	private int customerNum;
	private String customerName;
	private String customerPhone;
	
	private int reserveNum;
	private int roomNum;
	private String roomName;
	private int checkInTime;
	private int checkInYear;
	private int checkInMonth;
	private int checkInDay;
	private String checkInDate;
	private String checkOutDate;
	private int totalPrice;
	private List<String> option;
	private String optionToString;
	private String message;
	private Date paymentDatetime;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getOptionIndex() {
		return optionIndex;
	}
	public void setOptionIndex(int optionIndex) {
		this.optionIndex = optionIndex;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public int getOptionPrice() {
		return optionPrice;
	}
	public void setOptionPrice(int optionPrice) {
		this.optionPrice = optionPrice;
	}
	public int getNight() {
		return night;
	}
	public void setNight(int night) {
		this.night = night;
	}
	public int getPeopleAdult() {
		return peopleAdult;
	}
	public void setPeopleAdult(int peopleAdult) {
		this.peopleAdult = peopleAdult;
	}
	public int getPeopleChild() {
		return peopleChild;
	}
	public void setPeopleChild(int peopleChild) {
		this.peopleChild = peopleChild;
	}
	public int getPeopleInfant() {
		return peopleInfant;
	}
	public void setPeopleInfant(int peopleInfant) {
		this.peopleInfant = peopleInfant;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(int checkInTime) {
		this.checkInTime = checkInTime;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public List<String> getOption() {
		return option;
	}
	public void setOption(List<String> option) {
		this.option = option;
	}
	public String getOptionToString() {
		return optionToString;
	}
	public void setOptionToString(String optionToString) {
		this.optionToString = optionToString;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getPaymentDatetime() {
		return paymentDatetime;
	}
	public void setPaymentDatetime(Date paymentDatetime) {
		this.paymentDatetime = paymentDatetime;
	}
	public int getReserveNum() {
		return reserveNum;
	}
	public void setReserveNum(int reserveNum) {
		this.reserveNum = reserveNum;
	}
	public int getCustomerNum() {
		return customerNum;
	}
	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public int getCheckInMonth() {
		return checkInMonth;
	}
	public void setCheckInMonth(int checkInMonth) {
		this.checkInMonth = checkInMonth;
	}
	public int getCheckInDay() {
		return checkInDay;
	}
	public void setCheckInDay(int checkInDay) {
		this.checkInDay = checkInDay;
	}
	public int getCheckInYear() {
		return checkInYear;
	}
	public void setCheckInYear(int checkInYear) {
		this.checkInYear = checkInYear;
	}
	public int getLastDay() {
		return lastDay;
	}
	public void setLastDay(int lastDay) {
		this.lastDay = lastDay;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getYearToString() {
		return yearToString;
	}
	public void setYearToString(String yearToString) {
		this.yearToString = yearToString;
	}
	public String getMonthToString() {
		return monthToString;
	}
	public void setMonthToString(String monthToString) {
		this.monthToString = monthToString;
	}
	public String getDayToString() {
		return dayToString;
	}
	public void setDayToString(String dayToString) {
		this.dayToString = dayToString;
	}
}
