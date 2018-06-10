package com.u2.wise.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import com.u2.wise.CurriculumTotalBean;
import com.u2.wise.TeacherTotalBean;
import com.u2.wise.model.Curriculum;
import com.u2.wise.server.ClassRecordService;
import com.u2.wise.server.CurriculumConfigService;
import com.u2.wise.server.CurriculumService;
import com.u2.wise.server.CurriculumStudentService;
import com.u2.wise.server.StudentService;
import com.u2.wise.server.impl.ClassRecordServiceImpl;
import com.u2.wise.server.impl.CurriculumConfigServiceImpl;
import com.u2.wise.server.impl.CurriculumServiceImpl;
import com.u2.wise.server.impl.CurriculumStudentServiceImpl;
import com.u2.wise.server.impl.StudentServiceImpl;
import com.xiaoleilu.hutool.date.DateUtil;

public class TotalController extends Controller{

	private CurriculumService cs = enhance(CurriculumServiceImpl.class);
	private CurriculumStudentService css = enhance(CurriculumStudentServiceImpl.class);
	private StudentService ss = enhance(StudentServiceImpl.class);
	private CurriculumConfigService ccs = enhance(CurriculumConfigServiceImpl.class);
	private ClassRecordService crs = enhance(ClassRecordServiceImpl.class);


	public void toStudent(){
		render("student.html");
	}
	public void toTeacher(){
		
		Map<String, String> param=new HashMap<String, String>();
		param.put("start_time", DateUtil.beginOfMonth(new Date()).toString());
		param.put("end_time", DateUtil.endOfMonth(new Date()).toString());
		List<Record> crlist = crs.list(param);
		
		List<TeacherTotalBean> ttbl=buildTeacherTotal(crlist);
		setAttr("list", ttbl);
		render("teacher.html");
	}
	private List<TeacherTotalBean> buildTeacherTotal(List<Record> crlist) {
		// TODO Auto-generated method stub
		List<TeacherTotalBean> ttbl=new ArrayList<TeacherTotalBean>();
		if(crlist!=null){
			Map<String,TeacherTotalBean> map=new HashMap<String, TeacherTotalBean>();
			for (Record r : crlist) {
				String cid=r.get("cid");
				Curriculum c = cs.getById(cid);
				TeacherTotalBean ttb = map.get(c.getTeacherName());
				if(ttb==null){
					ttb=new TeacherTotalBean();
					ttb.setName(c.getTeacherName());
					map.put(c.getTeacherName(), ttb);
					ttbl.add(ttb);
				}
				
				///
				ttb.setHours(ttb.getHours()+r.getDouble("class_hour"));
				ttb.setCs(ttb.getCs()+1);
				////
				if(ttb.getCurrMap()==null){
					CurriculumTotalBean ctb = new CurriculumTotalBean();
					ctb.setName(c.getName());
					ttb.putCurrMap(c.getName(), ctb);
				}
				
				CurriculumTotalBean ctb = ttb.getCurrMap().get(c.getName());
				
				if(ctb==null){
					ctb = new CurriculumTotalBean();
					ctb.setName(c.getName());
					ttb.putCurrMap(c.getName(), ctb);
				}
				
				////
				ctb.setHours(ctb.getHours()+r.getDouble("class_hour"));
				ctb.setCs(ctb.getCs()+1);
				ctb.addCrlist(r);
				////
			}
			
		}
		
		return ttbl;
	}
	public void toCurriculum(){
		render("Curriculum.html");
	}
	
	public void toClassRecord(){
		render("classRecord.html");
	}
	
	/*public static void main(String[] args) {
		Double d=new Double(1.5);
		Double c=new Double(2.5);
		
	}*/
}
