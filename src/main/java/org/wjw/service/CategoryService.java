package org.wjw.service;

import java.util.List;

import org.wjw.po.Category;

public interface CategoryService {
	//增加Category
	public void addCategory(Category category);
	//更新Category
	public void updateCategory(Category category);
	//删除Category
	public void deleteCategory(Category category);
	//找到所有的Category
	public List<Category> findAllCategory();
	//根据cId查找Category
	public Category getCategoryById(Integer cid);
}
