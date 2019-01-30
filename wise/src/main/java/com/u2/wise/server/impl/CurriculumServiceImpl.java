package com.u2.wise.server.impl;

import java.io.UnsupportedEncodingException;
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
import com.u2.wise.model.Curriculum;
import com.u2.wise.model.CurriculumStudent;
import com.u2.wise.server.CurriculumService;

/**
 * Service
 */
public class CurriculumServiceImpl implements CurriculumService {

	private static final Logger logger = LoggerFactory.getLogger(CurriculumServiceImpl.class);

	// --------------- 系统自动生成 -请勿改动 以上区域为自行添加 -----------------

	// @Cacheable(cacheNames= ConstantsUtils.CACHE_NAME_OF_Curriculum,key =
	// "#{id}")

	public Curriculum getById(String id) {
		logger.info("查询id{}", id);
		return Curriculum.dao.findById(id);
	}

	// @CacheEvict(cacheNames=ConstantsUtils.CACHE_NAME_OF_Curriculum,
	// allEntries = true)

	public boolean save(Curriculum curriculum, String students) {
		if (StringUtil.isEmpty(students)) {
			return false;
		}
		curriculum.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		logger.info("新增id{}", curriculum);
		String[] stu = students.split(",");

		for (String sid : stu) {
			CurriculumStudent cs = new CurriculumStudent();
			cs.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			cs.setCid(curriculum.getId());
			cs.setStudentId(sid);
			cs.save();
		}

		return curriculum.save();
	}

	public boolean delete(Integer id) {
		logger.info("删除id{}", id);
		return Db.update("delete from t_curriculum where id=?", id) == 1;
	}

	// @CacheEvict(cacheNames=ConstantsUtils.CACHE_NAME_OF_Curriculum,
	// allEntries = true)

	public boolean update(Curriculum curriculum, String students) {
		if (StringUtil.isEmpty(students)) {
			return false;
		}

		logger.info("更新id{}", curriculum);

		Db.update("delete from t_curriculum_student where cid=?", curriculum.getId());

		String[] stu = students.split(",");
		for (String sid : stu) {
			CurriculumStudent cs = new CurriculumStudent();
			cs.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			cs.setCid(curriculum.getId());
			cs.setStudentId(sid);
			cs.save();
		}

		return curriculum.update();
	}

	// 列表

	public List<Record> list(Map<String, Object> param) {
		logger.info("获取列表参数{}", param);
		String obj = (String) param.get("cid");
		if (obj == null) {
			param.put("cid", "");
		}
		return Db.find(Db.getSqlPara("curriculum.list", param));
	}

	// 分页

	public Page<Record> pageList(int pageNum, int pageSize, Map<String, Object> paraMap, String sort, String order) {
		logger.info("分页参数{}", paraMap);
		paraMap.remove("pageNum");
		paraMap.remove("pageSize");
		paraMap.remove("sort");
		paraMap.remove("order");
		SqlPara para = Db.getSqlPara("curriculum.pageList",
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

		if (StringUtil.isNotEmpty((String) paraMap.get("del_flag"))) {
			String df = new String((String) paraMap.get("del_flag"));
			paraMap.remove("del_flag");
			if (!"2".equals(df)) {
				kv.set("del_flag=", Integer.valueOf(df));
			}
		}
		try {
			if (StringUtil.isNotEmpty((String) paraMap.get("name"))) {

				kv.set("name", "%"+java.net.URLDecoder.decode((String) paraMap.get("name"), "UTF-8")+"%");

			}

			if (StringUtil.isNotEmpty((String) paraMap.get("subject"))) {
				kv.set("subject", java.net.URLDecoder.decode((String) paraMap.get("subject"), "UTF-8"));
			}
			
			if (StringUtil.isNotEmpty((String) paraMap.get("teacher_name"))) {
				kv.set("teacher_name", java.net.URLDecoder.decode((String) paraMap.get("teacher_name"), "UTF-8"));
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String t = (String) paraMap.get("type");
		if(StringUtil.isNotEmpty(t)){
			kv.set("type=",Integer.valueOf(t));
		}
		
		kv.set("grade=",paraMap.get("grade"));
		Kv k = Kv.by("params", kv);
		k.set("ids",paraMap.get("ids"));
		
		SqlPara para = Db.getSqlPara("curriculum.pageList1", k.set("sort", sort).set("order", order));
		return Db.paginate(pageNum, pageSize, para);
	}

	public boolean update(Curriculum cc) {
		// TODO Auto-generated method stub
		return cc.update();
	}

	// --------------- 系统自动生成 -请勿改动 以下区域为自行添加 -----------------

}