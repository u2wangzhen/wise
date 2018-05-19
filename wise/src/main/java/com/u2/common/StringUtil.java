package com.u2.common;

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
	public static void main(String[] args) {
		
		System.out.println(contains("123", "2"));
	}
}
