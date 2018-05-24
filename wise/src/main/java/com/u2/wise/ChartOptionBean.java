package com.u2.wise;

import java.util.ArrayList;

public class ChartOptionBean {

	
	private String title;
	
	private ArrayList<String> legend;
	
	private ArrayList<String> xAxis;
	
	private ArrayList<chartSeriesBean> series;
	
	
	
	

	public String getTitle() {
		return title;
	}

	public ChartOptionBean setTitle(String title) {
		this.title = title;
		return this;
	}

	public ArrayList<String> getLegend() {
		return legend;
	}

	public ChartOptionBean setLegend(ArrayList<String> legend) {
		this.legend = legend;
		return this;
	}

	public ArrayList<String> getxAxis() {
		return xAxis;
	}

	public ChartOptionBean setxAxis(ArrayList<String> xAxis) {
		this.xAxis = xAxis;
		return this;
	}

	public ArrayList<chartSeriesBean> getSeries() {
		return series;
	}

	public ChartOptionBean setSeries(ArrayList<chartSeriesBean> series) {
		this.series = series;
		return this;
	}

	public ChartOptionBean setLegend(String str) {
		// TODO Auto-generated method stub
		if(this.legend==null){
			legend=new ArrayList<String>();
		}
		legend.add(str);
		return this;
	}

	public ChartOptionBean setxAxis(String str) {
		// TODO Auto-generated method stub
		if(this.xAxis==null){
			xAxis=new ArrayList<String>();
		}
		xAxis.add(str);
		return this;
	}

	public ChartOptionBean setData(int index,String type,Object obj) {
		// TODO Auto-generated method stub
		if(this.series==null){
			series=new ArrayList<chartSeriesBean>();
		}
		if(series.size()==index){
			series.add(new chartSeriesBean().setName(this.legend.get(index)).setType(type).setData(obj));
		}else{
			series.get(index).setData(obj);
		}
		
		
		return this;
	}
	
}

