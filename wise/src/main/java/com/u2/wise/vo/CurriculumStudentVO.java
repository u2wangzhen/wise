package com.u2.wise.vo;

import java.io.Serializable;

/**
 * t_curriculum_student
 */
public class CurriculumStudentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private java.lang.String id;
	private java.lang.String cid;
	private java.lang.String studentId;
	
	/**  */	
	public void setId(java.lang.String id) {
		this.id = id;
	}
	/**  */
	public java.lang.String getId() {
		return id;
	}		
	/**  */	
	public void setCid(java.lang.String cid) {
		this.cid = cid;
	}
	/**  */
	public java.lang.String getCid() {
		return cid;
	}		
	/**  */	
	public void setStudentId(java.lang.String studentId) {
		this.studentId = studentId;
	}
	/**  */
	public java.lang.String getStudentId() {
		return studentId;
	}		
	
	@Override
	public String toString() {
		return "CurriculumStudentVO ["+   ", id=" + id +    ", cid=" + cid +    ", studentId=" + studentId +  "]";
	}
	
}