package com.u2.wise.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import com.u2.common.ParamsUtils;
import com.u2.wise.ChartOptionBean;
import com.u2.wise.server.ClassRecordService;
import com.u2.wise.server.impl.ClassRecordServiceImpl;
import com.xiaoleilu.hutool.date.DatePattern;
import com.xiaoleilu.hutool.date.DateUtil;

public class ChartsController extends Controller{
	private ClassRecordService srv = enhance(ClassRecordServiceImpl.class);

	public void studentClassHour(){
		Map<String, Object> paraMap = ParamsUtils.getParameterMap(getRequest());
		List<Record> list =  srv.studentClassHour(paraMap);
		ChartOptionBean cob=new ChartOptionBean();
		String d = DateUtil.format(new Date(), "yyyy年MM月");
		cob.setTitle(d+"学生课时统计图").setLegend("课时（h）");
		if(list!=null&&!list.isEmpty()){
		
			for (Record record : list) {
				cob.setxAxis(record.getStr("student_name"));
				cob.setData(0,"bar",record.get("total"));
			}

		}
		renderJson(cob);
	}
	
	public void teacherClassHour(){
		Map<String, Object> paraMap = ParamsUtils.getParameterMap(getRequest());
		List<Record> list =  srv.teacherClassHour(paraMap);
		ChartOptionBean cob=new ChartOptionBean();
		String d = DateUtil.format(new Date(), "yyyy年MM月");
		cob.setTitle(d+"教师课时统计图").setLegend("课时（h）");
		if(list!=null&&!list.isEmpty()){
		
			for (Record record : list) {
				cob.setxAxis(record.getStr("teacher_name"));
				cob.setData(0,"bar",record.get("total"));
			}

		}
		renderJson(cob);
	}
	
	public void curriculumClassHour(){
		Map<String, Object> paraMap = ParamsUtils.getParameterMap(getRequest());
		List<Record> list =  srv.curriculumClassHour(paraMap);
		ChartOptionBean cob=new ChartOptionBean();
		String d = DateUtil.format(new Date(), "yyyy年MM月");
		cob.setTitle(d+"课程课时统计图").setLegend("课时（h）");
		if(list!=null&&!list.isEmpty()){
		
			for (Record record : list) {
				cob.setxAxis(record.getStr("name"));
				cob.setData(0,"bar",record.get("total"));
			}

		}
		renderJson(cob);
	}
	
	public void calendarClassHour(){
		List<String[]> ll=new ArrayList<String[]>();
		List<Record> list =srv.calendarList("2019");
		if(list!=null&&!list.isEmpty()){
			
			for (Record r : list) {
				String[] s=new String[2];
				Date date = r.getDate("record_data");
				String d=DateUtil.format(date, DatePattern.NORM_DATE_PATTERN);
				String sl=r.getStr("ks");
				s[0]=d;
				s[1]=sl;
				ll.add(s);
			}
			
			
		}
		renderJson(ll);
	}
}
