package org.wjw.action;

import java.util.List;

import javax.annotation.Resource;

import org.wjw.po.Category;
import org.wjw.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class CategoryAction extends ActionSupport {
/**
	 * 
	 */
	private static final long serialVersionUID = 3170594898968504949L;
    private int cid;
    private Category category;
    private List<Category> categorys;
	@Resource
    private CategoryService categoryService;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public List<Category> getCategorys() {
	return categorys;
}
public void setCategorys(List<Category> categorys) {
	this.categorys = categorys;
}


public String addCategory(){
	categoryService.addCategory(category);
 return SUCCESS;
}
public String updateCategory(){
	category=categoryService.getCategoryById(cid);
	return "update";
}
public String updatedCategory(){
	categoryService.updateCategory(category);
	return "displayCategory";
}
public String deleteCategory(){
	category=categoryService.getCategoryById(cid);
	categoryService.deleteCategory(category);
	return "displayCategory";
}
public String listCategory(){
	categorys=categoryService.findAllCategory();
	
	return "list";
}
//获取新闻类型列表，在发布时使用
public String listCategorys(){
	ActionContext context=ActionContext.getContext();
		categorys=categoryService.findAllCategory();
	context.getSession().put("categorys", categorys);
	return "input";
}
//使新闻列表的更新内容的Category不出现null
public void setCategoryList() {
	ActionContext context=ActionContext.getContext();
		categorys=categoryService.findAllCategory();
		context.getSession().put("categorys", categorys);
}
}
