package com.receiptwallet.profile.service;

import com.receiptwallet.profile.entity.UserProfile;
import com.receiptwallet.profile.model.UserProfileModel;

public interface UserProfileService {

	public void addUserProfile(UserProfileModel userProfile);

	public boolean updateProfile(UserProfile userProfile);

	public boolean deactivateUserProfile(UserProfile userProfile);

	public boolean isUserProfileExistByEmailId(String emailId);

	public boolean isUserProfileExistByEmailIdOrPhone(String emailId, String phone);

	public UserProfile findUserProfileByEmailId(String emailId);

	public UserProfile findByProfileId(String profileId);

	public UserProfile findByPhone(String phone);

	public boolean updateOTPStatus(String otpverificationStatus, String profileId);

	public boolean updateProfileStatus(String profileStatus, String profileId);

}
