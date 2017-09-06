package org.wjw.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.wjw.dao.BaseDao;

@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Resource
	 private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory){
    	this.sessionFactory=sessionFactory;
    }
    public SessionFactory getSessionFactory(){
    	return this.sessionFactory;
    }

    public Session getCurrentSession(){
    	return this.sessionFactory.getCurrentSession();
    }
	private Class<T> clz;

	public void add(T  o) {
		Transaction tx=(Transaction)this.getCurrentSession().beginTransaction();
	    try{
	    	getCurrentSession().save(o);
	    	tx.commit();
	    }catch(Exception e){
				tx.rollback();	
	    	e.printStackTrace();
	    }	
	}

	public void update(T o) {
		Transaction tx=(Transaction)this.getCurrentSession().beginTransaction();
	    try{
	    	getCurrentSession().update(o);
	    	tx.commit();
	    }catch(Exception e){
				tx.rollback();
	    	e.printStackTrace();
	    }	
	}

	public void delete(T o) {
		Transaction tx=(Transaction) this.getCurrentSession().beginTransaction();
	    try{
	    	getCurrentSession().delete(o);
	    	tx.commit();
	    }catch(Exception e){
				tx.rollback();
	    	e.printStackTrace();
	    }	
	}
	public T getById(Integer id) {
		Transaction tx=this.getCurrentSession().beginTransaction();
		@SuppressWarnings("unchecked")
		T t= (T)getCurrentSession().get(getClz(), id);
		tx.commit();
		return t;
	}
	@SuppressWarnings("unchecked")
	public Class<T> getClz() {
		if(clz==null) {
			//获取泛型的Class对象
			clz = ((Class<T>)
					(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}	
}
