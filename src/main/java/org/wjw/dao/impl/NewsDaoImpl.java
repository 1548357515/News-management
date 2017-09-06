package org.wjw.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.wjw.dao.NewsDao;
import org.wjw.po.Category;
import org.wjw.po.News;
@Repository("newsDao")
@SuppressWarnings("unchecked")
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao{

	public List<News> findAll() {
		Transaction tx=this.getCurrentSession().beginTransaction();
		  Query query=this.getCurrentSession().createQuery("from News");
         Query query1=this.getCurrentSession().createQuery("from Category");
		List<Category> categorys=query1.list();
		List<News> lists=query.list();
		//根据News的category_id关联Category表，设置news类的CategoryName的值
		for(News news:lists){
			for(Category c:categorys){
			if(news.getCategory().getId().equals(c.getId())){
				news.getCategory().setCategoryName(c.getCategoryName());
			}
			}
		}
		  tx.commit();
		return lists;
	}
	public List<News> findSameNewsByCategoryAll(Integer category_id) {	
		Transaction tx=this.getCurrentSession().beginTransaction();
		Query query=this.getCurrentSession().createQuery("from News where category_id=?");
        Query query1=this.getCurrentSession().createQuery("from Category");
        List<Category> categorys=query1.list();
		  //添加参数
		query.setInteger(0, category_id);
		//执行查询，获得结果
		  List<News> newses=query.list();
			//根据News的category_id关联Category表，设置news类的CategoryName的值
			for(News news:newses){
				for(Category c:categorys){
				if(news.getCategory().getId().equals(c.getId())){
					news.getCategory().setCategoryName(c.getCategoryName());
				}
				}
			}
		  tx.commit();
		return newses;
	}
	//根据标题的模糊查询
	@Override
	public List<News> likeTitle(String title) {
		Transaction tx=this.getCurrentSession().beginTransaction();
		System.out.println("Title====="+title);
		String hql="from News where title like '%" + title + "%'";
		  Query query=this.getCurrentSession().createQuery(hql);
//		  System.out.println(query.);
	/*	  //添加参数
			query.setInteger(0, 1);*/

	  //"?"代表参数设置值
	//query.setString(0, "%"+title+"%");
		List<News> lists=query.list();
		  tx.commit();
		return lists;
	}
	//根据时间区间进行查询
	@Override
	public List<News> selectByTime(String  startTime, String endTime) {
		Transaction tx=this.getCurrentSession().beginTransaction();
		String hql="from News where issueTime between '"+startTime+"' and '"+endTime+"' order by issueTime ASC";
		  Query query=this.getCurrentSession().createQuery(hql);
		  //添加参数
		/*  query.setParameter("startTime", beginDate1);
		  query.setParameter("endTime", endDate1);*/
		  //执行查询获得结果
			List<News> lists=query.list();
		  tx.commit();
		return lists;
	}
	//获取最新n条新闻
	@Override
	public List<News> listNewNews(int first,int max,String sort) {
		Transaction tx=this.getCurrentSession().beginTransaction();
		String hql="from News order by issueTime "+sort;
		  Query query=this.getCurrentSession().createQuery(hql);
		  //执行查询获得结果
		  query.setFirstResult(first);         //从第一条开始查询
		  query.setMaxResults(max);       //查询n条数据
		   Query query1=this.getCurrentSession().createQuery("from Category");
			List<Category> categorys=query1.list();
			List<News> lists=query.list();
			//根据News的category_id关联Category表，设置news类的CategoryName的值
			for(News news:lists){
				for(Category c:categorys){
				if(news.getCategory().getId().equals(c.getId())){
					news.getCategory().setCategoryName(c.getCategoryName());
				}
				}
			}
			  tx.commit();
			return lists;
	}
	@Override
	public List<News> findSameNewsByCategory(Integer category_id,int first,int max) {
		Transaction tx=this.getCurrentSession().beginTransaction();
		Query query=this.getCurrentSession().createQuery("from News where category_id=?");
        Query query1=this.getCurrentSession().createQuery("from Category");
        query.setFirstResult(first);
        query.setMaxResults(max);
        List<Category> categorys=query1.list();
		  //添加参数
		query.setInteger(0, category_id);
		//执行查询，获得结果
		  List<News> newses=query.list();
			//根据News的category_id关联Category表，设置news类的CategoryName的值
			for(News news:newses){
				for(Category c:categorys){
				if(news.getCategory().getId().equals(c.getId())){
					news.getCategory().setCategoryName(c.getCategoryName());
				}
				}
			}
		  tx.commit();
		return newses;
	}
}
