package com.u2.wise.vo;

import java.io.Serializable;

/**
 * t_student
 */
public class StudentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private java.lang.String id;
	private java.lang.String name;
	private java.lang.Integer age;
	private java.lang.Integer sex;
	private java.lang.String code;
	private java.lang.String parentName;
	private java.lang.String parentInfo;
	private java.util.Date createTime;
	private java.util.Date startTime;
	
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
	public void setAge(java.lang.Integer age) {
		this.age = age;
	}
	/**  */
	public java.lang.Integer getAge() {
		return age;
	}		
	/**  */	
	public void setSex(java.lang.Integer sex) {
		this.sex = sex;
	}
	/**  */
	public java.lang.Integer getSex() {
		return sex;
	}		
	/**  */	
	public void setCode(java.lang.String code) {
		this.code = code;
	}
	/**  */
	public java.lang.String getCode() {
		return code;
	}		
	/**  */	
	public void setParentName(java.lang.String parentName) {
		this.parentName = parentName;
	}
	/**  */
	public java.lang.String getParentName() {
		return parentName;
	}		
	/**  */	
	public void setParentInfo(java.lang.String parentInfo) {
		this.parentInfo = parentInfo;
	}
	/**  */
	public java.lang.String getParentInfo() {
		return parentInfo;
	}		
	/**  */	
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	/**  */
	public java.util.Date getCreateTime() {
		return createTime;
	}		
	/**  */	
	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}
	/**  */
	public java.util.Date getStartTime() {
		return startTime;
	}		
	
	@Override
	public String toString() {
		return "StudentVO ["+   ", id=" + id +    ", name=" + name +    ", age=" + age +    ", sex=" + sex +    ", code=" + code +    ", parentName=" + parentName +    ", parentInfo=" + parentInfo +    ", createTime=" + createTime +    ", startTime=" + startTime +  "]";
	}
	
}