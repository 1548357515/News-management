package org.wjw.service;

import java.util.Date;
import java.util.List;

import org.wjw.po.News;

public interface NewsService {
	//增加News
	public void addNews(News news);
	//更新News
	public void updateNews(News news);
	//删除News
	public void deleteNews(News news);
	//找到所有的News
	public List<News> findAllNews();
	//根据cId查找News
	public News getNewsById(Integer nid);
	//根据CategoryId来查找所有的News
	public List<News>  findSameNewsByCategoryAll(Integer category_id);
	//根据标题的模糊查询
	public List<News> likeTitle(String title) ;
	//根据时间范围查询
	public List<News> selectByTime( String startTime, String  endTime);
	//获取最新n条新闻
	public List<News> listNewNews(int first,int max,String sort);
	public List<News> findSameNewsByCategory(Integer category_id,int first,int max) ;
}
