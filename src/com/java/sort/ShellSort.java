package com.java.sort;

import java.util.Arrays;

public class ShellSort {
	/**
	 * 以一定的间隔先进行排序
	 * @param array
	 */
	public static void sort(int[] array){
		int i,j,tmp;
		int len=array.length;
		int h=1;
		while(h<len/3)
			h=h*3+1;//取出最大的间隔值
		
		while(h>0){//从最大的间隔值开始排序直到为 1
			for(i=h;i<len;i++){
				tmp=array[i];
				j=i;
				while(j>h-1&&array[j-h]>=tmp){ //使用插入排序对间隔的数进行排序，交换，
					array[j]=array[j-h];
					j -= h; 
				}
				array[j] = tmp;
				System.out.println(Arrays.toString(array));
			}
			h=(h-1)/3;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,21,5,56,3,123,54,23,45,47,49,50,2,9,11,17,77,67,57,44,34,35,99,12,100,89,78,479};
		System.out.println(Arrays.toString(a));
		ShellSort.sort(a);
		System.out.println("-----begin-----");
		System.out.println(Arrays.toString(a));
		System.out.println("------end-----");
	}
}
