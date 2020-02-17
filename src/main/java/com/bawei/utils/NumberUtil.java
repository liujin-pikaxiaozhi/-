package com.bawei.utils;
/**
 * 百分比计算方法，返回值只要整数
 * @author 刘瑾
 *
 */
public class NumberUtil {

	public static int getPercent(int current, int total){
		
		Double sum=(current*0.1)/(total*0.1)*100;
		String str = sum.toString();
		String string = str.substring(str.lastIndexOf(".")+1);
		if (string.charAt(0)>='0'&&string.charAt(0)<='4') {
			return (int) ((current*0.1)/(total*0.1)*100);
		}
		return (int) (sum+1);
	}
	
}
