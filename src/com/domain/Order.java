package com.domain;


import java.util.Date;

import com.domain.Customer;
import com.domain.Manager;
import com.domain.Product;

public class Order implements java.io.Serializable{
	private Integer objId;
	private Customer theCustomer;
	private Date orderTime;
	private Product theProduct;
	private Float amt;
	//private Payment thePayment;
	private Consignee theConsignee;
	private Manager theClerk;
	private Manager theDeliverer;
	private Integer orderState;
	
	public Integer getObjId() {
		return objId;
	}
	public void setObjId(Integer objId) {
		this.objId = objId;
	}
	public Customer getTheCustomer() {
		return theCustomer;
	}
	public void setTheCustomer(Customer theCustomer) {
		this.theCustomer = theCustomer;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Product getTheProduct() {
		return theProduct;
	}
	public void setTheProduct(Product theProduct) {
		this.theProduct = theProduct;
	}
	public Float getAmt() {
		return amt;
	}
	public void setAmt(Float amt) {
		this.amt = amt;
	}
//	public Payment getThePayment() {
//		return thePayment;
//	}
//	public void setThePayment(Payment thePayment) {
//		this.thePayment = thePayment;
//	}
	public Consignee getTheConsignee() {
		return theConsignee;
	}
	public void setTheConsignee(Consignee theConsignee) {
		this.theConsignee = theConsignee;
	}
	public Manager getTheClerk() {
		return theClerk;
	}
	public void setTheClerk(Manager theClerk) {
		this.theClerk = theClerk;
	}
	public Manager getTheDeliverer() {
		return theDeliverer;
	}
	public void setTheDeliverer(Manager theDeliverer) {
		this.theDeliverer = theDeliverer;
	}
	public Integer getOrderState() {
		return orderState;
	}
	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}
	
}
