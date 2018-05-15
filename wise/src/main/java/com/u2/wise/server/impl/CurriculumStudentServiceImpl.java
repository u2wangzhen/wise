package com.u2.wise.server.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.SqlPara;
import com.u2.wise.model.CurriculumStudent;
import com.u2.wise.server.CurriculumStudentService;



/**
 * Service
 */
public class CurriculumStudentServiceImpl implements CurriculumStudentService{

	private static final Logger logger = LoggerFactory.getLogger(CurriculumStudentServiceImpl.class);

	// ---------------   系统自动生成 -请勿改动  以上区域为自行添加   -----------------
	
	//@Cacheable(cacheNames= ConstantsUtils.CACHE_NAME_OF_CurriculumStudent,key = "#{id}")
	 
	public CurriculumStudent getById(Integer id){
		logger.info("查询id{}", id);
		return CurriculumStudent.dao.findById(id);
	}

	//@CacheEvict(cacheNames=ConstantsUtils.CACHE_NAME_OF_CurriculumStudent, allEntries = true)
	 
	public boolean save(CurriculumStudent curriculumStudent) {
		logger.info("新增id{}", curriculumStudent);
		return curriculumStudent.save();
	}

	 
	public boolean delete(Integer id) {
		logger.info("删除id{}", id);
		return Db.update("delete from t_curriculum_student where id=?", id) == 1;
	}

	//@CacheEvict(cacheNames=ConstantsUtils.CACHE_NAME_OF_CurriculumStudent, allEntries = true)
	 
	public boolean update(CurriculumStudent curriculumStudent) {
		logger.info("更新id{}", curriculumStudent);
		return curriculumStudent.update();
	}
	
	//列表
	 
	public List<Record> list(Map<String,String> param) {
		logger.info("获取列表参数{}", param);
		return Db.find(Db.getSqlPara("curriculumStudent.list", param));
	}
	
	//分页
	 
	public Page<Record> pageList(int pageNum, int pageSize,Map<String, String> paraMap,String sort,String order) {
		logger.info("分页参数{}", paraMap);
		paraMap.remove("pageNum");
		paraMap.remove("pageSize");
		paraMap.remove("sort");
		paraMap.remove("order");
		SqlPara para = Db.getSqlPara("curriculumStudent.pageList", Kv.by("params", paraMap).set("sort", sort).set("order", order));
		return Db.paginate(pageNum, pageSize, para);
	}
	
	//分页1
	 
	public Page<Record> pageList1(int pageNum, int pageSize,Map<String, String> paraMap,String sort,String order) {
		logger.info("分页参数{}", paraMap);
		paraMap.remove("page");
		paraMap.remove("limit");
		paraMap.remove("sort");
		paraMap.remove("order");
		Kv kv = Kv.by("id=", paraMap.get("id"));
		SqlPara para = Db.getSqlPara("curriculumStudent.pageList1", Kv.by("params", kv).set("sort", sort).set("order", order));
		return Db.paginate(pageNum, pageSize, para);
	}
	
	// ---------------   系统自动生成 -请勿改动  以下区域为自行添加   -----------------

}