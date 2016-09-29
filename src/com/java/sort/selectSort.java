package com.java.sort;

public class selectSort {
	//选择排序
	//每次选择最小的数放在首部
		public void selectSort(int [] a) {
			int n = a.length;
			for(int k=0; k<n-1; k++) {
				int min = k;
				for(int i=k+1; i<n; i++) {
					if(a[i] < a[min]) {
						min = i;//寻找最小的元素下标
					}
				}
				if(k != min) {//将最小值放在首部
					int temp = a[k];
					a[k] = a[min];
					a[min] = temp;
				}
			}
		}

}
