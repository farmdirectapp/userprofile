package com.receiptwallet.profile.controller;

import com.receiptwallet.profile.entity.UserProfile;
import com.receiptwallet.profile.repository.UserProfileRepository;
import com.receiptwallet.profile.request.model.EmailPassword;
import com.receiptwallet.profile.request.model.LoginResponse;
import com.receiptwallet.profile.request.model.Response;
import com.receiptwallet.profile.response.mapper.LoginResponseMapper;
import com.receiptwallet.profile.security.JwtTokenProvider;
import com.receiptwallet.profile.service.UserLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/V1/profile")
public class LoginResource {

	Logger logger = LoggerFactory.getLogger(LoginResource.class);

	@Autowired
	UserLoginService userLoginService;

	@Autowired
	UserProfileRepository userProfileService;

	@Autowired
	LoginResponseMapper loginResponseMapper;

	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> login(@Valid @RequestBody EmailPassword emailPassword, HttpServletResponse response) {

		UserProfile isExistingUserProfile = userProfileService.findByEmailIdAndPassword(emailPassword.getEmailId(), emailPassword.getPassword());
		if(isExistingUserProfile == null){
			return new ResponseEntity<>(new LoginResponse(402, "Invalid credential or User not found", false),HttpStatus.OK);
		}else{
			return new ResponseEntity<>(login(isExistingUserProfile),HttpStatus.OK);
		}
	}

	private LoginResponse login(UserProfile userProfile){
		LoginResponse loginResponse = null;
		if (userProfile != null) {
			userLoginService.login(userProfile.getEmailId(), userProfile.getPassword(), "dummy sessionId");
			String token = createSecurityToken(userProfile);
			loginResponse = loginResponseMapper.copyProperties(userProfile);
			loginResponse.setSecutityToken(token);
			loginResponse.setErrorCode(0);
			loginResponse.setErrorMessage("Successfully Logged in to the Application.");
		}
		return loginResponse;
	}

	private String createSecurityToken(UserProfile userProfile) {
		String token = null;
		if(userProfile != null && userProfile.getEmailId() !=null){
			token = JwtTokenProvider.createToken(userProfile.getEmailId(), userProfile.getPassword(),
					userProfile.getPhone(), userProfile.getFirstName(), userProfile.getLastName(),
					String.valueOf(userProfile.getProfileId()));
		}
		return token;
	}

	@PostMapping("/logout")
	public Response logut(@Valid @RequestBody EmailPassword emailPassword) {
		if (userLoginService.logout(emailPassword.getEmailId(), emailPassword.getPassword(), "dummy sessionId")) {
			return new Response(0, "Logout Sucess", true);
		} else {
			return new Response(101, "Logout failed", false);
		}
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		return ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
				.collect(Collectors.toList());
	}
	
}
