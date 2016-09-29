package com.java.stack;

public class LinkListStack<T> {
	class Node<T> {  
	    private T data;  
	      
	    private Node<T> next;  
	      
	    public Node(){  
	        data = null;  
	        next = null;  
	    }  
	      
	    public Node(T data){  
	        this.data = data;  
	        this.next = null;  
	    }  
	      
	    public Node(T data, Node<T> next){  
	        this.data = data;  
	        this.next = next;  
	    }  
	      
	    public void setData(T data){  
	        this.data = data;  
	    }  
	      
	    public T getData(){  
	        return this.data;  
	    }  
	      
	    public void setNext(Node<T> next){  
	        this.next = next;  
	    }  
	      
	    public Node<T> getNext(){  
	        return this.next;  
	    }  
	}  
	
	private Node<T> top;  
    private int size;  
      
    public LinkListStack(){  
        this.top = null;  
        this.size = 0;  
    }  
      
    public LinkListStack(T data){  
        this();  
        Node<T> node = new Node<T>(data);  
        this.top = node;  
        this.size ++;  
    }  
      
    public void clear() {  
        this.top = null;  
        this.size = 0;  
    }  
  
    public boolean isEmpty() {  
        return this.top == null;  
    }  
  
    public T peek() {  
        return this.top.getData();  
    }  
  
    public T pop() {  
        Node<T> oldTop = this.top;  
        if(top == null){  
            return null;  
        }  
        this.top = this.top.getNext();  
        this.size --;  
        return oldTop.getData();  
    }  
  
    public void push(T element) {  
        Node<T> node = new Node<T>(element,top);  
        this.top = node;  
        this.size ++;  
    }  
      
    public int size(){  
        return this.size;  
    }  
}
