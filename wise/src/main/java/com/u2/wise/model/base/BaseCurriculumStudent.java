package com.u2.wise.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseCurriculumStudent<M extends BaseCurriculumStudent<M>> extends Model<M> implements IBean {

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
		public void setStudentId(java.lang.String studentId) {
			set("student_id", studentId);
		}
		/**  */
		public java.lang.String getStudentId() {
			return get("student_id");
		}

}