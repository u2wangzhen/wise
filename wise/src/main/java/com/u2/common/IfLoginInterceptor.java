package com.u2.common;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class IfLoginInterceptor implements Interceptor {
	private static String login="/login";
	public void intercept(Invocation inv) {
		if(!inv.getActionKey().contains(login)){//如果访问的不是登录地址,并且，访问的是/admin/路由下的地址&&inv.getActionKey().indexOf("/admin/")==0
			Controller c = inv.getController();
			try{
				boolean isLogin=c.getSessionAttr("isLogin");
				if(!isLogin){
					c.redirect(login);
					return;
				}
			} catch (Exception e) {
				// TODO: handle exception
				c.redirect(login);
				return;
			}
			
		}
		inv.invoke();
	}

}
