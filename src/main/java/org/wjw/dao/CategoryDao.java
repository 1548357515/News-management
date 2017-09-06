package org.wjw.dao;

import java.util.List;

import org.wjw.po.Category;

public interface CategoryDao extends BaseDao<Category>{
	//找到所有的Category
		public List<Category> findAll();
}
