package com.receiptwallet.profile.repository;

import com.receiptwallet.profile.entity.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile, Long> {

	Logger logger = LoggerFactory.getLogger(UserProfileRepository.class);

	public UserProfile findByProfileId(String profileId);

	public UserProfile findByEmailId(String email);

	public UserProfile findByPhone(String phone);

	//@Query(" { '$or': [{'email':?0} ,{'phone':?1}]  } ")
	public UserProfile findByEmailIdOrPhone(String email, String phone);

	//@Transactional
	//@Modifying
	//@Query("update UserProfile u set u.otpVerified = ?1  where u.profileId = ?2")
	//public int updateOtpStatus(String status, Long profileId);

	//@Transactional
	//@Modifying
	//@Query("update UserProfile u set u.profileStatus = ?1  where u.profileId = ?2")
	//public int updateProfileStatus(String status, Long profileId);
	
	public UserProfile findByEmailIdOrPhoneAndPassword(String email, String phone,String password);

	public UserProfile findByEmailIdAndPassword(String email,String password);

	public UserProfile findByPhoneAndPassword(String phone, String password);


}
