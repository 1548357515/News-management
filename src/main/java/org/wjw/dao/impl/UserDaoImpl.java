package org.wjw.dao.impl;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.wjw.dao.UserDao;
import org.wjw.po.User;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	
	//判断用户登录情况
	@Override
	public boolean isLogin(String username, String password) {
		Transaction tx=this.getCurrentSession().beginTransaction();
		Query query=this.getCurrentSession().createQuery("from User where username=:username and password=:password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		int size=query.list().size();
		  tx.commit();
		if(size>=1){
			return true;
		}
		return false;
	}


}
