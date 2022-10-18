package com.receiptwallet.profile.service;

public interface UserLoginService {
	//public boolean isUserExist(String email, String phone, String password);

	public void login(String loginlId, String password, String sessionId);

	public boolean logout(String loginlId, String password, String sessionId);

	//public UserProfile getUserProfile(String emailId, String phone, String password);
}
