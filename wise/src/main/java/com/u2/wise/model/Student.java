package com.u2.wise.model;

import com.jfinal.plugin.activerecord.Model;

public class Student extends Model<Student>{
	public static final Student dao = new Student().dao();
}
