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
import com.u2.wise.model.StudentPayment;
import com.u2.wise.server.StudentPaymentService;



/**
 * Service
 */
public class StudentPaymentServiceImpl implements StudentPaymentService{

	private static final Logger logger = LoggerFactory.getLogger(StudentPaymentServiceImpl.class);

	// ---------------   系统自动生成 -请勿改动  以上区域为自行添加   -----------------
	
	//@Cacheable(cacheNames= ConstantsUtils.CACHE_NAME_OF_StudentPayment,key = "#{id}")
	 
	public StudentPayment getById(Integer id){
		logger.info("查询id{}", id);
		return StudentPayment.dao.findById(id);
	}

	//@CacheEvict(cacheNames=ConstantsUtils.CACHE_NAME_OF_StudentPayment, allEntries = true)
	 
	public boolean save(StudentPayment studentPayment) {
		logger.info("新增id{}", studentPayment);
		return studentPayment.save();
	}

	 
	public boolean delete(Integer id) {
		logger.info("删除id{}", id);
		return Db.update("delete from t_student_payment where id=?", id) == 1;
	}

	//@CacheEvict(cacheNames=ConstantsUtils.CACHE_NAME_OF_StudentPayment, allEntries = true)
	 
	public boolean update(StudentPayment studentPayment) {
		logger.info("更新id{}", studentPayment);
		return studentPayment.update();
	}
	
	//列表
	 
	public List<Record> list(Map<String,String> param) {
		logger.info("获取列表参数{}", param);
		return Db.find(Db.getSqlPara("studentPayment.list", param));
	}
	
	//分页
	 
	public Page<Record> pageList(int pageNum, int pageSize,Map<String, String> paraMap,String sort,String order) {
		logger.info("分页参数{}", paraMap);
		paraMap.remove("pageNum");
		paraMap.remove("pageSize");
		paraMap.remove("sort");
		paraMap.remove("order");
		SqlPara para = Db.getSqlPara("studentPayment.pageList", Kv.by("params", paraMap).set("sort", sort).set("order", order));
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
		SqlPara para = Db.getSqlPara("studentPayment.pageList1", Kv.by("params", kv).set("sort", sort).set("order", order));
		return Db.paginate(pageNum, pageSize, para);
	}
	
	// ---------------   系统自动生成 -请勿改动  以下区域为自行添加   -----------------

}