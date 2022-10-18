package com.receiptwallet.profile.request.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EmailPassword {

	@NotNull(message = "{userProfileInfoVO.password.notNull}")
	@NotEmpty(message = "{userProfileInfoVO.password.notEmpty}")
	private String emailId;

	@NotNull(message = "{userProfileInfoVO.password.notNull}")
	@NotEmpty(message = "{userProfileInfoVO.password.notEmpty}")
	private String password;


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
