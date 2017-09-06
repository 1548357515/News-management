package org.wjw.interceptor;

import java.util.Map;

import org.wjw.po.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class AuthorityInterceptor extends AbstractInterceptor {
  /**
	 * 
	 */
	private static final long serialVersionUID = 3979258630400114465L;

public String intercept(ActionInvocation invocation)throws Exception{
	  ActionContext ctx=invocation.getInvocationContext();
	  Map<String,Object> session=ctx.getSession();
	  if(session.get("username")!=null){
		  System.out.println("用户已登录");
	    return  invocation.invoke();
	  }else{
		  ctx.put("msg","您还没有登录，请登录！");
		  return Action.LOGIN;
	  }
  }
}
