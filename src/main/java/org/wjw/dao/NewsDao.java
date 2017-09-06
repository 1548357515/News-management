package org.wjw.dao;

import java.util.List;

import org.wjw.po.News;

public interface NewsDao extends BaseDao<News>{
	public List<News> findSameNewsByCategoryAll(Integer category_id) ;
	public List<News> findSameNewsByCategory(Integer category_id,int first,int max) ;
	//找到所有的Category
		public List<News> findAll();
	//根据标题的模糊查询
		public List<News> likeTitle(String title);
		//根据时间区间进行查询
		public List<News> selectByTime(String startTime,String endTime);
		//获取最新n条新闻
		public List<News> listNewNews(int first,int max,String sort);
}
