package com.u2.wise.controller;

import com.u2.common.BaseController;

public class LoginController extends BaseController{

	public void index(){
		render("login.html");
	}
	public void toLogin(){
		
		String name=getPara("username");
		String pd=getPara("password");
		if("admin".equals(name)&&"1".equals(pd)){
			setSessionAttr("isLogin", true);
			redirect("/main");
		}else{
			setAttr("massage", "登陆失败！");
			setSessionAttr("isLogin", false);
			render("login.html");
		}
		
		
	}
	public void outLogin(){
		setSessionAttr("isLogin", false);
		render("login.html");
	}
}
