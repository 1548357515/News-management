package org.wjw.action;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.wjw.po.Category;
import org.wjw.po.News;
import org.wjw.service.CategoryService;
import org.wjw.service.NewsService;
import org.wjw.util.DateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class UserAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6990411132566572193L;
	 private Category category;
	    private List<Category> categorys;
	    private int nid;
	    private News news;
	    private List<News> newses;
	    private int cid;
	    private int pageCount=0;
	    private int currentPage=1;
	    private int pages[];
		@Resource
	    private CategoryService categoryService;
   @Resource
	private NewsService newsService;
   
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
public int getNid() {
	return nid;
}
public void setNid(int nid) {
	this.nid = nid;
}
public News getNews() {
	return news;
}
public void setNews(News news) {
	this.news = news;
}
public List<News> getNewses() {
	return newses;
}
public void setNewses(List<News> newses) {
	this.newses = newses;
}
public int getCurrentPage() {
	return currentPage;
}
public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}
public int[] getPages() {
	return pages;
}
public void setPages(int[] pages) {
	this.pages = pages;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getPageCount() {
	return pageCount;
}
public void setPageCount(int pageCount) {
	this.pageCount = pageCount;
}
//管理员主页的新闻种类
public String listCategoryAdmin(){
	categorys=categoryService.findAllCategory();
	return "categoryList";
}
//转到类型发布页面
public String categoryAdd(){
	return "categoryAdd";
}
//使新闻列表的更新内容的Category不出现null
public void setCategoryList() {
	ActionContext context=ActionContext.getContext();
		categorys=categoryService.findAllCategory();
		context.getSession().put("categorys", categorys);
}
//把新闻列表返回到管理员页面
public String listNews(){
	if(currentPage<=0){
		currentPage=1;
	}
	int size=newsService.findAllNews().size();
	int first=0;
	int max=20;
	String sort="ASC";
	  ActionContext ctx=ActionContext.getContext();
      Map<String,Object> session=ctx.getSession();
	//每页最大20条数据
	if(size<20){
	pageCount=1;	
	}else if(size>20&&size%20>0){
		pageCount=size/20+1;
	}else {
	pageCount=size/20;
	}	
	  if(currentPage==1)
	   {
		first=0;
	   }else if(currentPage>1){   
			   first=(currentPage-1)*max-1;
	   }
	newses=newsService.listNewNews(first,max, sort);
		if(currentPage>=pageCount){
		currentPage=pageCount-1;
		}
	 session.put("currentPage", currentPage);
	pages=new int[pageCount];
	return "listNews";
}
//把页面转到新闻发布页面
public String newsAdd(){
	newses=newsService.findAllNews();
	categorys=categoryService.findAllCategory();
	ActionContext context=ActionContext.getContext();
	context.getSession().put("categorys", categorys);
	return "newsAdd";
}
//管理员添加新闻种类
public String addCategory(){
	categoryService.addCategory(category);
 return "displayCategory";
}
public String updateCategory(){
	category=categoryService.getCategoryById(cid);
	return "updateCategory";
}
//管理员更新新闻种类
public String updatedCategory(){
	categoryService.updateCategory(category);
	return "displayCategory";
}
//管理员删除新闻种类
public String deleteCategory(){
	category=categoryService.getCategoryById(cid);
	categoryService.deleteCategory(category);
	return "displayCategory";
}
//新闻详情页面
public String findNewsDetails(){
	news=newsService.getNewsById(nid);
	return "details";
}
//跳转到更新新闻页面
public String updateNews(){
	news=newsService.getNewsById(nid);
	return "updateNews";
}
//管理员更新新闻信息
public String updatedNews() throws ParseException{
	news.setIssueTime(DateUtil.getCurrentDate());
	newsService.updateNews(news);
	
	return "displayNews";
}
//管理员删除新闻信息
public String deleteNews(){
	news=newsService.getNewsById(nid);
	newsService.deleteNews(news);
	return "displayNews";
}
//管理员添加新闻信息
public String addNews() throws ParseException{
	news.setIssueTime(DateUtil.getCurrentDate());
	newsService.addNews(news);
 return "displayNews";
}
//根据category的id来查找同类型新闻
	public String findSameNewsByCategory(){
		  ActionContext ctx=ActionContext.getContext();
	      Map<String,Object> session=ctx.getSession();
	      session.put("pageCount", pageCount+1);
	//清空之前的缓存数据
	//	System.out.println("查询前的newses"+newses.size());
		int first=0;
		int max=20;
	//每页最大20条数据
   if(pageCount>0)
   {
	   first=pageCount*max-1;
   }
	int size=newsService.findSameNewsByCategoryAll(news.getCategory().getId()).size();
	newses=newsService.findSameNewsByCategory(news.getCategory().getId(),first,max);
	//每页最大20条数据
		if(size<20){
		pageCount=1;	
		}else if(size>20&&size%20>0){
			pageCount=size/20+1;
		}else {
		pageCount=size/20;
		}
	pages=new int[pageCount];
		return "select";
	}
}
