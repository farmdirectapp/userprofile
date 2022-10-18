package com.receiptwallet.profile.response.mapper;

import com.receiptwallet.profile.entity.UserProfile;

public interface ObjectMapper <T>{
   T copyProperties(UserProfile userprofile) ;
}
