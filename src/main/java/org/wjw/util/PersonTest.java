package org.wjw.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wjw.po.News;
import org.wjw.service.NewsService;
import org.wjw.service.UserService;

public class PersonTest {
private static ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
private static UserService userService = (UserService)ctx.getBean("userService");
private static NewsService newsService = (NewsService)ctx.getBean("newsService");

 public static void main(String[] args) throws ParseException{
   // add();
	//System.out.println(userService.isLogin("admin", "admin"));
	 Date startTime=new Date();
	 Date endTime=new Date();
/*	    String dateNowStr = sdf.format(date);*/
	  

	
/*	
	for(News news:newses){
		System.out.println(news.getIssueTime());
	}*/
 }
}
