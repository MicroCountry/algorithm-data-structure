package com.java.recursive;

public class binarySearch {
	private long[] a;
	private int nElems;
	
	public binarySearch(int max){
		a = new long[max];
		nElems = 0;
	}
	
	public int size(){
		return nElems;
	}
	
	//二分查找
	private int recFind(long searchKey,int lowerBound,int upperBound){
		int curIn;
		curIn = (lowerBound+upperBound)/2;//取中间的数组下标
		if(a[curIn]==searchKey){//如果中间值刚好是这个值
			return nElems;
		}else if(lowerBound>upperBound){//如果下界大于上界
			return nElems;
		}else{
			if(a[curIn] < searchKey){//如果中间值小于搜索值，则向上进行再次搜索
				return recFind(searchKey,curIn +1,upperBound);
			}else{//反之，向下继续搜索
				return recFind(searchKey,lowerBound,curIn -1);
			}
		}
	}
	
	//初始化数组，排序
	public void insert(long value){
		int j;
		//1.找出最邻近的一个数组元素
		for(j=0;j<nElems;j++){
			if(a[j]>value)
				break;
		}
		//将数组后面元素向后移一位
		for(int k=nElems;k>j;k--){
			a[k]=a[k-1];
		}
		
		a[j] =value;
		nElems++;
	}
	
	public void display(){
		for(int j=0;j<nElems;j++){
			System.out.print(a[j]+ ' ');
		}
		System.out.println("");
	}
}
