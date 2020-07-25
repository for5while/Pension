package com.pension.vo;

public class AdministratorVO {
	private int idx;
	private String id;
	private String password;
	
	private String bank;
	private String holder;
	private String accountNumber;
	
	private String customerNo;
	private String customerName;
	private String customerPhone;
	
	private int reserveNo;
	private String roomName;
	private String checkInTime;
	private String checkInDate;
	private String checkOutDate;
	private int adult;
	private int child;
	private int infant;
	private String option;
	private String message;
	private int price;
	private String paymentDatetime;
	private int isPayment;
	
	private int roomNo;
	private int roomPrice;
	private int roomFriPrice;
	private int roomSatPrice;
	private int roomMidPrice;
	private int roomBusiestPrice;
	private int roomAdult;
	private int roomChild;
	private int roomInfant;
	private int roomNight;
	
	private int roomOptionNo;
	private String roomOptionName;
	private int roomOptionPrice;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
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
	public int getReserveNo() {
		return reserveNo;
	}
	public void setReserveNo(int reserveNo) {
		this.reserveNo = reserveNo;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(String checkInTime) {
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
	public int getAdult() {
		return adult;
	}
	public void setAdult(int adult) {
		this.adult = adult;
	}
	public int getChild() {
		return child;
	}
	public void setChild(int child) {
		this.child = child;
	}
	public int getInfant() {
		return infant;
	}
	public void setInfant(int infant) {
		this.infant = infant;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPaymentDatetime() {
		return paymentDatetime;
	}
	public void setPaymentDatetime(String paymentDatetime) {
		this.paymentDatetime = paymentDatetime.substring(0, 19);
	}
	public int getIsPayment() {
		return isPayment;
	}
	public void setIsPayment(int isPayment) {
		this.isPayment = isPayment;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public int getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
	public int getRoomFriPrice() {
		return roomFriPrice;
	}
	public void setRoomFriPrice(int roomFriPrice) {
		this.roomFriPrice = roomFriPrice;
	}
	public int getRoomSatPrice() {
		return roomSatPrice;
	}
	public void setRoomSatPrice(int roomSatPrice) {
		this.roomSatPrice = roomSatPrice;
	}
	public int getRoomMidPrice() {
		return roomMidPrice;
	}
	public void setRoomMidPrice(int roomMidPrice) {
		this.roomMidPrice = roomMidPrice;
	}
	public int getRoomBusiestPrice() {
		return roomBusiestPrice;
	}
	public void setRoomBusiestPrice(int roomBusiestPrice) {
		this.roomBusiestPrice = roomBusiestPrice;
	}
	public int getRoomAdult() {
		return roomAdult;
	}
	public void setRoomAdult(int roomAdult) {
		this.roomAdult = roomAdult;
	}
	public int getRoomChild() {
		return roomChild;
	}
	public void setRoomChild(int roomChild) {
		this.roomChild = roomChild;
	}
	public int getRoomInfant() {
		return roomInfant;
	}
	public void setRoomInfant(int roomInfant) {
		this.roomInfant = roomInfant;
	}
	public int getRoomNight() {
		return roomNight;
	}
	public void setRoomNight(int roomNight) {
		this.roomNight = roomNight;
	}
	public int getRoomOptionNo() {
		return roomOptionNo;
	}
	public void setRoomOptionNo(int roomOptionNo) {
		this.roomOptionNo = roomOptionNo;
	}
	public String getRoomOptionName() {
		return roomOptionName;
	}
	public void setRoomOptionName(String roomOptionName) {
		this.roomOptionName = roomOptionName;
	}
	public int getRoomOptionPrice() {
		return roomOptionPrice;
	}
	public void setRoomOptionPrice(int roomOptionPrice) {
		this.roomOptionPrice = roomOptionPrice;
	}
}
