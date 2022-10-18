package com.receiptwallet.profile.repository;

import java.util.List;

import com.receiptwallet.profile.entity.UserLogin;
import com.receiptwallet.profile.entity.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserLoginRepository extends MongoRepository<UserLogin, String> {

	Logger logger = LoggerFactory.getLogger(UserLoginRepository.class);

	//@Transactional
	//@Modifying(clearAutomatically = true)
	//@Query("UPDATE UserLogin ul SET ul.logoutTs=:logoutTs WHERE ul.emailId= :emailId")
	//public int setLogoutTs(@Param("logoutTs") Timestamp logoutTs, @Param("emailId") String emailId);

	//@Query("SELECT pr FROM UserProfile pr  WHERE (pr.emailId= :emailId  OR  pr.phone= :phone)  AND pr.password =:password")
	//TODO ADD PASSWORD CHECK..
	//@Query(" { '$or': [{'emailId':?0} ,{'phone':?1}]   } ")
	public List<UserProfile> findByUserIdAndSessionId(@Param("userId") String userId, @Param("sessionId") String sessionId
			);
}
