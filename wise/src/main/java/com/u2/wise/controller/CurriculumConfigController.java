package com.u2.wise.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.u2.common.ParamsUtils;
import com.u2.common.ResultData;
import com.u2.common.StringUtil;
import com.u2.wise.model.CurriculumConfig;
import com.u2.wise.server.CurriculumConfigService;
import com.u2.wise.server.impl.CurriculumConfigServiceImpl;
import com.xiaoleilu.hutool.util.CollectionUtil;

import com.jfinal.core.Controller;

/**
 * controller:/sutra/curriculumConfig
 */
public class CurriculumConfigController extends Controller {
	
	//private static final Logger logger = LoggerFactory.getLogger(CurriculumConfigController.class);
	private CurriculumConfigService srv = enhance(CurriculumConfigServiceImpl.class);

	public void index() {
		this.render("index.html");
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
		Page<Record> pages =  srv.pageList1(getParaToInt("page",1),getParaToInt("limit",10),paraMap,getPara("sort","id"),getPara("order","desc"));
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
		setAttr("curriculumConfig", srv.getById(getPara()));
		render("detail.html");
	}
	
	/**
	 * 新增编辑页
	 */
	public void toForm(){
		String cid = getPara("cid");
		CurriculumConfig cc=new CurriculumConfig();
		if(StringUtil.isNotEmpty(cid)){
			Map<String, String> m=new HashMap<String, String>();
			m.put("cid", cid);
			List<Record> list = srv.list(m);
			if(list!=null&&!list.isEmpty()){
				cc=srv.getById(list.get(0).get("id").toString());
			}else{
				cc.setCid(cid);
			}
		}
		setAttr("curriculumConfig", cc);
		render("_form.html");
	}
	
	/**
	 * 新增或编辑记录
	 */
	public void saveOrUpdate(){
		ResultData result = new ResultData();
		CurriculumConfig curriculumConfig = getModel(CurriculumConfig.class);
		if(curriculumConfig.getId() == null ){
			if(srv.save(curriculumConfig)){
				result.setSuccess("保存成功", null);
			}else{
				result.setFaild("保存失败", null);
			}
		}else{
			if(srv.update(curriculumConfig)){
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