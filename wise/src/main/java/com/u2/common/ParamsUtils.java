package com.u2.common;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import com.jfinal.kit.StrKit;

public class ParamsUtils {
	   /**
	 * 从request中获得参数Map，并返回可读的Map
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, Object> getParameterMap(HttpServletRequest request) {
		// 参数Map
		Map<String, String[]> properties = request.getParameterMap();
		// 返回值Map
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Iterator<Entry<String, String[]>> entries = properties.entrySet().iterator();
		Map.Entry<String, String[]> entry;
		while (entries.hasNext()) {
			entry = (Map.Entry<String, String[]>) entries.next();
			returnMap.put((String) entry.getKey(), getEntriesItemValue(entry.getValue()));
		}
		return returnMap;
	}
	
	private static String getEntriesItemValue(Object valueObj){
		String value = "";
		if(null == valueObj){
			return value;
		}else if(valueObj instanceof String[]){
			String[] values = (String[])valueObj;
			for(int i=0;i<values.length;i++){
				value = values[i] + ",";
			}
			value = value.substring(0, value.length()-1);
		}else{
			value = (String)valueObj;
		}
		return value;
	}


	public static Map<String, String> getParameterDatatables(HttpServletRequest request) throws UnsupportedEncodingException {
		String param = request.getParameter("extra_search");
		// 返回值Map
		Map<String, String> returnMap = new HashMap<String, String>();
		if(StrKit.notBlank(param)){
			String params[] = param.split("&");
			if(params!= null && params.length>0){
				for(String p :params){
					String s[] = p.split("=");
					returnMap = setParameterMap(returnMap,s);
				}
			}
		}
		return returnMap;
	}
	
	private static Map<String,String> setParameterMap(Map<String,String> returnMap,String[] s)throws UnsupportedEncodingException{
		String key = s[0];
		String value = s.length>1?s[1]:null;
		if(value!=null){
			returnMap.put(key, URLDecoder.decode(value, "utf-8"));
		}
		
		return returnMap;
	}
	public static String getCheckboxStr(Enumeration<String> names,String ss){
		String str="";
		if(names!=null){
			
			while(names.hasMoreElements()){
				String n=names.nextElement();
				if(n.startsWith(ss)){
					if(!"".equals(str)){
						str+=",";
					}
					str+=n.substring(n.indexOf('[')+1, n.indexOf(']'));
				}
			}
		}
		return str;
	}
	public static void main(String[] args) {
		String str="[hello]";
		System.out.println(str.substring(str.indexOf('[')+1, str.indexOf(']')));
	}
}