package com.u2.wise.student;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Page;
import com.u2.common.BaseController;
import com.u2.wise.model.Student;

public class StudentController extends BaseController{

	
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
