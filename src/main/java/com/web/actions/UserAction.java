package com.web.actions;

import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.domain.User;
import com.web.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private UserService userService;
	private User user = new User();

	public void login() throws Exception {
		JSONObject json = new JSONObject();
		json = userService.getByCodePassword(user);
		System.out.println(json);
		ServletActionContext.getResponse().getWriter().println(json);
	}

	@Override
	public User getModel() {
		return user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
