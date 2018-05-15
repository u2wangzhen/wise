package com.u2.wise.vo;

import java.io.Serializable;

/**
 * t_curriculum_config
 */
public class CurriculumConfigVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private java.lang.String id;
	private java.lang.String cid;
	private java.lang.Integer studentCount;
	private java.lang.Integer classFee;
	private java.lang.Integer teacherPrice;
	
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
	public void setStudentCount(java.lang.Integer studentCount) {
		this.studentCount = studentCount;
	}
	/**  */
	public java.lang.Integer getStudentCount() {
		return studentCount;
	}		
	/**  */	
	public void setClassFee(java.lang.Integer classFee) {
		this.classFee = classFee;
	}
	/**  */
	public java.lang.Integer getClassFee() {
		return classFee;
	}		
	/**  */	
	public void setTeacherPrice(java.lang.Integer teacherPrice) {
		this.teacherPrice = teacherPrice;
	}
	/**  */
	public java.lang.Integer getTeacherPrice() {
		return teacherPrice;
	}		
	
	@Override
	public String toString() {
		return "CurriculumConfigVO ["+   ", id=" + id +    ", cid=" + cid +    ", studentCount=" + studentCount +    ", classFee=" + classFee +    ", teacherPrice=" + teacherPrice +  "]";
	}
	
}