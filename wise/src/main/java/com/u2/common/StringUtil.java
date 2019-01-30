package com.u2.common;

import java.io.UnsupportedEncodingException;

public class StringUtil {

	public static boolean isNotEmpty(String str) {
		if (str != null && !"".equals(str)) {
			return true;
		}
		return false;
	}
	public static boolean isEmpty(String str) {
		return !isNotEmpty(str);
	}
	public static boolean contains(String str,String str2){
		if(isNotEmpty(str2)&&isNotEmpty(str)){
			return str.contains(str2);
		}
		return false;
	}
	
	public static String[] split(String str){
		if(isEmpty(str)){
			return null;
		}else{
			return str.split(",");
		}
	}
	
	public static String nameDecode(String str){
		String s=null;
		if(isEmpty(str)){
			return null;
		}else{
			try {
				s=java.net.URLDecoder.decode(str,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return s;
	}
	
	public static void main(String[] args) {
		
		System.out.println(contains("123", "2"));
	}
}
