package com.u2.wise.model;

import com.u2.wise.model.base.BaseStudent;

/**
 * 
 */
public class Student extends BaseStudent<Student> implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Student dao = new Student();

}