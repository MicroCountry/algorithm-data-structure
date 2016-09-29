package com.java.queue;

public class LinkedQueue<T> {
	private class Node{
		public Node next;
		public T data;
		
		public Node(){
			
		}
		public Node(T data,Node next){
			this.data = data;
			this.next= next;
		}
	}
	
	private Node front;
	private Node rear;
	
	private int size =0;
	
	public LinkedQueue(){
		Node n = new Node(null,null);
		n.next = null; 
		front=rear=n;
	}
	
	public void enqueue(T data){
		Node s= new Node(data,null);
		rear.next =s;
		rear = s;
		size++;
	}
	
	public T dequeue(){
		if(rear==front){
			return null;
		}else{
			Node p = front.next;
			T x = p.data;
			front.next = p.next;
			if(p.next==null)
				rear=front;
			p=null;
			size--;
			return x;
		}
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public String toString() {  
        if(isEmpty()){  
            return "[]";  
        }else{  
            StringBuilder sb = new StringBuilder("[");  
            for(Node current=front.next;current!=null;current=current.next){  
                sb.append(current.data.toString() + ", ");  
            }  
            int len = sb.length();  
            return sb.delete(len - 2, len).append("]").toString();  
        }  
    }  
}
