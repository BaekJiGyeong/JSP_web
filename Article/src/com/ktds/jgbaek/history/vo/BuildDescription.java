package com.ktds.jgbaek.history.vo;

public class BuildDescription {
	public static String get(String format, String ...args) {
		//...은 배열이다.
		String desc = String.format(format, args);
		return desc;
	}

}
