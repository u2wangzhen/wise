package com.u2.wise.controller;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.u2.common.BaseController;
import com.u2.common.IDKit;
import com.u2.common.ParamsUtils;
import com.u2.common.ResultData;
import com.u2.common.StringUtil;
import com.u2.wise.model.Student;
import com.u2.wise.server.StudentService;
import com.u2.wise.server.impl.StudentServiceImpl;

public class StudentController2 extends BaseController{
	
	private StudentService srv = enhance(StudentServiceImpl.class);
	
	public void index(){
		render(BASS_PATH+"student/list.html");
	}
	public void toAdd(){
		render(BASS_PATH+"student/add.html");
	}
	public void addStudent(){
		
		ResultData rd=new ResultData();
		Student stu=getModel(Student.class);
		if(StringUtil.isNotEmpty(stu.getId())){
			
		}else{
			boolean a = srv.save(stu);
			if(a){
				rd.setSuccess("保存成功", null);
			}else{
				rd.setFaild("保存失败", null);
			}
		}
		renderJson(rd);
		
	}
	public void listData(){
		
		ResultData rd=new ResultData();
		/*int p = getParaToInt("page");
		int limit = getParaToInt("limit");*/
		Map<String, String> paraMap = ParamsUtils.getParameterMap(getRequest());
		//Page<Student> page = Student.dao.paginate(p, limit,"select * ","from t_student ");
		Page<Record> r = srv.pageList1(getParaToInt("page", 1), getParaToInt("limit", 10), paraMap, "age", "desc");
		rd.put("count", r.getTotalRow());
		rd.setSuccess("ok", r.getList());
		renderJson(rd);
	}
}
