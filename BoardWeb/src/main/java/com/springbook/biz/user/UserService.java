package com.springbook.biz.user;

import com.springbook.biz.user.impl.UserDAO;

public interface UserService {
	public void setUserDAO(UserDAO userDAO); 
	public UserVO getUser(UserVO vo);
}
