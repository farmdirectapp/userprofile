package com.receiptwallet.profile.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The persistent class for the PRODUCT database table.
 * 
 */
@Document(collection = "Product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	private int productId;

	private String createdId;

	private Date createdTs;

	private String productName;

	private int productType;

	private String unitOfMm;

	private String updatedId;

	private Date updatedTs;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getCreatedId() {
		return this.createdId;
	}

	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}

	public Date getCreatedTs() {
		return this.createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductType() {
		return this.productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public String getUnitOfMm() {
		return this.unitOfMm;
	}

	public void setUnitOfMm(String unitOfMm) {
		this.unitOfMm = unitOfMm;
	}

	public String getUpdatedId() {
		return this.updatedId;
	}

	public void setUpdatedId(String updatedId) {
		this.updatedId = updatedId;
	}

	public Date getUpdatedTs() {
		return this.updatedTs;
	}

	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}

}