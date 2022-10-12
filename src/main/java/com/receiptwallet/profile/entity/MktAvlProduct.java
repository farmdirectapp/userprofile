package com.receiptwallet.profile.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The persistent class for the MKT_AVL_PRODUCT database table.
 * 
 */
@Document(collection = "MKT_AVL_PRODUCT")
public class MktAvlProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	private int availProdId;

	@NotNull(message = "{mktAvlProduct.addressId.notNul}")
	@NotEmpty
	private int addressId;

	private Date createdTs;

	@NotNull(message = "{mktAvlProduct.endDt.notNull}")
	@NotEmpty
	private Date endDt;

	@NotNull(message = "{mktAvlProduct.pricePu.min}")
	@Min(1)
	private int pricePu;

	private int productId;

	@Size(min = 1, max = 100, message = "{mktAvlProduct.productName.size}")
	@NotEmpty
	private String productName;

	@NotNull
	@NotEmpty
	private int profileId;

	@Min(1)
	private int qty;

	@NotNull(message = "{mktAvlProduct.startDt.notNull}")
	@NotEmpty
	private Date startDt;

	private String status;

	@NotNull(message = "{mktAvlProduct.uom.notNull}")
	@NotEmpty
	private String uom;

	private Date updatedTs;

	private String geoLocation;

	public MktAvlProduct() {
	}

	public int getAvailProdId() {
		return this.availProdId;
	}

	public void setAvailProdId(int availProdId) {
		this.availProdId = availProdId;
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public Date getCreatedTs() {
		return this.createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	public Date getEndDt() {
		return this.endDt;
	}

	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}

	public int getPricePu() {
		return this.pricePu;
	}

	public void setPricePu(int pricePu) {
		this.pricePu = pricePu;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProfileId() {
		return this.profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Date getStartDt() {
		return this.startDt;
	}

	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public Date getUpdatedTs() {
		return this.updatedTs;
	}

	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}

	public String getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MktAvlProduct [availProdId=");
		builder.append(availProdId);
		builder.append(", addressId=");
		builder.append(addressId);
		builder.append(", createdTs=");
		builder.append(createdTs);
		builder.append(", endDt=");
		builder.append(endDt);
		builder.append(", pricePu=");
		builder.append(pricePu);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", profileId=");
		builder.append(profileId);
		builder.append(", qty=");
		builder.append(qty);
		builder.append(", startDt=");
		builder.append(startDt);
		builder.append(", status=");
		builder.append(status);
		builder.append(", uom=");
		builder.append(uom);
		builder.append(", updatedTs=");
		builder.append(updatedTs);
		builder.append("]");
		return builder.toString();
	}

}