package com.receiptwallet.profile.response.mapper;

import com.receiptwallet.profile.entity.UserProfile;
import com.receiptwallet.profile.request.model.LoginResponse;
import org.springframework.stereotype.Component;


@Component
public class LoginResponseMapper implements ObjectMapper<LoginResponse> {
    @Override
    public LoginResponse copyProperties(UserProfile userprofile) {
        LoginResponse loginResponse = new LoginResponse();
        if(userprofile != null) {
            loginResponse.setEmailId(userprofile.getEmailId());
            loginResponse.setFirstName(userprofile.getFirstName());
            loginResponse.setLastName(userprofile.getLastName());
        }
        return loginResponse;
    }
}
