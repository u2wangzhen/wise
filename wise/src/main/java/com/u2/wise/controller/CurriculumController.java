package com.u2.wise.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.u2.common.ParamsUtils;
import com.u2.common.ResultData;
import com.u2.common.StringUtil;
import com.u2.wise.model.Curriculum;
import com.u2.wise.server.CurriculumConfigService;
import com.u2.wise.server.CurriculumService;
import com.u2.wise.server.CurriculumStudentService;
import com.u2.wise.server.StudentPaymentService;
import com.u2.wise.server.StudentService;
import com.u2.wise.server.impl.CurriculumConfigServiceImpl;
import com.u2.wise.server.impl.CurriculumServiceImpl;
import com.u2.wise.server.impl.CurriculumStudentServiceImpl;
import com.u2.wise.server.impl.StudentPaymentServiceImpl;
import com.u2.wise.server.impl.StudentServiceImpl;
import com.xiaoleilu.hutool.util.CollectionUtil;

import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;

/**
 * controller:/sutra/curriculum
 */
public class CurriculumController extends Controller {
	
	//private static final Logger logger = LoggerFactory.getLogger(CurriculumController.class);
	private CurriculumService srv = enhance(CurriculumServiceImpl.class);
	private CurriculumStudentService csrv = enhance(CurriculumStudentServiceImpl.class);
	private StudentService ssrv = enhance(StudentServiceImpl.class);
	
	private CurriculumConfigService ccsrv = enhance(CurriculumConfigServiceImpl.class);

	public void index() {
		this.render("index.html");
	}
	
	public void toList(){
		this.render("_list.html");
	}
	
	/**
	 * 列表
	 */
	public void list(){
		ResultData result = new ResultData();
		Map<String, String> paraMap = ParamsUtils.getParameterMap(getRequest());
		List<Record> list =  srv.list(paraMap);
		if(CollectionUtil.isEmpty(list)){
			renderJson(result.setFaild("获取列表失败", null));
			return;
		}
		renderJson(result.setSuccess("获取列表成功", list));
	}
	
	/**
	 * 分页列表
	 */
	public void pageList(){
		ResultData result = new ResultData();
		Map<String, String> paraMap = ParamsUtils.getParameterMap(getRequest());
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
		Map<String, String> paraMap = ParamsUtils.getParameterMap(getRequest());
		
		String sid = paraMap.get("student_id");
		String sts="";
		if(StringUtil.isNotEmpty(sid)){
			Map<String, String> m=new HashMap<String, String>();
			m.put("student_id", sid);
			List<Record> list = csrv.list(m);
			if(list!=null&&!list.isEmpty()){
				
				for (Record r : list) {
					if(StringUtil.isNotEmpty(sts)){
						sts+=",";
					}
					sts+="'"+r.getStr("cid")+"'";
				}
			}
		}
		paraMap.put("ids", sts);
		Page<Record> pages =  srv.pageList1(getParaToInt("page",1),getParaToInt("limit",10),paraMap,getPara("sort","start_time"),getPara("order","desc"));
		if(pages != null){
			result.put("count", pages.getTotalRow());
			List<Record> list = pages.getList();
			renderJson(result.setSuccess("查询分页数据成功", isConfig(list)));
			return;
		}
		result.put("count", 0);
		renderJson(result.setFaild("查询分页数据失败", null));
	}
	
	private List<Record> isConfig(List<Record> list) {
		// TODO Auto-generated method stub
		if(list!=null&&!list.isEmpty()){
			for (Record r : list) {
				Map<String, String> param=new HashMap<String, String>();
				param.put("cid", r.getStr("id"));
				List<Record> ll = ccsrv.list(param);{
					if(ll!=null&&!ll.isEmpty()){
					r.set("isConfig", "是");
					}else{
						r.set("isConfig", "否");
					}
				}
			}
		}
		return list;
	}

	/*private List<Record> addStudents(List<Record> list) {
		// TODO Auto-generated method stub
		if(list!=null&&!list.isEmpty()){
			
			for (Record r : list) {
				
				Map<String, String> param=new HashMap<String, String>();
				param.put("cid", r.getStr("id"));
				List<Record> ll = csrv.list(param);
				if(ll!=null&&!ll.isEmpty()){
					String sts="";
					for (Record record : ll) {
						if(StringUtil.isNotEmpty(sts)){
							sts+=" , ";
						}
						sts+=ssrv.getById(record.getStr("student_id")).getName();
					}
					r.set("students", sts);
				}
			}
		}
		
		return list;
	}*/

	/**
	 * 详情页
	 */
	public void toDetail(){
		setAttr("cid", getPara("id"));
		setAttr("c", srv.getById(getPara("id")));
		render("detail.html");
	}
	
	/**
	 * 新增编辑页
	 */
	public void toForm(){
		String id = getPara("id");
		Curriculum c=null;
		if(StringUtil.isNotEmpty(id)){
			c=srv.getById(id);
			Map<String, String> param=new HashMap<String, String>();
			param.put("cid", id);
			List<Record> list = csrv.list(param);
			if(!list.isEmpty()){
				String sts="";
				for (Record record : list) {
					if(StringUtil.isNotEmpty(sts)){
						sts+=",";
					}
					sts+="'"+record.get("student_id")+"'";
				}
				
				param.put("ids", sts);
				list=ssrv.list(param);
				setAttr("data",JsonKit.toJson(list));
				setAttr("students",sts.replaceAll("'", ""));
			}
		}else{
			c=new Curriculum();
		}
		setAttr("curriculum",c);
		
		render("_form.html");
	}
	
	/**
	 * 新增或编辑记录
	 */
	public void saveOrUpdate(){
		ResultData result = new ResultData();
		Curriculum curriculum = getModel(Curriculum.class);
		curriculum.setDelFlag(0);
		String students=getPara("students");
		if(curriculum.getId() == null ){
			if(srv.save(curriculum,students)){
				result.setSuccess("保存成功", null);
			}else{
				result.setFaild("保存失败", null);
			}
		}else{
			if(srv.update(curriculum,students)){
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
		String id=getPara("id");
		if(StringUtil.isNotEmpty(id)){
			Curriculum cc = srv.getById(id);
			cc.setEndTime(new Date());
			cc.setDelFlag(1);
			if(srv.update(cc)){
				renderJson(result.setSuccess("操作成功", null));
			}else{
				renderJson(result.setFaild("操作失败", null));
			}
		}else{
			renderJson(result.setFaild("丢失id无法结课", null));
		}
		
		
		
	}
	
}