package com.java.stack;

public class LinkedStack<T> {
	class Node{
		private Node pre;
		private T data;
	}
	private int size;
	private Node top;
	
	public LinkedStack(){
		this.top =null;
		this.size =0;
	}
	
	public boolean push(T data){
		Node node = new Node();
		node.data=data;
		node.pre = top;
		//改变栈顶指针
		top = node;
		size++;
		return true;
	}
	
	public T pop(){
		if(top!=null){
			T t = top.data;
			top=top.pre;
			size --;
			return t;
		}
		return null;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void clear(){
		top = null;
		size =0;
	}
	
	public T peek(){
		return top.data;
	}
	
	public int search(T t){
		int count = 0;
		for(Node node=top;node.pre!=null;node=node.pre){
			count ++;
			if(t.equals(node.data))
				return size-count;
		}
		return 0;
	}
	
	public int length(){
		return size;
	}
	
	public String toString(){
		StringBuilder sb= new StringBuilder();
		sb.append("LinkStack:"+length()+"\n[\n");    
        int count=0;  
        for (Node node = top;node!=null;node=node.pre) {    
            count++;  
            sb.append("   "+node.data.toString());    
            if (count != size + 1) {    
                sb.append("\n");    
            }    
        }    
        sb.append("]");   
        System.out.println(count);  
        return sb.toString(); 
	}
}
