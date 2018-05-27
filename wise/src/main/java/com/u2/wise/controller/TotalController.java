package com.u2.wise.controller;

import com.jfinal.core.Controller;

public class TotalController extends Controller{

	public void toStudent(){
		render("student.html");
	}
	public void toTeacher(){
		render("teacher.html");
	}
	public void toCurriculum(){
		render("Curriculum.html");
	}
}
