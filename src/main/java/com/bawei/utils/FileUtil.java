package com.bawei.utils;

import java.io.File;

/**
 * 
 * @ClassName: FileUtil 
 * @Description: 文件工具�?
 * @author:lq 
 * @date: 2020�?1�?2�? 上午11:08:02
 */
public class FileUtil {
	
	//获取文件扩展�?
	public static String getSuffix(String fileName) {
		//a.ba.jpg   jpg
		if(fileName!=null && !"".equals(fileName)){
			//获得.小标
			int lastIndexOf = fileName.lastIndexOf(".");
			return fileName.substring(lastIndexOf+1);
		}else {
			return "不是有效文件";
		}
	}
	
	//### 删除文件
//如果是目录，则下面的文件和所有子目录中的文件都要删除
//使用递归。涉及内容�?�判断目录的存在性，判断是否为目录或文件，删�?
	public static void deleteFile(File file) {
		//判断是否是文件夹
		if(file.isDirectory()) {
			//获得此文件夹下的�?有的文件或�?�文件夹
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				//递归删除文件
				deleteFile(file2);
			}
			file.delete();
		}else {
			//不是文件�?   就是文件
			file.delete();//直接删除
		}
		
	}
	//获取操作系统用户目录
	public static String getSystemUserHome() {
		return System.getProperty("user.home");
	}

}
