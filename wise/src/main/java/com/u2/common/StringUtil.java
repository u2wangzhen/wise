package com.u2.common;

public class StringUtil {

	public static boolean isNotEmpty(String str) {
		if (str != null && !"".equals(str)) {
			return true;
		}
		return false;
	}
}
