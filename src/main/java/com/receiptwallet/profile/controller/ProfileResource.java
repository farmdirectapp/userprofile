package com.receiptwallet.profile.controller;

import com.receiptwallet.profile.common.ErrorCode;
import com.receiptwallet.profile.entity.UserProfile;
import com.receiptwallet.profile.model.UserProfileModel;
import com.receiptwallet.profile.request.model.FieldValidationResult;
import com.receiptwallet.profile.request.model.InputValidationMessage;
import com.receiptwallet.profile.request.model.Response;
import com.receiptwallet.profile.service.UserProfileService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/V1/profile")
public class ProfileResource {

	Logger logger = LoggerFactory.getLogger(ProfileResource.class);

	private static Response  profileNotFound = new Response(ErrorCode.ERROR_PROFILE_NOT_FOUND, "Profile not found", false);

	@Autowired
	UserProfileService profileService;

	@GetMapping()
	@ApiOperation(value = "Find profile information by email-id")
	public List<UserProfile> getUserProfile(@RequestParam(value = "emailId", required = true) String emailId) {
		logger.info("getUserProfile for e-mail {}", emailId);
		if (StringUtils.isNotBlank(emailId)) {
			UserProfile userProfile = profileService.findUserProfileByEmailId(emailId);
			if (userProfile != null) {
				userProfile.setErrorCode(ErrorCode.SUCESS);
				userProfile.setErrorMessage("SUCESS");
				return Collections.singletonList(userProfile);
			} else {
				userProfile = new UserProfile();
				userProfile.setErrorCode(101);
				userProfile.setErrorMessage("No matching profile found for the given e-mail");
				return Collections.singletonList(userProfile);
			}
		}
		return null;
	}

	@GetMapping("/findByEmail")
	@ApiOperation(value = "Find UserProfile by e-mail id")
	public Response isUserProfileExist(@RequestParam(value = "emailId", required = true) String emailId) {
		logger.info("isUserProfileExist for e-mail {}", emailId);

		if (StringUtils.isNotBlank(emailId)) {
			if (profileService.isUserProfileExistByEmailId(emailId)) {
				return Response.SUCESS;
			} else {
				return new Response(ErrorCode.ERROR_PROFILE_NOT_FOUND, "Profile not found for the given e-mail", false);
			}
		}
		return Response.FAILURE;
	}

	@GetMapping("/findByProfileId")
	@ApiOperation(value = "Find UserProfile by profileId")
	public UserProfile getProfileById(@RequestParam(value = "profileId", required = true) String profileId) {
		logger.info("getProfileById for profileId {}", profileId);

		UserProfile userProfile = profileService.findByProfileId(profileId);
		if (userProfile != null) {
			return userProfile;
		} else {
			return new UserProfile(ErrorCode.FAILURE, "Profile not found for the profileId.", false);
		}
	}

	@GetMapping("/findByPhone")
	@ApiOperation(value = "Find UserProfile by Phone")
	public ResponseEntity getProfileByPhone(@RequestParam(value = "phone", required = true) String phone) {
		logger.info("getProfileByPhone for phone {}", phone);
		UserProfile userProfile = profileService.findByPhone(phone);
		return userProfile != null? new ResponseEntity<>(userProfile,HttpStatus.OK)
				: new ResponseEntity<>(profileNotFound,HttpStatus.NOT_FOUND);
	}


	@PostMapping(consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Create new Profile")
	public ResponseEntity createUserProfile(@Valid @RequestBody UserProfileModel profile) {
		logger.info("createProfile for the e-mail {}", profile.getEmailId());
		if (profileService.isUserProfileExistByEmailId(profile.getEmailId())) {
			InputValidationMessage validationMessage = new InputValidationMessage(400,
					"Profile already exist for this e-mail or phone number", false);
			List<FieldValidationResult> list = new ArrayList<FieldValidationResult>();
			list.add(new FieldValidationResult("emailId", "Profile already exist for this e-mail or phone number"));
			validationMessage.setValidationResult(list);
			return new ResponseEntity<>(validationMessage, HttpStatus.OK);
		}else {
			profileService.addUserProfile(profile);
			return new ResponseEntity<>(profile, HttpStatus.OK);
		}
	}

	@PutMapping(consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Update existing Profile")
	public Response updateUserProfile(@Valid @RequestBody UserProfile profile) {
		logger.info("updateProfile for the e-mail {}", profile.getEmailId());
		if (profile.getProfileId() == null) { // TODO check profile id
			return new Response(ErrorCode.ERROR_PROFILE_ID_NOT_FOUND, "Profile Id is missing to update profile", false);
		} else {
			profileService.updateProfile(profile);
		}
		return profile;
	}

	@PostMapping("/updatestatus")
	@ApiOperation(value = "Update User's profile status by changing OTP verification status 'Sucess' , 'Failed', "
			+ "set profile active or inactive or disabled 'A- Active,  I-Inactive, D- Disabled.'")
	public Response updateStatus(@RequestParam(value = "otpverification", required = false) String otpverification,
			@RequestParam(value = "profilestatus", required = false) String profilestatus,
			@RequestParam(value = "profileId", required = true) String profileId) {

		boolean status = false;

		if (StringUtils.isNoneBlank(otpverification)) {
			status = profileService.updateOTPStatus(otpverification, profileId);
		}

		if (StringUtils.isNoneBlank(profilestatus)) {
			status = profileService.updateProfileStatus(profilestatus, profileId);
		}

		if (status) {
			return Response.SUCESS;
		} else {
			return Response.FAILURE;
		}
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public InputValidationMessage handleValidationExceptions(MethodArgumentNotValidException ex) {
		List<FieldValidationResult> validationResultList = new ArrayList<FieldValidationResult>();
		InputValidationMessage validationMessage = null;
		List<FieldError> fieldError = ex.getBindingResult().getFieldErrors();

		Iterator iter = fieldError.iterator();
		if (iter != null) {
			validationMessage = new InputValidationMessage(400, "Input data validation error", false);
			while (iter.hasNext()) {
				FieldError objectError = (FieldError) iter.next();
				FieldValidationResult result = new FieldValidationResult(objectError.getField(),
						objectError.getDefaultMessage());
				validationResultList.add(result);
			}

			validationMessage.setValidationResult(validationResultList);
		}
		return validationMessage;
	}

}
