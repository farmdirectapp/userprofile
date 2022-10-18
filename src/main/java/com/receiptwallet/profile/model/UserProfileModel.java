package com.receiptwallet.profile.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the USER_PROFILE database table.
 * 
 */
@ApiModel(description = "User profile information")
public class UserProfileModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "System generated unique Id for each user profile")
	private String profileId;

	@NotNull(message = "{userProfile.emailId.notNull}")
	@NotEmpty(message = "{userProfile.emailId.notEmpty}")
	@ApiModelProperty(notes = "User's e-mail id ")
	@Email
	private String emailId;

	@NotNull(message = "{userProfile.firstName.notNull}")
	@NotEmpty(message = "{userProfile.firstName.notEmpty}")
	@ApiModelProperty(notes = "User's First Name can be used for full name or first name ")
	@Size(min = 2, max = 25, message = "{userProfile.firstName.size}")
	private String firstName;

	/*
	 * @NotNull(message="{userProfile.lastName.notNull}")
	 * 
	 * @NotEmpty(message="{userProfile.lastName.notEmpty}")
	 * 
	 * @Size(min=2, message="{userProfile.lastName.size}")
	 */
	@ApiModelProperty(notes = "User's Last Name - this is optional field")
	private String lastName;

	@ApiModelProperty(notes = "User's Middle Name - this is optional field")
	private String middleName;

	@NotNull(message = "{userProfile.password.notNull}")
	@NotEmpty(message = "{userProfile.password.notEmpty}")
	@ApiModelProperty(notes = "User's login password")
	@Size(min = 8, max = 12, message = "{userProfile.password.size}")
	private String password;

	@NotNull(message = "{userProfile.phone.notNull}")
	@NotEmpty(message = "{userProfile.phone.notEmpty}")
	@ApiModelProperty(notes = "User's Phone number")
	private String phone;

	@ApiModelProperty(notes = "User's device Id ")
	private String deviceId;

	@NotNull(message = "{userProfile.dob.notNull}")
	// @NotEmpty(message="{userProfile.dob.notEmpty}")
	@ApiModelProperty(notes = "User's Date of birth")
	private Date dob;

	public UserProfileModel() {
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProfileId() {
		return this.profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}