package org.wjw.service;

import org.wjw.po.User;

public interface UserService {

	//判断用户登录情况
	public boolean isLogin(String username, String password) ;
	//注册用户
	public void    userRegister(User user);
}
