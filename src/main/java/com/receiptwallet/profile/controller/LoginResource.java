package com.receiptwallet.profile.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.receiptwallet.profile.entity.UserProfile;
import com.receiptwallet.profile.repository.UserProfileRepository;
import com.receiptwallet.profile.request.model.Response;
import com.receiptwallet.profile.service.UserLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.receiptwallet.profile.request.model.EmailPassword;
import com.receiptwallet.profile.security.JwtTokenProvider;

@RestController
@RequestMapping(value = "/V1/profile")
public class LoginResource {

	Logger logger = LoggerFactory.getLogger(LoginResource.class);

	@Autowired
	UserLoginService userLoginService;
	
	
	@Autowired
	UserProfileRepository userProfileService;

	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public Response login(@Valid @RequestBody EmailPassword emailPassword, HttpServletResponse response) {

		// validate userName and Password.
		//UserProfile userProfile = userLoginService.getUserProfile(emailPassword.getEmail(), emailPassword.getPhone(), emailPassword.getPassword());

		//UserProfile userProfile = userProfileService.findByEmailIdOrPhoneAndPassword(emailPassword.getEmail(),emailPassword.getPhone(), emailPassword.getPhone());
		UserProfile userProfile = null;
		
		userProfile = userProfileService.findByEmailIdAndPassword(emailPassword.getUserId(), emailPassword.getPassword());
		
		if(userProfile==null){
			userProfile = userProfileService.findByPhoneAndPassword(emailPassword.getUserId(), emailPassword.getPassword());	
		}
		
		if (userProfile != null) {
			if (userLoginService.login(emailPassword.getUserId(), emailPassword.getPassword(),
					"dummy sessionId")) {
				String token = JwtTokenProvider.createToken(emailPassword.getUserId(), emailPassword.getPassword(),
						userProfile.getPhone(), userProfile.getFirstName(), userProfile.getLastName(),
						String.valueOf(userProfile.getProfileId()));
				System.out.println("JSON Token::" + token);
				response.addHeader("Authorization", "Realm=" + token);
				return new Response(0, "Login Sucess", true);
			} else {
				return new Response(101, "Login failed", false);
			}
		} else {
			return new Response(102, "Invalid credential or User not found", false);
		}
	}

	@PostMapping("/logout")
	public Response logut(@Valid @RequestBody EmailPassword emailPassword) {
		if (userLoginService.logout(emailPassword.getUserId(), emailPassword.getPassword(), "dummy sessionId")) {
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
