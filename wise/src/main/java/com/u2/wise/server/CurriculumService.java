package com.u2.wise.server;

import java.util.List;
import java.util.Map;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.u2.wise.model.Curriculum;
@Before(Tx.class)
public interface CurriculumService {

	// ---------------   系统自动生成 -请勿改动  以上区域为自行添加   -----------------
	public boolean update(Curriculum curriculum , String students);
	public boolean delete(Integer id);
	public boolean save(Curriculum curriculum, String students);
	public Curriculum getById(String id);
	public List<Record> list(Map<String, String> param);
	public Page<Record> pageList(int pageNum, int pageSize,Map<String, String> paraMap,String sort,String order);
	public Page<Record> pageList1(int pageNum, int pageSize,Map<String, String> paraMap,String sort,String order);
	// ---------------   系统自动生成 -请勿改动  以下区域为自行添加   -----------------
	public boolean update(Curriculum cc);
	
}