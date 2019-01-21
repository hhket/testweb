package com.web.service;

import org.json.JSONObject;

import com.web.domain.User;


public interface UserService {

	JSONObject getByCodePassword(User user);

}
