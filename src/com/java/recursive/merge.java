package com.java.recursive;

public class merge {
	public static void merge1(int[] arrayA,int sizeA,int[] arrayB,int sizeB,int[] arrayC){
		int aDex=0,bDex=0,cDex=0;
		while(aDex<sizeA&&bDex<sizeB){//遍历比较，将最小的值放入c
			if(arrayA[aDex]<arrayB[bDex])
				arrayC[cDex++] = arrayA[aDex++];
			else
				arrayC[cDex++] = arrayB[bDex++];
		}
		
		while(aDex<sizeA)//遍历数组a剩余的元素放入c
			arrayC[cDex++] = arrayA[aDex++];
		
		while(bDex<sizeB)//遍历数组b剩余的元素放入c
			arrayC[cDex++] = arrayB[bDex++];
	}
	
	
	public static void display(int[] theArray,int size){
		for(int j=0;j<size;j++)
			System.out.println(theArray[j]);
	}
	
	public static void main(String[] args) {
		int[] a = {1,5,7,30,32};
		int[] b = {1,8,9,20,22,25,46,67,89};
		int[] c = new int[14];
		merge.merge1(a,5,b,9,c);
		merge.display(c, 14);
	}
	
	/** 
     * 归并排序 
     * 简介:将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列 
     * 时间复杂度为O(nlogn) 
     * 稳定排序方式 
     * @param nums 待排序数组 
     * @return 输出有序数组 
     */  
    public static int[] sort(int[] nums, int low, int high) {  
        int mid = (low + high) / 2;  
        if (low < high) {  
            // 左边  
            sort(nums, low, mid);  
            // 右边  
            sort(nums, mid + 1, high);  
            // 左右归并  
            merge(nums, low, mid, high);  
        }  
        return nums;  
    }  
  
    public static void merge(int[] nums, int low, int mid, int high) {  
        int[] temp = new int[high - low + 1];  
        int i = low;// 左指针  
        int j = mid + 1;// 右指针  
        int k = 0;  
  
        // 把较小的数先移到新数组中  
        while (i <= mid && j <= high) {  
            if (nums[i] < nums[j]) {  
                temp[k++] = nums[i++];  
            } else {  
                temp[k++] = nums[j++];  
            }  
        }  
  
        // 把左边剩余的数移入数组  
        while (i <= mid) {  
            temp[k++] = nums[i++];  
        }  
  
        // 把右边边剩余的数移入数组  
        while (j <= high) {  
            temp[k++] = nums[j++];  
        }  
  
        // 把新数组中的数覆盖nums数组  
        for (int k2 = 0; k2 < temp.length; k2++) {  
            nums[k2 + low] = temp[k2];  
        }  
    }  
  
	
}
