package com.u2.wise.server;

import java.util.List;
import java.util.Map;

import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.u2.wise.model.CurriculumConfig;

public interface CurriculumConfigService {

	// ---------------   系统自动生成 -请勿改动  以上区域为自行添加   -----------------
	public boolean update(CurriculumConfig curriculumConfig);
	public boolean delete(Integer id);
	public boolean save(CurriculumConfig curriculumConfig);
	public CurriculumConfig getById(String id);
	public List<Record> list(Map<String, Object> param);
	public Page<Record> pageList(int pageNum, int pageSize,Map<String, Object> paraMap,String sort,String order);
	public Page<Record> pageList1(int pageNum, int pageSize,Map<String, Object> paraMap,String sort,String order);
	// ---------------   系统自动生成 -请勿改动  以下区域为自行添加   -----------------
	
}