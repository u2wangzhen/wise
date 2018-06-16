package com.u2.wise.controller;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.alibaba.druid.util.Base64;
import com.u2.common.BaseController;
import com.u2.common.ResultData;

public class LoginController extends BaseController{
	private static final String pw="wjUyZXuDw9LPwxoEV3IkBQ==";//
	private static final String pw2="xMpCOKC5I4INzFCab3WEmw==";
	public void index(){
		render("login.html");
	}
	public void toLogin() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		String name=getPara("username");
		String pd=getPara("password");
		if("admin".equals(name)&&pw.equals(EncoderByMd5(pd))){
			setSessionAttr("isLogin", true);
			redirect("/main");
		}else{
			setAttr("massage", "登陆失败！");
			setSessionAttr("isLogin", false);
			render("login.html");
		}
		
		
	}
	public void verify() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		ResultData result = new ResultData();
		String pd = getPara("password");
		if(pw2.equals(EncoderByMd5(pd))){
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
	
	 public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
	        //确定计算方法
	        MessageDigest md5=MessageDigest.getInstance("MD5");
	       
	        //加密后的字符串
	        String newstr=Base64.byteArrayToBase64(md5.digest(str.getBytes("utf-8")));
	        return newstr;
	    }

}
