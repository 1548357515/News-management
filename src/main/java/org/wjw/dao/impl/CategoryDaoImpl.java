package org.wjw.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.wjw.dao.CategoryDao;
import org.wjw.po.Category;
@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {
	  
	//找到所有的Category
	public List<Category> findAll(){
		Transaction tx=this.getCurrentSession().beginTransaction();
		  Query query=this.getCurrentSession().createQuery("from Category");
		  @SuppressWarnings("unchecked")
		List<Category> lists=query.list();
		  tx.commit();
		return lists;
	}
}
