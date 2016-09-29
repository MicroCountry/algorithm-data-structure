package com.java.queue;

public class ArrayQueue<T> {
	private T[] data;
	private static final int DEFAULT_SIZE=10;  
	private int front;
	private int rear;
	
	public ArrayQueue(){
		this(DEFAULT_SIZE);
	}
	public ArrayQueue(int s){
		data = (T[]) new Object[s];
		front = 0;
		rear = 0;
	}
	
	public boolean enqueue(T obj){
		if((rear+1)%data.length==front){
			return false;
		}else{
			data[rear] = obj;
			rear=(rear+1)%data.length;
			return true;
		}
	}
	
	public T dequeue(){
		if(rear==front){
			return null;
		}else{
			T obj = data[front];
			front = (front+1)%data.length;
			return obj;
		}
	}
	
	public int size(){
		return (rear-front)&(data.length-1);
	}
	
	public boolean isEmpty(){
		return front==rear;
	}
	
	public static void main(String[] args) {
		 ArrayQueue<String> queue=new ArrayQueue<String>(4);  
	        queue.enqueue("1");  
	        queue.enqueue("2");  
	        queue.enqueue("3");  
	        System.out.println("size="+queue.size());  
	        int size=queue.size();  
	        System.out.println("*******出栈操作*******");  
	        for(int i=0; i<size;i++){  
	            System.out.print(queue.dequeue()+" ");  
	        }  
	}

}
