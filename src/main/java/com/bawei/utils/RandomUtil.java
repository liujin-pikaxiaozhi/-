package com.bawei.utils;

import java.util.HashSet;
import java.util.Random;

public class RandomUtil {

	//����ĳ��ʱ��ε����ݣ��緵��������1-120֮�䣩
	public static int getRanOnTime(int max,int min) {
		Random random = new Random();
		return random.nextInt(max-min+1)+min;
	}
	
	//������Ӣ���ַ�
	public static char getRandomChar() {
		Random random=new Random();
		//��ÿ�ʼ�ַ���ASCII��
		int startChar='a'+0;
		
		return 	(char) (random.nextInt(26)+startChar);

	}
	
	
	//����4λ��֤�룬�ɰ������ֺ���ĸ
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
	
	
	//������0-9֮�������
		public static int getRandomNum() {
			Random random=new Random();
			int nextInt = random.nextInt(10);
			return nextInt;
		}
		
		//������0-9֮���ָ������������
		public static int[] getRandomNum(int subs) {
			int [] arr=new int[subs];
			for(int i=0;i<subs;i++){
				int randomNum = getRandomNum();
				arr[i]=randomNum;
			}
			return arr;
		}
		
		//���һ�������ڵ�������� 3   15
		public static int getRandomNum(int min,int max) {
			Random random=new Random();
			
			return random.nextInt(max-min+1)+min;
			
		}

		//���һ�������ڵ�n�������ظ���������� 3   15
		public static int[] getRandomNum(int min,int max,int subs) {
			int [] arr=new int[subs];
			HashSet<Integer> set=new HashSet<Integer>();
			//������ϵĳ���С����Ҫ��������ĸ���
			while(set.size()<subs) {
				set.add(getRandomNum(min,max));
			}
			
			//��������  �� set�����е�ֵ��  arr����
			int i=0;
			for (Integer integer : set) {
				arr[i]=integer;
				i++;
			}
			return arr;
					
		}
	
}
