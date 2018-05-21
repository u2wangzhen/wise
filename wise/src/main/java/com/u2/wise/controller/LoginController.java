package com.u2.wise.controller;

import com.u2.common.BaseController;
import com.u2.common.ResultData;

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
	public void verify(){
		ResultData result = new ResultData();
		String pd = getPara("password");
		if("1".equals(pd)){
			result.setSuccess("验证通过", getPara("url"));
		}else{
			result.setFaild("验证失败", null);
		}
		renderJson(result);
	}
	public void toVerify(){
		boolean b=getSessionAttr("isLogin");
		if(b){
			setAttr("url", getPara("url"));
			render("verify.html");
		}else{
			render("login.html");
		}
	}
	public void outLogin(){
		setSessionAttr("isLogin", false);
		render("login.html");
	}
}
