package org.wjw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wjw.dao.UserDao;
import org.wjw.po.User;
import org.wjw.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
  @Resource
  private UserDao userDao;
	@Override
	public boolean isLogin(String username, String password) {
	    boolean result=userDao.isLogin(username, password);
		return result;
	}
	@Override
	public void userRegister(User user) {
		userDao.add(user);
	}

}
