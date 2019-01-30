package com.u2.wise.validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.util.StringUtils;
import com.jfinal.aop.Enhancer;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.validate.Validator;
import com.u2.common.ResultData;
import com.u2.wise.server.TeacherService;
import com.u2.wise.server.impl.TeacherServiceImpl;

public class TearcherValidator extends Validator{
	private TeacherService srv = Enhancer.enhance(TeacherServiceImpl.class);

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		String name=c.getPara("teacher.name");
		String id=c.getPara("teacher.id");
		if(StringUtils.isEmpty(id)){
			Map<String, Object> param=new HashMap<String, Object>();
			param.put("name2", name);
			List<Record> list = srv.list(param);
			if(list!=null&&!list.isEmpty()){
				addError("msg", "名称重复！");
			}
		}
	}

	@Override
	protected void handleError(Controller c) {
		// TODO Auto-generated method stub
		ResultData rd=new ResultData();
		rd.setFaild("保存失败，名称重复！", null);
		c.renderJson(rd);
	}

}
