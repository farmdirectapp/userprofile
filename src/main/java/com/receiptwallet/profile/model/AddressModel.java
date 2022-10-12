package com.receiptwallet.profile.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModelProperty;

public class AddressModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "{address.profileId.notNull}")
	@ApiModelProperty(notes = "User profile id which is generated and sent back to UI appication as first step in profile creation process. "
			+ "This value has to sent as prt of address information for creting address. ")
	private String profileId;

	@ApiModelProperty(notes = "Auto generated by the system. This is unique id to map each address.")
	private String addressId;
	/*
	 * @NotNull(message="{address.address1.notNull}")
	 * 
	 * @NotEmpty(message="{address.address1.notEmpty}")
	 * 
	 * @ApiModelProperty(notes="Address Line 1") private String address1;
	 */
	@NotNull(message = "{address.ciy.notNull}")
	@NotEmpty(message = "{address.ciy.notEmpty}")
	@ApiModelProperty(notes = "City name")
	private String city;

	@NotNull(message = "{address.country.notNull}")
	@NotEmpty(message = "{address.country.notEmpty}")
	@ApiModelProperty(notes = "Country name")
	private String country;

	@NotNull(message = "{address.longitude.notNull}")
	@NotEmpty(message = "{address.longitude.notEmpty}")
	@Range(min = -180, max = 180, message = "{address.longitude.invalid}")
	private String longitude;

	@NotNull(message = "{address.latitude.notNull}")
	@NotEmpty(message = "{address.latitude.notEmpty}")
	@Range(min = -90, max = 90, message = "{address.latitude.invalid}")
	private String latitude;

	@NotNull(message = "{address.pin.notNull}")
	@NotEmpty(message = "{address.pin.notEmpty}")
	@ApiModelProperty(notes = "PIN number")
	private String pin;

	@NotNull(message = "{address.state.notNull}")
	@NotEmpty(message = "{address.state.notEmpty}")
	@ApiModelProperty(notes = "State name")
	private String state;

	@NotNull(message = "{address.street.notNull}")
	@NotEmpty(message = "{address.street.notEmpty}")
	@ApiModelProperty(notes = "Street name")
	private String street;

	public AddressModel() {
	}

	public String getProfileId() {
		return this.profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getAddressId() {
		return this.addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPin() {
		return this.pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
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

}
