package com.bawei.utils;

import java.util.HashSet;
import java.util.Random;

public class RandomUtil {

	//返回某个时间段的数据（如返回年龄在1-120之间）
	public static int getRanOnTime(int max,int min) {
		Random random = new Random();
		return random.nextInt(max-min+1)+min;
	}
	
	//随机获得英文字符
	public static char getRandomChar() {
		Random random=new Random();
		//获得开始字符的ASCII码
		int startChar='a'+0;
		
		return 	(char) (random.nextInt(26)+startChar);

	}
	
	
	//返回4位验证码，可包含数字和字母
	public static String getMEString() {
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			int nextInt = random.nextInt(36);
			if (nextInt>10) {
				buffer.append(getRandomChar());
			}else {
				buffer.append(getRandomNum());
			}
		}
		return buffer.toString();
	}
	
	
	//获得随机0-9之间的数字
		public static int getRandomNum() {
			Random random=new Random();
			int nextInt = random.nextInt(10);
			return nextInt;
		}
		
		//获得随机0-9之间的指定个数的数字
		public static int[] getRandomNum(int subs) {
			int [] arr=new int[subs];
			for(int i=0;i<subs;i++){
				int randomNum = getRandomNum();
				arr[i]=randomNum;
			}
			return arr;
		}
		
		//获得一个区间内的随机数字 3   15
		public static int getRandomNum(int min,int max) {
			Random random=new Random();
			
			return random.nextInt(max-min+1)+min;
			
		}

		//获得一个区间内的n个不会重复的随机数字 3   15
		public static int[] getRandomNum(int min,int max,int subs) {
			int [] arr=new int[subs];
			HashSet<Integer> set=new HashSet<Integer>();
			//如果集合的长度小于需要的随机数的个数
			while(set.size()<subs) {
				set.add(getRandomNum(min,max));
			}
			
			//个数够了  把 set集合中的值给  arr数组
			int i=0;
			for (Integer integer : set) {
				arr[i]=integer;
				i++;
			}
			return arr;
					
		}
	
}
