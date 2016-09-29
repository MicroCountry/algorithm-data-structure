package com.java.recursive;

public class towers {
	static int nDisks = 4;
	
	public static void main(String[] args){
		doTowers(nDisks,'A','B','C');
	}
	
	/*
	 * 算法逻辑  1.借助 C将A 上 1 到 n-1的盘子移动到B
	 * 		 2.借助A将B 上的盘子移动到C
	 */
	//doTowers(盘数,从，借助，到)
	public static void doTowers(int topN,char from,char inter,char to){
		if(topN == 1){
			System.out.println("Disk 1 from " + from + " to " + to);
		}else{
			//先将A塔上编号1至n-1的盘子（共n-1个）移动到B塔上（借助C塔）
			doTowers(topN-1,from,to,inter);//from -->inter
			//将A塔上最大的n号盘子移动到C塔上
			System.out.println("Disk " + topN + " from "+ from + " to " + to);
			//最后将B塔上的n-1个盘子借助A塔移动到C塔上
			doTowers(topN-1,inter,from,to);//inter-->to
		}
	}
}
