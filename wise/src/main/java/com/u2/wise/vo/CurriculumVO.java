package com.u2.wise.vo;

import java.io.Serializable;

/**
 * t_curriculum
 */
public class CurriculumVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private java.lang.String id;
	private java.lang.String name;
	private java.lang.String subject;
	private java.lang.Integer type;
	private java.lang.String grade;
	private java.lang.String teacherId;
	private java.lang.String teacherName;
	private java.util.Date startTime;
	private java.util.Date endTime;
	private java.lang.String remark;
	private java.lang.Integer delFlag;
	
	/**  */	
	public void setId(java.lang.String id) {
		this.id = id;
	}
	/**  */
	public java.lang.String getId() {
		return id;
	}		
	/**  */	
	public void setName(java.lang.String name) {
		this.name = name;
	}
	/**  */
	public java.lang.String getName() {
		return name;
	}		
	/**  */	
	public void setSubject(java.lang.String subject) {
		this.subject = subject;
	}
	/**  */
	public java.lang.String getSubject() {
		return subject;
	}		
	/**  */	
	public void setType(java.lang.Integer type) {
		this.type = type;
	}
	/**  */
	public java.lang.Integer getType() {
		return type;
	}		
	/**  */	
	public void setGrade(java.lang.String grade) {
		this.grade = grade;
	}
	/**  */
	public java.lang.String getGrade() {
		return grade;
	}		
	/**  */	
	public void setTeacherId(java.lang.String teacherId) {
		this.teacherId = teacherId;
	}
	/**  */
	public java.lang.String getTeacherId() {
		return teacherId;
	}		
	/**  */	
	public void setTeacherName(java.lang.String teacherName) {
		this.teacherName = teacherName;
	}
	/**  */
	public java.lang.String getTeacherName() {
		return teacherName;
	}		
	/**  */	
	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}
	/**  */
	public java.util.Date getStartTime() {
		return startTime;
	}		
	/**  */	
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}
	/**  */
	public java.util.Date getEndTime() {
		return endTime;
	}		
	/**  */	
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	/**  */
	public java.lang.String getRemark() {
		return remark;
	}		
	/**  */	
	public void setDelFlag(java.lang.Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**  */
	public java.lang.Integer getDelFlag() {
		return delFlag;
	}		
	
	@Override
	public String toString() {
		return "CurriculumVO ["+   ", id=" + id +    ", name=" + name +    ", subject=" + subject +    ", type=" + type +    ", grade=" + grade +    ", teacherId=" + teacherId +    ", teacherName=" + teacherName +    ", startTime=" + startTime +    ", endTime=" + endTime +    ", remark=" + remark +    ", delFlag=" + delFlag +  "]";
	}
	
}