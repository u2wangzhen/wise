package com.u2.wise.server.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.SqlPara;
import com.u2.common.StringUtil;
import com.u2.wise.model.ClassRecord;
import com.u2.wise.server.ClassRecordService;
import com.xiaoleilu.hutool.date.DatePattern;
import com.xiaoleilu.hutool.date.DateTime;
import com.xiaoleilu.hutool.date.DateUtil;

/**
 * Service
 */
public class ClassRecordServiceImpl implements ClassRecordService {

	private static final Logger logger = LoggerFactory.getLogger(ClassRecordServiceImpl.class);

	// --------------- 系统自动生成 -请勿改动 以上区域为自行添加 -----------------

	// @Cacheable(cacheNames= ConstantsUtils.CACHE_NAME_OF_ClassRecord,key =
	// "#{id}")

	public ClassRecord getById(String id) {
		logger.info("查询id{}", id);
		return ClassRecord.dao.findById(id);
	}

	// @CacheEvict(cacheNames=ConstantsUtils.CACHE_NAME_OF_ClassRecord,
	// allEntries = true)

	public boolean save(ClassRecord classRecord) {
		classRecord.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		logger.info("新增id{}", classRecord);
		return classRecord.save();
	}

	public boolean delete(Integer id) {
		logger.info("删除id{}", id);
		return Db.update("delete from t_class_record where id=?", id) == 1;
	}

	// @CacheEvict(cacheNames=ConstantsUtils.CACHE_NAME_OF_ClassRecord,
	// allEntries = true)

	public boolean update(ClassRecord classRecord) {
		logger.info("更新id{}", classRecord);
		return classRecord.update();
	}

	// 列表

	public List<Record> list(Map<String, Object> param) {
		logger.info("获取列表参数{}", param);
		String date=(String) param.get("date1");
		if(StringUtil.isNotEmpty(date)){
			Date d=null;
			if("now".equals(date)){
				d=new Date();
			}else{
				d = DateUtil.parse(date, DatePattern.NORM_DATE_PATTERN);
			}
			
			param.put("start_time", DateUtil.beginOfDay(d).toString());
			param.put("end_time", DateUtil.endOfDay(d).toString());
			param.remove("date1");
		}
		
		
		return Db.find(Db.getSqlPara("classRecord.list", param));
	}

	public List<Record> studentClassHour(Map<String, Object> param) {
		// TODO Auto-generated method stub
		if (param.get("date") == null) {

			param.put("start_time", DateUtil.beginOfMonth(new Date()).toString());
			param.put("end_time", DateUtil.endOfMonth(new Date()).toString());
		} else {
			String d = (String) param.get("date");
			DateTime dd = DateUtil.parse(d + "-1", DatePattern.NORM_DATE_PATTERN);
			param.put("start_time", DateUtil.beginOfMonth(dd).toString());
			param.put("end_time", DateUtil.endOfMonth(dd).toString());
		}

		return Db.find(Db.getSqlPara("classRecord.student_CH", param));
	}
	
	public List<Record> calendarList(String string) {
		// TODO Auto-generated method stub
		Map<String, String> param=new HashMap<String, String>();
		DateTime d = DateUtil.parse(string, "yyyy");
		
		param.put("start_time", DateUtil.beginOfYear(d).toString());
		param.put("end_time", DateUtil.endOfYear(d).toString());
		return Db.find(Db.getSqlPara("classRecord.calendar_CH", param));
	}

	public List<Record> teacherClassHour(Map<String, Object> param) {
		// TODO Auto-generated method stub
		if (param.get("date") == null) {

			param.put("start_time", DateUtil.beginOfMonth(new Date()).toString());
			param.put("end_time", DateUtil.endOfMonth(new Date()).toString());
		} else {
			String d = (String) param.get("date");
			DateTime dd = DateUtil.parse(d + "-1", DatePattern.NORM_DATE_PATTERN);
			param.put("start_time", DateUtil.beginOfMonth(dd).toString());
			param.put("end_time", DateUtil.endOfMonth(dd).toString());
		}

		return Db.find(Db.getSqlPara("classRecord.teacher_CH", param));
	}

	public List<Record> curriculumClassHour(Map<String, Object> param) {
		// TODO Auto-generated method stub
		if (param.get("date") == null) {

			param.put("start_time", DateUtil.beginOfMonth(new Date()).toString());
			param.put("end_time", DateUtil.endOfMonth(new Date()).toString());
		} else {
			String d = (String) param.get("date");
			DateTime dd = DateUtil.parse(d + "-1", DatePattern.NORM_DATE_PATTERN);
			param.put("start_time", DateUtil.beginOfMonth(dd).toString());
			param.put("end_time", DateUtil.endOfMonth(dd).toString());
		}

		return Db.find(Db.getSqlPara("classRecord.curriculum_CH", param));
	}
	
	// 分页

	public Page<Record> pageList(int pageNum, int pageSize, Map<String, Object> paraMap, String sort, String order) {
		logger.info("分页参数{}", paraMap);
		paraMap.remove("pageNum");
		paraMap.remove("pageSize");
		paraMap.remove("sort");
		paraMap.remove("order");
		SqlPara para = Db.getSqlPara("classRecord.pageList",
				Kv.by("params", paraMap).set("sort", sort).set("order", order));
		return Db.paginate(pageNum, pageSize, para);
	}

	// 分页1

	public Page<Record> pageList1(int pageNum, int pageSize, Map<String, Object> paraMap, String sort, String order) {
		logger.info("分页参数{}", paraMap);
		paraMap.remove("page");
		paraMap.remove("limit");
		paraMap.remove("sort");
		paraMap.remove("order");
		Kv kv = Kv.by("id=", paraMap.get("id"));
		
		if(paraMap.get("cname")!=null){
			try {
				kv.set("c.name", "%"+java.net.URLDecoder.decode((String) paraMap.get("cname"), "UTF-8")+"%");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Kv k = Kv.by("params", kv);
		if (StringUtil.isNotEmpty((String) paraMap.get("date1"))) {
			String d1 = paraMap.get("date1") + " 00:00:00";
			k.set("date1", DateUtil.parse(d1, DatePattern.NORM_DATETIME_PATTERN));
			String d2 = paraMap.get("date1") + " 23:59:59";
			k.set("date2", DateUtil.parse(d2, DatePattern.NORM_DATETIME_PATTERN));
		}else if (StringUtil.isNotEmpty((String) paraMap.get("month1"))) {
			String d=(String) paraMap.get("month1");
			DateTime dd = DateUtil.parse(d + "-1", DatePattern.NORM_DATE_PATTERN);
			k.set("date1", DateUtil.beginOfMonth(dd).toString());
			k.set("date2", DateUtil.endOfMonth(dd).toString());
		}

		SqlPara para = Db.getSqlPara("classRecord.pageList1", k.set("sort", sort).set("order", order));
		return Db.paginate(pageNum, pageSize, para);
	}

	

	

	// --------------- 系统自动生成 -请勿改动 以下区域为自行添加 -----------------

}