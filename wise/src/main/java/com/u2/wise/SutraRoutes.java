package com.u2.wise;

import com.jfinal.config.Routes;
import com.u2.wise.controller.*;


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
	    add("/charts", ChartsController.class);
	    add("/studentPayment", StudentPaymentController.class);
	    add("/teacher", TeacherController.class);
	
	}

}