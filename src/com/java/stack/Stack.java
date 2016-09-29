package com.java.stack;

public class Stack {
	private int maxSize;
	private Long[] arrayStack;
	private int top;
	
	public Stack(int s){
		maxSize =s ;
		top =-1;
		arrayStack = new Long[s];
	}
	
	public void push(Long j){
		arrayStack[++top] = j;
	}
	
	public Long pop(){
		return arrayStack[--top];
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isFull(){
		return (top == maxSize-1);
	}
	
	public Long peek(){
		return arrayStack[top];
	}
}
