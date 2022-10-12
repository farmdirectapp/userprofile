package com.receiptwallet.profile.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The persistent class for the USER_LOGIN database table.
 * 
 */
@Document(collection = "UserLogin")
public class UserLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String loginId;
	// It can be either e-mail id or Phone number of user during login.
	private String userId;

	private String sessionId;


	private Date loginTs;

	private int loginTsId;

	private Date logoutTs;

	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	private int logoutTsId;

	@NotNull
	@NotEmpty
	private String password;

	private String status;

	private String deviceId;

	public UserLogin() {
	}


	public Date getLoginTs() {
		return this.loginTs;
	}

	public void setLoginTs(Date loginTs) {
		this.loginTs = loginTs;
	}

	public int getLoginTsId() {
		return this.loginTsId;
	}

	public void setLoginTsId(int loginTsId) {
		this.loginTsId = loginTsId;
	}

	public Date getLogoutTs() {
		return this.logoutTs;
	}

	public void setLogoutTs(Date logoutTs) {
		this.logoutTs = logoutTs;
	}

	public int getLogoutTsId() {
		return this.logoutTsId;
	}

	public void setLogoutTsId(int logoutTsId) {
		this.logoutTsId = logoutTsId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}

}