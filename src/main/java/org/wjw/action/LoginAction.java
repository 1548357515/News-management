package org.wjw.action;

import java.util.Map;

import javax.annotation.Resource;

import org.wjw.po.User;
import org.wjw.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction  extends ActionSupport   implements ModelDriven<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3507495351179546010L;
	private User user=new User();
	@Resource
	private UserService userService;
	@Override
	public User getModel() {
		return  user;
	}
	//判断用户登录情况
	public String validateLoginState(){
	
		  ActionContext ctx=ActionContext.getContext();
	      Map<String,Object> session=ctx.getSession();
	      //如果user为值空时返回登录,如果已经登录过直接进入管理员页面
	 /*     if(user.getPassword()==null||user.getPassword()==null){
	    	  if(session.get("username")!=null){
	    		  return SUCCESS;
	    	  }else{
	    	  return "login1";
	    	  }
	      }*/
	      //如果登录过就直接登录管理员系统
	  /*   if(session.get("username")!=null){
	    	  return SUCCESS;
	      }*/
	      if(user.getUsername()==null||user.getUsername().isEmpty()){
	    	  ctx.put("msg","用户名不能为空");
	    	  return INPUT;
	      }
	      if(user.getPassword()==null||user.getPassword().isEmpty()){
	    	  ctx.put("msg","密码不能为空");
	    	  return INPUT;
	      }
		boolean result=userService.isLogin(user.getUsername(), user.getPassword());
		if(result){
			 session.put("username",user.getUsername());
		return SUCCESS;
		}else{
			 ctx.put("msg","用户名或密码错误");
	 	   return INPUT;
		}
	}
	//跳转到登录页面
	public String loginUserPage(){
		return INPUT;
	}
	public String userRegister(){
		this.userService.userRegister(user);
		return INPUT;
	}
}
