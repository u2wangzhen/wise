package com.u2.wise.student;

import com.jfinal.plugin.activerecord.Page;
import com.u2.common.BaseController;
import com.u2.wise.model.Student;

public class StudentController extends BaseController{

	
	public void index(){
		
		/*new Student()
		.set("id", IDKit.generatorID())
		.set("name", "test")
		.set("age", 2)
		.set("sex",1).save();*/
		System.out.println("ss");
		Page<Student> page = Student.dao.paginate(1, 10,"select * ","from t_student ");
		render(BASS_PATH+"student/list.html");
		
		
	}
}
