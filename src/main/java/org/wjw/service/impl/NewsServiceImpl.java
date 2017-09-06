package org.wjw.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wjw.dao.NewsDao;
import org.wjw.po.News;
import org.wjw.service.NewsService;


@Service("newsService")
public class NewsServiceImpl   implements NewsService{
	@Resource
   private NewsDao newsDao;

	public void addNews(News news) {
		newsDao.add(news);
	}

	public void updateNews(News news) {
	newsDao.update(news);
	}

	public void deleteNews(News news) {
	newsDao.delete(news);
	}

	public List<News> findAllNews() {
		List<News> lists=newsDao.findAll();
		return lists;
	}

	public News getNewsById(Integer nid) {
		News news=newsDao.getById(nid);
		return news;
	}
	public List<News> findSameNewsByCategoryAll(Integer category_id) {
		List<News> lists=newsDao.findSameNewsByCategoryAll(category_id);
		return lists;
	}

	@Override
	public List<News> likeTitle(String title) {
		List<News> lists=newsDao.likeTitle(title);
		return lists;
	}

	@Override
	public List<News> selectByTime( String startTime, String endTime) {
	List<News> lists=newsDao.selectByTime(startTime, endTime);
		return lists;
	}
	//获取最新n条新闻
	@Override
	public List<News> listNewNews(int first,int max,String sort) {
		List<News> lists=newsDao.listNewNews(first,max,sort);
		return lists;
	}

	@Override
	public List<News> findSameNewsByCategory(Integer category_id, int first,
			int max) {
		List<News> lists=newsDao.findSameNewsByCategory(category_id, first, max);
		return lists;
	}

}
