package com.receiptwallet.profile.service;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

import com.receiptwallet.profile.common.Constants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Update.update;

import org.springframework.stereotype.Service;

import com.receiptwallet.profile.entity.UserProfile;
import com.receiptwallet.profile.repository.UserProfileRepository;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	Logger logger = LoggerFactory.getLogger(UserProfileServiceImpl.class);

	private UserProfileRepository userProfileRepo;
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	public UserProfileServiceImpl(UserProfileRepository profileRepository) {
		this.userProfileRepo = profileRepository;
	}

	@Override
	public boolean addUserProfile(UserProfile userProfile) {
		userProfile.setProfileStatus(Constants.STATUS_ACTIVE);
		Timestamp currentTime = Timestamp.valueOf(ZonedDateTime.now(Constants.ZONEID_IST).toLocalDateTime());
		userProfile.setCreatedTs(currentTime);
		userProfile.setUpdatedTs(currentTime);
		userProfile.setProfileId(null);
		this.userProfileRepo.save(userProfile);
		return true;
	}

	@Override
	public boolean updateProfile(UserProfile userProfile) {
		userProfile.setUpdatedTs(Timestamp.valueOf(ZonedDateTime.now(Constants.ZONEID_IST).toLocalDateTime()));
		this.userProfileRepo.save(userProfile);
		return true;
	}

	@Override
	public boolean deactivateUserProfile(UserProfile userProfile) {
		return false;
	}

	@Override
	public boolean isUserProfileExistByEmailId(String emailId) {
		UserProfile userProfile = userProfileRepo.findByEmailId(emailId);
		if (userProfile != null && StringUtils.isNotBlank(userProfile.getEmailId())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public UserProfile findUserProfileByEmailId(String emailId) {
		return userProfileRepo.findByEmailId(emailId);
	}

	@Override
	public UserProfile findByProfileId(String profileId) {
		return userProfileRepo.findByProfileId(profileId);
	}

	@Override
	public UserProfile findByPhone(String phone) {

		return userProfileRepo.findByPhone(phone);
	}

	@Override
	public boolean isUserProfileExistByEmailIdOrPhone(String emailId, String phone) {

		UserProfile userProfile = userProfileRepo.findByEmailIdOrPhone(emailId, phone);

		if (userProfile != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateOTPStatus(String otpverificationStatus, String profileId) {
		int updateCount = -1;
		// OTP status update
		String otpStatus = ("Sucess".equals(otpverificationStatus)) ? "S"
				: ("Failed".equals(otpverificationStatus)) ? "F" : null;

		if (StringUtils.isNotBlank(otpStatus)){
		
			mongoTemplate.upsert(new Query(where("profileId").is(profileId)), update("otpVerified",otpStatus), UserProfile.class);
			//updateCount = userProfileRepo.updateOtpStatus(otpStatus, profileId);
			//@Query("update UserProfile u set u.otpVerified = ?1  where u.profileId = ?2")
			//public int updateOtpStatus(String status, Long profileId);	
		}
		if (updateCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateProfileStatus(String profileStatus, String profileId) {
		// Profile status update
		//int updateCount = -1;
		String profStatus = ("Active".equals(profileStatus)) ? "A"
				: ("Inactive".equals(profileStatus)) ? "I" : ("Disabled".equals(profileStatus)) ? "D" : null;

		if (StringUtils.isNotBlank(profStatus)) {
			mongoTemplate.upsert(new Query(where("profileId").is(profileId)), update("profileStatus",profStatus), UserProfile.class);
			//updateCount = userProfileRepo.updateProfileStatus(profStatus, profileId);
		}

		//if (updateCount > 0)
		//	return true;
		//else
			return true;
	}

}
