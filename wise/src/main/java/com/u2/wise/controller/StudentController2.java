package com.u2.wise.controller;

import java.util.List;
import java.util.Map;

import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.u2.common.BaseController;
import com.u2.common.ParamsUtils;
import com.u2.common.ResultData;
import com.u2.common.StringUtil;
import com.u2.wise.model.Student;
import com.u2.wise.server.StudentService;
import com.u2.wise.server.impl.StudentServiceImpl;
import com.xiaoleilu.hutool.util.CollectionUtil;

public class StudentController2 extends BaseController{
	
	private StudentService srv = enhance(StudentServiceImpl.class);
	
	public void index(){
		render("list.html");
	}
	public void toForm(){
		String id = getPara("id");
		Student stu=null;
		if(StringUtil.isNotEmpty(id)){
			stu = srv.getById(id);
			
		}else{
			stu=new Student();
		}
		setAttr("student",stu);
		render("add.html");
	}
	
	public void toList(){
		render("_list.html");
	}
	public void toList2(){
		render("_list2.html");
	}
	
	public void saveOrUpdate(){
		
		ResultData rd=new ResultData();
		Student stu=getModel(Student.class);
		if(StringUtil.isNotEmpty(stu.getId())){
			if(srv.update(stu)){
				rd.setSuccess("更新成功", null);
			}else{
				rd.setFaild("更新失败", null);
			}
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
	
	public void list(){
		ResultData result = new ResultData();
		Map<String, String> paraMap = ParamsUtils.getParameterMap(getRequest());
		List<Record> list =  srv.list(paraMap);
		if(CollectionUtil.isEmpty(list)){
			renderJson(result.setFaild("获取列表失败", null));
		}else{
			renderJson(result.setSuccess("获取列表成功", list));

		}
	}
	public void listData(){
		
		ResultData rd=new ResultData();
		/*int p = getParaToInt("page");
		int limit = getParaToInt("limit");*/
		Map<String, String> paraMap = ParamsUtils.getParameterMap(getRequest());
		//Page<Student> page = Student.dao.paginate(p, limit,"select * ","from t_student ");
		Page<Record> r = srv.pageList1(getParaToInt("page", 1), getParaToInt("limit", 10), paraMap, getPara("sort","create_time"),getPara("order","desc"));
		rd.put("count", r.getTotalRow());
		rd.setSuccess("ok", r.getList());
		renderJson(rd);
	}
}
