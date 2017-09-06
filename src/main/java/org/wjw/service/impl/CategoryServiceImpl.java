package org.wjw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wjw.dao.CategoryDao;
import org.wjw.po.Category;
import org.wjw.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
	@Resource
    private CategoryDao categoryDao;

	public void addCategory(Category category) {
		this.categoryDao.add(category);
	}

	public void updateCategory(Category category) {
	this.categoryDao.update(category);
	}

	public void deleteCategory(Category category) {
		this.categoryDao.delete(category);
	}

	public List<Category> findAllCategory() {
		List<Category> lists=this.categoryDao.findAll();
		return lists;
	}

	public Category getCategoryById(Integer cid) {
		Category category=this.categoryDao.getById(cid);
		return category;
	}

}
