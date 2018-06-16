package com.u2.wise;
import java.util.ArrayList;
import java.util.List;

import com.jfinal.plugin.activerecord.Record;

public class CurriculumTotalBean {

	private String name;
	
	private Double hours=new Double(0);
	
	private int cs=0;
	private Double total=new Double(0);
	private Double salary=new Double(0);
	private List<Record> crlist;

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

	public List<Record> getCrlist() {
		return crlist;
	}

	public void setCrlist(List<Record> crlist) {
		this.crlist = crlist;
	}
	public void addCrlist(Record r) {
		if(crlist==null){
			crlist=new ArrayList<Record>();
		}
		crlist.add(r);
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
}
