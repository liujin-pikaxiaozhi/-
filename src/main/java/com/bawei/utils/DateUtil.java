package com.bawei.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	private static SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	//根据生日计算年龄
	public static int GetAgeBrithday(String birthday) throws ParseException {
		//获得日历挂件
		Calendar calendar = Calendar.getInstance();
		//从日历挂件中获得当前日期
		//获得年
		int year = calendar.get(Calendar.YEAR);
		//获得月
		int monday = calendar.get(Calendar.MONDAY);
		//获得日
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		//把生日给日历控件
		Date date = sdf.parse(birthday);
		calendar.setTime(date);
		int birYear = calendar.get(Calendar.YEAR);
		int birMonday = calendar.get(Calendar.MONDAY);
		int birDay = calendar.get(Calendar.DAY_OF_MONTH);
		int age=year-birYear;
		//如果当前月份大于生日月份，年龄+1
		if (monday>birMonday) {
			age++;
		}
		//如果当前日期大于生日日期，年龄+1
		if (day>birDay) {
			age++;
		}
		return age;
	}
	


	
	//根据生日计算年龄
	public static int getAgeByBirthday(Date birthday) {
		//获得日历控件
		Calendar calendar=Calendar.getInstance();
		//从日历控件中获得当前的年月日
		int year = calendar.get(Calendar.YEAR);
		int mouth = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		//把生日赋给日历控件  方便操作
		calendar.setTime(birthday);
		int birYear = calendar.get(Calendar.YEAR);
		int birMouth = calendar.get(Calendar.MONTH);
		int birDay = calendar.get(Calendar.DAY_OF_MONTH);
		int age=year-birYear;
		//如果当前月份大于生日月份  年龄+1
		if(mouth>birMouth) {
			age++;
		}
		//月份相等如果当前日期大于生日日期  年龄+1
		if(birMouth==mouth && day>birDay) {
			age++;
		}
		
		return age;
		
	}
	//放的重载 计算年龄
	public static int getAgeByBirthday(String birthday) {
		Date birDate=null;
		try {
			birDate = sdf.parse("1992-1-1");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getAgeByBirthday(birDate);
	}
	
	//计算两个日期相差天数
	public static int getDayNum(Date date1,Date date2) {
		
		//一天多少毫秒
		Long time=24L*60*60*1000;
		//获得结束时间的毫秒
		long time1 = date2.getTime();
		//获得开始时间的毫秒
		long time2 = date1.getTime();
		//两者相减  =相差的毫秒
		//相差的毫秒/一天多少毫秒=天
				
		if(time1>time2) {
			return (int) ((time1-time2)/time);
		}else {
			return (int) ((time2-time1)/time);
		}
		
	}
	//方法的重载  获得两者相差天数
	public static int getDayNum(String date1,String date2) {
		try {
			return getDayNum(sdf.parse(date1), sdf.parse(date2));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	//根据给定的时间  获得当月的第一天的0时0分0秒  2019-12-12 == 2012-12-1 0:0:0
	public static Date getDateByInitMouth(Date date) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		//当当前时间的日历控件的日期设置成1
		calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		
		return calendar.getTime();//返回设置之后的时间
		
	}
	
	//获得当月的最后一秒
	public static Date getDateByEndMouth(Date date) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);//2012-9-10
		//当前月份+1
		calendar.add(Calendar.MONTH, 1);//2012-10-10
		//通过调用上面的方法  获得当月开始时间
		Date dateByInitMouth = getDateByInitMouth(calendar.getTime());//2012-10-1 0:0:0
		calendar.setTime(dateByInitMouth);
		calendar.add(Calendar.SECOND, -1);
		return calendar.getTime();
		
	}
	
	//通过当前时间来获得24小时前的时间
		public static String getIntervalDate(long millis) {
			//获得系统当前毫秒数
			Date date = new Date();
			long time = date.getTime();
			//获得需要得到当前系统的毫秒
			long time1 = time-millis;
			//通过获得的毫秒得到时间
			date.setTime(time1);
			String format = sdf2.format(date);
			return format;
			
		}
	
}
