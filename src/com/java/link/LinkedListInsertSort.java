package com.java.link;

import java.util.Arrays;
import java.util.Random;

public class LinkedListInsertSort<T  extends Comparable<T>> {
	class Link{
		T data;
		Link next;
		Link(T data){
			this.data = data;
		}
		void displayLink(){
			System.out.println("the data is "+ data.toString());
		}
	}
	
	private Link first;
	public LinkedListInsertSort(){
		
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public void sortList(T[] ary){
		if(ary==null)
			return ;
		for(T data :ary)
			insert(data);
	}
	
	public void insert(T data){
		Link newLink = new Link(data);
		Link current = first,previous=null;
		while(current!=null&&data.compareTo(current.data)>0){
			previous =current;
			current=current.next;
		}
		
		if(previous==null){
			first = newLink;
		}else{
			previous.next = newLink;
		}
		newLink.next = current;
	}
	
	public Link find(T t){
		Link find = first;
		while(find !=null){
			if(!find.data.equals(t)){
				find=find.next;
			}else{
				break;
			}
		}
		return find;
	}
	
	public Link delete(T t){
		if(isEmpty()){
			return null;
		}else{
			if(first.data.equals(t)){
				Link tmp =first;
				first=first.next;
				return tmp;
			}
		}
		
		Link p = first;
		Link q = first;
		while(!p.next.equals(t)){
			if(p.next==null){
				return null;
			}else{
				q=p;
				p=p.next;
			}
		}
		
		q.next = p.next;
		return p;
	}
	
	public void displayList(){
		System.out.println("list (first--> last)");
		Link current =first;
		while(current.next!=null){
			current.displayLink();
			current =current.next;
		}
	}
	
	public void displayListReverse(){
		Link p =first,q=first.next,t;
		while(q!=null){
			t = q.next;
			if(p==first){
				p.next =null;
			}
			q.next = p;
			p=q;
			q=t;
		}
		
		first=p;
		displayList();
	}
	
	public static void main(String[] args) {  
        LinkedListInsertSort<Integer> list = new LinkedListInsertSort<Integer>();  
        Random random = new Random();  
        int len = 5;  
        Integer[] ary = new Integer[len];  
        for (int i = 0; i < len; i++) {  
            ary[i] = random.nextInt(1000);  
        }  
        System.out.println("----排序前----");  
        System.out.println(Arrays.toString(ary));  
        System.out.println("----链表排序后----");  
        list.sortList(ary);  
        list.displayListReverse(); 
    }  
}
