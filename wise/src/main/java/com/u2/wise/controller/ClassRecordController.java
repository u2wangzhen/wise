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
import com.u2.wise.model.ClassRecord;
import com.u2.wise.model.Curriculum;
import com.u2.wise.server.ClassRecordService;
import com.u2.wise.server.CurriculumService;
import com.u2.wise.server.CurriculumStudentService;
import com.u2.wise.server.StudentService;
import com.u2.wise.server.impl.ClassRecordServiceImpl;
import com.u2.wise.server.impl.CurriculumServiceImpl;
import com.u2.wise.server.impl.CurriculumStudentServiceImpl;
import com.u2.wise.server.impl.StudentServiceImpl;
import com.u2.wise.validator.ClassRecordValidator;
import com.xiaoleilu.hutool.date.DateUtil;
import com.xiaoleilu.hutool.util.CollectionUtil;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * controller:/sutra/classRecord
 */
public class ClassRecordController extends Controller {
	
	//private static final Logger logger = LoggerFactory.getLogger(ClassRecordController.class);
	private ClassRecordService srv = enhance(ClassRecordServiceImpl.class);
	private CurriculumService csrv = enhance(CurriculumServiceImpl.class);
	private StudentService ssrv = enhance(StudentServiceImpl.class);
	private CurriculumStudentService cssrv = enhance(CurriculumStudentServiceImpl.class);



	public void index() {
		setAttr("date1", DateUtil.formatDate(new Date()));
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
		Page<Record> pages =  srv.pageList1(getParaToInt("page",1),getParaToInt("limit",10),paraMap,getPara("sort","r.start_time"),getPara("order","desc"));
		if(pages != null){
			result.put("count", pages.getTotalRow());
			renderJson(result.setSuccess("查询分页数据成功", pages.getList()));
			return;
		}
		result.put("count", 0);
		renderJson(result.setFaild("查询分页数据失败", null));
	}
	
	/*private List<Record> buildCname(List<Record> list) {
		// TODO Auto-generated method stub
			if(list!=null&&!list.isEmpty()){
				for (Record r : list) {
					
					String cid=r.get("cid");
					if(StringUtil.isNotEmpty(cid)){
						r.set("cname", csrv.getById(cid).getName());
					}
					
				}
			}
		
		return list;
	}*/

	/**
	 * 详情页
	 */
	public void toDetail(){
		ClassRecord cr = srv.getById(getPara("ID"));
		String cid=cr.getCid();
		
		setAttr("classRecord", cr);
		setAttr("curriculum_info", buildCurriculumInfo(cid));
		render("detail.html");
	}
	
	private String buildCurriculumInfo(String cid){
		String str="";
		if(StringUtil.isNotEmpty(cid)){
			Curriculum c = csrv.getById(cid);
			if(c!=null){
				///str="| 课程名称: "+c.getName()+" | 科目: "+c.getSubject()+" | 老师: "+c.getTeacherName();//+" | 学生: "+c.+" |";
				str=c.getName();
				/*Map<String, String> param=new HashMap<String, String>();
				param.put("cid", c.getId());
				List<Record> ll = cssrv.list(param);
				if(ll!=null&&!ll.isEmpty()){
					String sts="";
					for (Record record : ll) {
						if(StringUtil.isNotEmpty(sts)){
							sts+=" , ";
						}
						sts+=ssrv.getById(record.getStr("student_id")).getName();
					}
					str+=" | 学生: "+sts+" |";
				}*/
			}
		}
		return str;
	}
	
	/**
	 * 新增编辑页
	 */
	public void toForm(){
		String id = getPara("id");
		ClassRecord cr=null;
		if(StringUtil.isNotEmpty(id)){
			cr=srv.getById(id);
			setAttr("curriculum_info", buildCurriculumInfo(cr.getCid()));
		}else{
			cr=new ClassRecord();
		}
		setAttr("classRecord", cr);
		render("_form.html");
	}
	
	/**
	 * 新增或编辑记录
	 */
	@Before(ClassRecordValidator.class)
	public void saveOrUpdate(){
		ResultData result = new ResultData();
		ClassRecord classRecord = getModel(ClassRecord.class);
		String rd = DateUtil.formatDate(classRecord.getRecordData());
		String start=rd+" "+getPara("start_time");
		String end=rd+" "+getPara("end_time");
		Date s=DateUtil.parseDateTime(start);
		Date e=DateUtil.parseDateTime(end);
		
		classRecord.setStartTime(s);
		classRecord.setEndTime(e);
		
		if(classRecord.getId() == null ){
			if(srv.save(classRecord)){
				result.setSuccess("保存成功", null);
			}else{
				result.setFaild("保存失败", null);
			}
		}else{
			if(srv.update(classRecord)){
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
		if(srv.delete(getParaToInt())){
			renderJson(result.setSuccess("删除成功", null));
			return;
		}
		renderJson(result.setFaild("删除失败", null));
	}
	
}