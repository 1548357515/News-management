package org.wjw.dao;

import org.wjw.po.User;


public interface UserDao extends BaseDao<User>{
	//登录方法
	public boolean isLogin(String username,String password);

}
