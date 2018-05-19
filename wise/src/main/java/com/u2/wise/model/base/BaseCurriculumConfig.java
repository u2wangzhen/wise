package com.u2.wise.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseCurriculumConfig<M extends BaseCurriculumConfig<M>> extends Model<M> implements IBean {

		/**  */
		public void setId(java.lang.String id) {
			set("id", id);
		}
		/**  */
		public java.lang.String getId() {
			return get("id");
		}
		/**  */
		public void setCid(java.lang.String cid) {
			set("cid", cid);
		}
		/**  */
		public java.lang.String getCid() {
			return get("cid");
		}
		/**  */
		public void setStudentCount(java.lang.Integer studentCount) {
			set("student_count", studentCount);
		}
		/**  */
		public java.lang.Integer getStudentCount() {
			return get("student_count");
		}
		/**  */
		public void setClassFee(java.lang.Integer classFee) {
			set("class_fee", classFee);
		}
		/**  */
		public java.lang.Integer getClassFee() {
			return get("class_fee");
		}
		/**  */
		public void setTeacherPrice(java.lang.Integer teacherPrice) {
			set("teacher_price", teacherPrice);
		}
		/**  */
		public java.lang.Integer getTeacherPrice() {
			return get("teacher_price");
		}

}