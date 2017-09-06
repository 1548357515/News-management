package org.wjw.action;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import org.wjw.po.Category;
import org.wjw.po.News;
import org.wjw.service.NewsService;
import org.wjw.util.DateUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("unchecked")
public class NewsAction extends ActionSupport{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2598627202224372600L;
	@Resource
	private NewsService newsService;
    private int nid;
    private News news;
    private List<News> newses;
    private int cid;
    private List<Category> categorys;

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
	public String addNews() throws ParseException{
		news.setIssueTime(DateUtil.getCurrentDate());
		newsService.addNews(news);
	 return SUCCESS;
	}
	public String updateNews(){
		news=newsService.getNewsById(nid);
		return "update";
	}
	public String updatedNews() throws ParseException{
		news.setIssueTime(DateUtil.getCurrentDate());
		newsService.updateNews(news);
		
		return SUCCESS;
	}
	public String deleteNews(){
		news=newsService.getNewsById(nid);
		newsService.deleteNews(news);
		return SUCCESS;
	}
	public String listNews(){
		newses=newsService.findAllNews();
		return "list";
	}
	public String findNewsDetails(){
		news=newsService.getNewsById(nid);
		return "details";
	}
	public String inputNewsAdd(){
   	categorys=(List<Category>) ActionContext.getContext().getSession().get("categorys");
		return "input";
	}
	public List<Category> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	//根据category的id来查找同类型新闻
	public String findSameNewsByCategory(){
	//清空之前的缓存数据
	//	System.out.println("查询前的newses"+newses.size());
	newses=newsService.findSameNewsByCategoryAll(news.getCategory().getId());
		System.out.println("============category_id="+news.getCategory().getId()+"查询后的数据"+newses.size());
		return "select";
	}
}
