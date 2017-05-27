package com.domain;

import java.util.HashSet;
import java.util.Set;

public class ProductType implements java.io.Serializable{
	private Integer objId;
	private String classifyType;
	private String typeName;
	private Set product;
	public ProductType(){
		
	}

	public Integer getObjId() {
		return objId;
	}

	public void setObjId(Integer objId) {
		this.objId = objId;
	}

	public String getClassifyType() {
		return classifyType;
	}

	public void setClassifyType(String classifyType) {
		this.classifyType = classifyType;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set getProduct() {
		if(this.product == null)
			this.product = new HashSet();
		return this.product;
	}

	public void setProduct(Set product) {
		this.product = product;
	}
}

