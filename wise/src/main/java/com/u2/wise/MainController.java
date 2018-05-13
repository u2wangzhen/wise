package com.u2.wise;

import com.u2.common.BaseController;

public class MainController extends BaseController{

	public void index(){
		
		render(BASS_PATH+"index.html");
	}
	
	public void welcome(){
		render(BASS_PATH+"welcome.html");
	}
}
