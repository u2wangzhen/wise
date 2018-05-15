package com.u2.common;

import java.util.HashMap;

public class ResultData extends HashMap<String,Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResultData(){
		this.put("code", 1);
	}
	
	public ResultData setSuccess(String message,Object data){
		this.put("code", 1);
		this.put("msg", message);
		this.put("data", data);
		return this;
	}
	
	public ResultData setSuccess(int code,String message,Object data){
		this.put("code", code);
		this.put("msg", message);
		this.put("data", data);
		return this;
	}
	
	public ResultData setFaild(String message,Object data){
		this.put("code", 0);
		this.put("msg", message);
		this.put("data", data);
		return this;
	}
	
	public ResultData setFaild(int code,String message,Object data){
		this.put("code", code);
		this.put("msg", message);
		this.put("data", data);
		return this;
	}
}