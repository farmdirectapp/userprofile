package com.receiptwallet.profile.request.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EmailPassword {

	@NotNull(message = "{userProfileInfoVO.password.notNull}")
	@NotEmpty(message = "{userProfileInfoVO.password.notEmpty}")
	private String userId;

	@NotNull(message = "{userProfileInfoVO.password.notNull}")
	@NotEmpty(message = "{userProfileInfoVO.password.notEmpty}")
	private String password;


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
