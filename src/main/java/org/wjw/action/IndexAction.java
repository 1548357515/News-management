package org.wjw.action;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import org.wjw.po.Category;
import org.wjw.po.News;
import org.wjw.service.CategoryService;
import org.wjw.service.NewsService;

import com.opensymphony.xwork2.ActionSupport;
//重定向页面到主页
public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 288986720329661634L;
	  private Category category;
	  private News news;
	    private List<Category> categorys;
	    private List<News> newses;
	    private Integer cid;
	    private Integer nid;
	    private String title;
	    private String startTime;
	    private String endTime;
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
public News getNews() {
	return news;
}
public void setNews(News news) {
	this.news = news;
}

public Integer getCid() {
	return cid;
}
public void setCid(Integer cid) {
	this.cid = cid;
}
public List<News> getNewses() {
	return newses;
}
public void setNewses(List<News> newses) {
	this.newses = newses;
}
public Integer getNid() {
	return nid;
}
public void setNid(Integer nid) {
	this.nid = nid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getStartTime() {
	return startTime;
}
public void setStartTime( String startTime) {
	this.startTime = startTime;
}
public  String  getEndTime() {
	return endTime;
}
public void setEndTime(String   endTime) {
	this.endTime = endTime;
}
public NewsService getNewsService() {
	return newsService;
}
public void setNewsService(NewsService newsService) {
	this.newsService = newsService;
}
//获取主页面的新闻种类
public String listCategorys(){
	categorys=categoryService.findAllCategory();
	return SUCCESS;
}
//获取最新的10条新闻信息
public String listNewNews(){
	int max=10;
	int first=0;
	String sort="DESC";
	newses=newsService.listNewNews(first,max,sort);
	return "display";
}
//管理员主页的新闻种类
public String listCategoryAdmin(){
	categorys=categoryService.findAllCategory();
	return "list";
}
//根据Cid获取新闻内容
public String listNewsByCid(){
	newses=newsService.findSameNewsByCategoryAll(getCid());
	categorys=categoryService.findAllCategory();
	return "display";
}
//获取单条新闻详情
public String dispalyDetailNews(){
	news=newsService.getNewsById(this.getNid());
	return "detailContent";
}
//根据标题模糊查询新闻内容
public String likeTitle() throws UnsupportedEncodingException{
	newses=newsService.likeTitle(this.getTitle());
	System.out.println("新闻条数"+newses.size());
	return "display";
}
//根据时间查询新闻内容
public String selectByTime() throws ParseException{
	newses=newsService.selectByTime(getStartTime(), getEndTime());
	System.out.println("======="+startTime+"   "+endTime);
	return "display";
}

}
