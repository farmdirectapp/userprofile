package com.receiptwallet.profile.service;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

import com.receiptwallet.profile.common.Constants;
import com.receiptwallet.profile.entity.UserLogin;
import com.receiptwallet.profile.repository.UserLoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	Logger logger = LoggerFactory.getLogger(UserLoginServiceImpl.class);

	private UserLoginRepository userLoginRepository;

	@Autowired
	public UserLoginServiceImpl(UserLoginRepository userLoginRepository) {
		this.userLoginRepository = userLoginRepository;
	}

	@Override
	public boolean login(String loginlId, String password, String sessionId) {
		UserLogin userLogin = new UserLogin();
		userLogin.setUserId(loginlId);
		userLogin.setPassword(password);
		userLogin.setSessionId(sessionId);
		userLogin.setLoginTs(Timestamp.valueOf(ZonedDateTime.now(Constants.ZONEID_IST).toLocalDateTime()));
		userLogin.setStatus("login");
		this.userLoginRepository.save(userLogin);
		return true;
	}

	@Override
	public boolean logout(String emailId, String password, String sessionId) {
		//this.userLoginRepository
		//		.setLogoutTs(Timestamp.valueOf(ZonedDateTime.now(Constants.ZONEID_IST).toLocalDateTime()), emailId);
		return true;
	}
/*
	@Override
	public boolean isUserExist(String email, String phone, String password) {
		List<UserProfile> userProfile = this.userLoginRepository.findByEmailIdOrPhone(email, phone, password);

		System.out.println("userProfile ::"+userProfile);
		if (userProfile == null || userProfile.size() == 0)
			return false;
		else
			return true;
	}
*/
	/*
	@Override
	public UserProfile getUserProfile(String emailId, String phone, String password) {
		List<UserProfile> userProfile = this.userLoginRepository.findByEmailIdOrPhone(emailId, phone, password);
		System.out.println("emailId ::"+emailId);
		System.out.println("phone ::"+phone);
		System.out.println("password ::"+password);

		System.out.println("userProfile ::"+userProfile);
		
		if (userProfile != null && userProfile.size() > 0) {
			return userProfile.get(0);
		} else {
			return null;
		}
	}
	*/

}
