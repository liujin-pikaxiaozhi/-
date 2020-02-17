package com.bawei.utils;
/**
 * 
 * @ClassName: StringUtil 
 * @Description: 字符串工具类
 * @author:lq 
 * @date: 2020年1月3日 上午9:01:13
 */
public class StringUtil {

	//判断字符串是否为空
	public static boolean isNull(String str) {
		if (null!=str&&!"".equals(str)) {
			return true;
		}else {
			return false;
		}
	}
	
	//判断字符串是不是不为空
	public static boolean isNotNull(String str) {
		if (null!=str&&!"".equals(str)) {
			return false;
		}else {
			return true;
		}
	}
	
	//判断字符串是否为邮箱
	public static boolean isEmail(String str) {
		String str_Email="^\\w+@$\\w+\\.(com|cn|net|com\\.cn)";
		boolean matches = str.matches(str_Email);
		return matches;
	}
	
	//判断字符串是否是手机号
	public static boolean isPhone(String str) {
		String str_Phone="^1[3-9]\\d{9}$";
		boolean matches = str.matches(str_Phone);
		return matches;
	}
	
	//判断源字符串是否有值，空引号和空格也算没值
		public static boolean isNotEmpty(String str) {
			
			if(null!=str && !"".equals(str)) {
				if(str.trim().length()==0) {
					return false;
				}
				return true;
			}
			return false;
		}
		
		
		public static void main(String[] args) {
			boolean number = isNumber("70");
			System.out.println(number);
		}
		
		//判断是否是数字
			public static boolean isNumber(String str) {
				String reg_str="^([1-9][0-9]*)|((([0-9])|([1-9]\\d+))\\.\\d)$";
				boolean matches = str.matches(reg_str);
				return matches;
			}
	
}
