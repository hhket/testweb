package com.web.dao;

import com.web.domain.User;

public interface UserDao {

	User getByCodePassword(String user_name);

}
