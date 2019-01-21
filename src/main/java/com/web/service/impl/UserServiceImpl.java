package com.web.service.impl;

import org.json.JSONException;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.web.dao.UserDao;
import com.web.domain.User;
import com.web.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao ud;

	@Override
	public JSONObject getByCodePassword(User user) {
		JSONObject json = new JSONObject();
		User exitU = ud.getByCodePassword(user.getUser_name());
		try {
			if (exitU == null) {
				json.put("code", 0);
				json.put("msg", "用户不存在");
				return json;
			}
			if(!exitU.getUser_pwd().equals(user.getUser_pwd())) {
				json.put("code", 2);
				json.put("msg", "密码错误");
				return json;
			}
			json.put("code", 1);
			json.put("msg", "登录成功");
			json.put("user_name",exitU.getUser_name());
			json.put("user_id", exitU.getUser_id());
			ActionContext.getContext().getSession().put("user", exitU);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

}
