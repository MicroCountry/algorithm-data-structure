package com.java.sort;

import java.util.Arrays;

public class QuickSort {
	
	private static int partition(int array[],int low,int hight){
		int key = array[low];
		while(low<hight){
			while(low<hight&&array[hight]>=key)//从最高位开始寻找直到元素的值小于最低位的值
				hight--;
			array[low] = array[hight];//将此高位的值付给最低位
			while(low<hight&&array[low]<=key)//从最低位开始寻找元素的值直到大于最低位的值
				low++;
			array[hight]= array[low];//将找到的低位的值付给此前的高位
		
		/*	while(low<hight&&array[low]<=key)//从最低位开始寻找元素的值直到大于最低位的值
				low++;
			array[low]= key;//将找到的低位的值付给此前的高位	
			key=array[hight];
			while(low<hight&&array[hight]>=key)//从最高位开始寻找直到元素的值小于最低位的值
				hight--;
			array[hight] =key;//将此高位的值付给最低位
*/			
		}
		array[low] = key;
		return low;
	}
	
	public static void sort(int[] array,int low,int hight){
		if(low<hight){
			System.out.println(Arrays.toString(array));
			int result = partition(array,low,hight);//寻找标记位
			System.out.println(Arrays.toString(array));
			System.out.println("low:"+low+" result:"+result+" hight:"+hight);
			sort(array,low,result-1);//排序左边的数组元素
			sort(array,result+1,hight);//排序右边的数组元素
		}
	}
	
	public static void display(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]);
			System.out.print(" ");
		}
	}
	
	public static void main(String[] args) {
		int [] array ={34,56,1,9,23,5,34,2,7,90};
		QuickSort.sort(array, 0, array.length-1);
		QuickSort.display(array);
	}
}
