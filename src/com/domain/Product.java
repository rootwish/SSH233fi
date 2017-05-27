package com.domain;

import java.util.HashSet;
import java.util.Set;

public class Product implements java.io.Serializable{
	private Integer objId;
	private String productId;
	private String productName;
	private String feature;
	private String description;
	private String meaning;
	private Double price;
	private String smallImg;
	private String bigImg;
	private Integer productState;
	private Set priceList;
	private Set productType;
	private Integer productAmount;
	public Integer getObjId() {
		return objId;
	}
	public void setObjId(Integer objId) {
		this.objId = objId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getSmallImg() {
		return smallImg;
	}
	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}
	public String getBigImg() {
		return bigImg;
	}
	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}
	public Integer getProductState() {
		return productState;
	}
	public void setProductState(Integer productState) {
		this.productState = productState;
	}
	public Set getPriceList() {
		if(this.priceList == null)
			this.priceList = new HashSet();
		return this.priceList;
	}
	public void setPriceList(Set priceList) {
		this.priceList = priceList;
	}
	public Integer getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(Integer productAmount) {
		this.productAmount = productAmount;
	}
	public Set getProductType() {
		if(this.productType == null)
			this.productType = new HashSet();
		return this.productType;
	}
	public void setProductType(Set productType) {
		this.productType = productType;
	}
	
}
