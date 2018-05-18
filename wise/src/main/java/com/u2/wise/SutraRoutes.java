package com.u2.wise;

import com.jfinal.config.Routes;
import com.u2.wise.controller.ClassRecordController;
import com.u2.wise.controller.CurriculumConfigController;
import com.u2.wise.controller.CurriculumController;
import com.u2.wise.controller.CurriculumStudentController;
import com.u2.wise.controller.IndexController;
import com.u2.wise.controller.LoginController;
import com.u2.wise.controller.MainController;
import com.u2.wise.controller.StudentController;
import com.u2.wise.controller.StudentController2;
import com.u2.wise.controller.StudentPaymentController;
import com.u2.wise.controller.TeacherController;


public class SutraRoutes extends Routes{

	@Override
	public void config() {
		setBaseViewPath("/WEB-INF/pages");
		add("/login", LoginController.class);
		add("/student", StudentController2.class);
		add("/main", MainController.class);
	    add("/classRecord", ClassRecordController.class);
	    add("/curriculum", CurriculumController.class);
	    add("/curriculumConfig", CurriculumConfigController.class);
	    add("/curriculumStudent", CurriculumStudentController.class);
	    ///add("/student", StudentController.class);
	    add("/studentPayment", StudentPaymentController.class);
	    add("/teacher", TeacherController.class);
	
	}

}