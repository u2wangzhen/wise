package com.u2.wise.controller;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;



import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.u2.common.ParamsUtils;
import com.u2.common.ResultData;
import com.u2.common.StringUtil;
import com.u2.wise.model.Teacher;
import com.u2.wise.server.TeacherService;
import com.u2.wise.server.impl.TeacherServiceImpl;
import com.u2.wise.validator.TearcherValidator;
import com.xiaoleilu.hutool.util.CollectionUtil;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * controller:/teacher
 */
public class TeacherController extends Controller {
	
	//private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);
	private TeacherService srv = enhance(TeacherServiceImpl.class);

	public void index() {
		this.render("index.html");
	}
	
	/**
	 * 列表
	 */
	public void list(){
		ResultData result = new ResultData();
		Map<String, Object> paraMap = ParamsUtils.getParameterMap(getRequest());
		List<Record> list =  srv.list(paraMap);
		if(CollectionUtil.isEmpty(list)){
			renderJson(result.setFaild("获取列表失败", null));
		
		}else{
			renderJson(result.setSuccess("获取列表成功", list));
		}
	}
	
	/**
	 * 分页列表
	 */
	public void pageList(){
		ResultData result = new ResultData();
		Map<String, Object> paraMap = ParamsUtils.getParameterMap(getRequest());
		Page<Record> pages =  srv.pageList(getParaToInt("pageNum",1),getParaToInt("pageSize",10),paraMap,getPara("sort","id"),getPara("order","desc"));
		if(pages != null){
			renderJson(result.setSuccess("查询分页数据成功", pages));
			return;
		}
		renderJson(result.setFaild("查询分页数据失败", null));
	}
	
	/**
	 * 分页列表1
	 */
	public void pageList1(){
		ResultData result = new ResultData();
		Map<String, Object> paraMap = ParamsUtils.getParameterMap(getRequest());
		Page<Record> pages =  srv.pageList1(getParaToInt("page",1),getParaToInt("limit",10),paraMap,getPara("sort","create_time"),getPara("order","desc"));
		if(pages != null){
			result.put("count", pages.getTotalRow());
			renderJson(result.setSuccess("查询分页数据成功", pages.getList()));
			return;
		}
		result.put("count", 0);
		renderJson(result.setFaild("查询分页数据失败", null));
	}
	
	/**
	 * 详情页
	 */
	public void toDetail(){
		setAttr("teacher", srv.getById(getPara("id")));
		render("detail.html");
	}
	
	/**
	 * 新增编辑页
	 */
	public void toForm(){
		String id = getPara("id");
		Teacher tea=null;
		if(StringUtil.isNotEmpty(id)){
			tea=srv.getById(id);
		}else{
			tea=new Teacher();
		}
		setAttr("teacher",tea);
		render("_form.html");
	}
	
	/**
	 * 新增或编辑记录
	 */
	@Before(TearcherValidator.class)
	public void saveOrUpdate(){
		ResultData result = new ResultData();
		Teacher teacher = getModel(Teacher.class);
		
		Enumeration<String> names = getParaNames();
		String str = ParamsUtils.getCheckboxStr(names,"class_type");
		teacher.setClassType(str);
		
		if(teacher.getId() == null ){
			if(srv.save(teacher)){
				result.setSuccess("保存成功", null);
			}else{
				result.setFaild("保存失败", null);
			}
		}else{
			if(srv.update(teacher)){
				result.setSuccess("更新成功", null);
			}else{
				result.setFaild("更新失败", null);
			}
		}
		renderJson(result);
	}
	
	/**
	 * 删除记录
	 */
	public void delete(){
		ResultData result = new ResultData();
		/*if(srv.delete(getParaToInt())){
			renderJson(result.setSuccess("删除成功", null));
			return;
		}*/
		renderJson(result.setFaild("删除失败", null));
	}
	
}