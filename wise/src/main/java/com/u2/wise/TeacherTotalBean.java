package com.u2.wise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TeacherTotalBean {

	private String name;
	
	private Double hours=new Double(0);
	private int cs=0;
	private Map<String,CurriculumTotalBean> currMap;
	private List<CurriculumTotalBean> currList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getHours() {
		return hours;
	}
	public void setHours(Double hours) {
		this.hours = hours;
	}
	public int getCs() {
		return cs;
	}
	public void setCs(int cs) {
		this.cs = cs;
	}
	
	public void putCurrMap(String key, CurriculumTotalBean ctb) {
		if(currMap==null){
			currMap=new HashMap<String, CurriculumTotalBean>();
			currList=new ArrayList<CurriculumTotalBean>();
		}else{
			String name=ctb.getName();
			currMap.put(name, ctb);
			currList.add(ctb);
		}
	}
	public Map<String, CurriculumTotalBean> getCurrMap() {
		return currMap;
	}
	public void setCurrMap(Map<String, CurriculumTotalBean> currMap) {
		this.currMap = currMap;
	}
	public void setCurrList(List<CurriculumTotalBean> currList) {
		this.currList = currList;
	}
	public List<CurriculumTotalBean> getCurrList() {
		return currList;
	}
	
	
}
