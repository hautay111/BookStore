package model;

import java.util.Date;

public class OrderBookstore {
	private int Id;
	private String OrderNumber;
	private Date DayCreate;
	private double TotalMoney;
	private int EmpID;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getOrderNumber() {
		return OrderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}
	public Date getDayCreate() {
		return DayCreate;
	}
	public void setDayCreate(Date dayCreate) {
		DayCreate = dayCreate;
	}
	public double getTotalMoney() {
		return TotalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		TotalMoney = totalMoney;
	}
	public int getEmpID() {
		return EmpID;
	}
	public void setEmpID(int empID) {
		EmpID = empID;
	}
	public OrderBookstore(int id, String orderNumber, Date dayCreate, double totalMoney, int empID) {
		super();
		Id = id;
		OrderNumber = orderNumber;
		DayCreate = dayCreate;
		TotalMoney = totalMoney;
		EmpID = empID;
	}
	public OrderBookstore() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
