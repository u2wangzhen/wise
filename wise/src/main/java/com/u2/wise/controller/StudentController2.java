package com.u2.wise.controller;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Page;
import com.u2.common.BaseController;
import com.u2.common.IDKit;
import com.u2.common.ResultData;
import com.u2.wise.model.Student;

public class StudentController2 extends BaseController{

	
	public void index(){
		
		/*new Student()
		.set("id", IDKit.generatorID())
		.set("name", "test")
		.set("age", 2)发发
		.set("sex",1).save();*/
		//System.out.println("ss");
		
		render(BASS_PATH+"student/list.html");
		
		
	}
	public void toAdd(){
		
		render(BASS_PATH+"student/add.html");
	}
	public void addStudent(){
		boolean s = new Student()
		.set("id", IDKit.generatorID())
		.set("name", getPara("name"))
		.set("age", getParaToInt("age"))
		.set("sex",1).save();
		ResultData rd=new ResultData();
		rd.setSuccess("保持成功", null);
		renderJson(rd);
		
	}
	public void listData(){
		
		
		int p = getParaToInt("page");
		int limit = getParaToInt("limit");
		Page<Student> page = Student.dao.paginate(p, limit,"select * ","from t_student ");
		Map<String ,Object> map=new HashMap<String, Object>();
		map.put("count", page.getTotalRow());
		map.put("data", page.getList());
		map.put("code", 0);
		map.put("msg", "ok");
		renderJson(map);
	}
}
