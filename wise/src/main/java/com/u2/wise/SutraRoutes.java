package com.u2.wise;

import com.jfinal.config.Routes;
import com.u2.wise.controller.ClassRecordController;
import com.u2.wise.controller.CurriculumConfigController;
import com.u2.wise.controller.CurriculumController;
import com.u2.wise.controller.CurriculumStudentController;
import com.u2.wise.controller.IndexController;
import com.u2.wise.controller.StudentController;
import com.u2.wise.controller.StudentPaymentController;
import com.u2.wise.controller.TeacherController;


public class SutraRoutes extends Routes{

	@Override
	public void config() {
		setBaseViewPath("/WEB-INF/pages");
		add("/",IndexController.class,"/sutra/index");
	    add("/sutra/classRecord", ClassRecordController.class,"/sutra/classRecord");
	    add("/sutra/curriculum", CurriculumController.class,"/sutra/curriculum");
	    add("/sutra/curriculumConfig", CurriculumConfigController.class,"/sutra/curriculumConfig");
	    add("/sutra/curriculumStudent", CurriculumStudentController.class,"/sutra/curriculumStudent");
	    add("/sutra/student", StudentController.class,"/sutra/student");
	    add("/sutra/studentPayment", StudentPaymentController.class,"/sutra/studentPayment");
	    add("/sutra/teacher", TeacherController.class,"/sutra/teacher");
	
	}

}