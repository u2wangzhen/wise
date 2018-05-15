package com.u2.wise.vo;

import java.io.Serializable;

/**
 * t_class_record
 */
public class ClassRecordVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private java.lang.String id;
	private java.lang.String cid;
	private java.util.Date recordData;
	private java.util.Date startTime;
	private java.util.Date endTime;
	private java.lang.Double classHour;
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
	public void setCid(java.lang.String cid) {
		this.cid = cid;
	}
	/**  */
	public java.lang.String getCid() {
		return cid;
	}		
	/**  */	
	public void setRecordData(java.util.Date recordData) {
		this.recordData = recordData;
	}
	/**  */
	public java.util.Date getRecordData() {
		return recordData;
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
	public void setClassHour(java.lang.Double classHour) {
		this.classHour = classHour;
	}
	/**  */
	public java.lang.Double getClassHour() {
		return classHour;
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
		return "ClassRecordVO ["+   ", id=" + id +    ", cid=" + cid +    ", recordData=" + recordData +    ", startTime=" + startTime +    ", endTime=" + endTime +    ", classHour=" + classHour +    ", remark=" + remark +    ", delFlag=" + delFlag +  "]";
	}
	
}