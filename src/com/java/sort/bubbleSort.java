package com.java.sort;

public class bubbleSort {
	public void bubbleSort(int[] array) {  
        int temp;  
        // 第一层循环： 表明要比较的次数，比如list.count个数，肯定要比较count-1次  
        for (int i = 0; i < array.length - 1; i++) {  
            // list.count-1：取数据最后一个数下标，  
            // j>i: 从后往前的的下标一定大于从前往后的下标，否则就超越了。  
            for (int j = array.length - 1; j > i; j--) {  
                // 如果前面一个数大于后面一个数则交换  
                if (array[j - 1] > array[j]) {  
                    temp = array[j - 1];  
                    array[j - 1] = array[j];  
                    array[j] = temp;  
                }  
            }  
        }  
    }  
}
