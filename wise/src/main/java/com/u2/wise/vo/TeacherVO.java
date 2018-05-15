package com.u2.wise.vo;

import java.io.Serializable;

/**
 * t_teacher
 */
public class TeacherVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private java.lang.String id;
	private java.lang.String name;
	private java.lang.String phone;
	private java.lang.Integer sex;
	private java.lang.String classType;
	private java.lang.String remark;
	private java.util.Date createTime;
	private java.lang.Long delFlag;
	
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
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}
	/**  */
	public java.lang.String getPhone() {
		return phone;
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
	public void setClassType(java.lang.String classType) {
		this.classType = classType;
	}
	/**  */
	public java.lang.String getClassType() {
		return classType;
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
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	/**  */
	public java.util.Date getCreateTime() {
		return createTime;
	}		
	/**  */	
	public void setDelFlag(java.lang.Long delFlag) {
		this.delFlag = delFlag;
	}
	/**  */
	public java.lang.Long getDelFlag() {
		return delFlag;
	}		
	
	@Override
	public String toString() {
		return "TeacherVO ["+   ", id=" + id +    ", name=" + name +    ", phone=" + phone +    ", sex=" + sex +    ", classType=" + classType +    ", remark=" + remark +    ", createTime=" + createTime +    ", delFlag=" + delFlag +  "]";
	}
	
}