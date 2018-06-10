package com.u2.wise.validator;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.aop.Enhancer;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.validate.Validator;
import com.u2.common.ResultData;
import com.u2.wise.server.ClassRecordService;
import com.u2.wise.server.impl.ClassRecordServiceImpl;
import com.xiaoleilu.hutool.date.DateUtil;

public class ClassRecordValidator extends Validator{
	private ClassRecordService srv =  Enhancer.enhance(ClassRecordServiceImpl.class);

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		String st=c.getPara("start_time");
		String et=c.getPara("end_time");
		String rd = c.getPara("classRecord.record_data");
		String cid=c.getPara("classRecord.cid");
		String start=rd+" "+st;
		String end=rd+" "+et;
		Date s=DateUtil.parseDateTime(start);
		Date e=DateUtil.parseDateTime(end);
		if(s.getTime()>=e.getTime()){
			addError("msg", "开始时间晚于或者等于结束时间！");
		}else{
			Map<String, String> param=new HashMap<String, String>();
			param.put("start1", start);
			param.put("end1", end);
			param.put("cid", cid);
			List<Record> list = srv.list(param);
			if(list!=null&&!list.isEmpty()){
				addError("msg", "课时添加重复！");
			}
		}
		
		
		
	}

	@Override
	protected void handleError(Controller c) {
		// TODO Auto-generated method stub
		ResultData rd=new ResultData();
		rd.setFaild(c.getAttr("msg","操作失败！"), null);
		c.renderJson(rd);
	}

}
