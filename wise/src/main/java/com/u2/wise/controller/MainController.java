package com.u2.wise.controller;

import com.u2.common.BaseController;

public class MainController extends BaseController{

	public void index(){
		
		render("index.html");
	}
	
	public void welcome(){
		render("welcome.html");
	}
}
