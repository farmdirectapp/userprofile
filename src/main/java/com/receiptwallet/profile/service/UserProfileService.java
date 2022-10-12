package com.receiptwallet.profile.service;

import com.receiptwallet.profile.entity.UserProfile;

public interface UserProfileService {

	public boolean addUserProfile(UserProfile userProfile);

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
