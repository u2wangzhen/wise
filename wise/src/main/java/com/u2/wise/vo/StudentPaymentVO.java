package com.u2.wise.vo;

import java.io.Serializable;

/**
 * t_student_payment
 */
public class StudentPaymentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private java.lang.String id;
	private java.lang.String studentId;
	private java.lang.Long amount;
	private java.util.Date payDate;
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
	public void setStudentId(java.lang.String studentId) {
		this.studentId = studentId;
	}
	/**  */
	public java.lang.String getStudentId() {
		return studentId;
	}		
	/**  */	
	public void setAmount(java.lang.Long amount) {
		this.amount = amount;
	}
	/**  */
	public java.lang.Long getAmount() {
		return amount;
	}		
	/**  */	
	public void setPayDate(java.util.Date payDate) {
		this.payDate = payDate;
	}
	/**  */
	public java.util.Date getPayDate() {
		return payDate;
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
		return "StudentPaymentVO ["+   ", id=" + id +    ", studentId=" + studentId +    ", amount=" + amount +    ", payDate=" + payDate +    ", remark=" + remark +    ", delFlag=" + delFlag +  "]";
	}
	
}