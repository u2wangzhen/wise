package com.u2.wise;

import java.util.ArrayList;

public class chartSeriesBean{
	private String name;
	private String type;
	private ArrayList<Object> data;
	public String getName() {
		return name;
	}
	public chartSeriesBean setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getType() {
		return type;
	}
	public chartSeriesBean setType(String type) {
		this.type = type;
		return this;
	}
	public ArrayList<Object> getData() {
		return data;
	}
	public chartSeriesBean setData(ArrayList<Object> data) {
		this.data = data;
		return this;
	}
	public chartSeriesBean setData(Object obj) {
		// TODO Auto-generated method stub
		if(this.data==null){
			data=new ArrayList<Object>();
		}
		data.add(obj);
		return this;
	}
	
}