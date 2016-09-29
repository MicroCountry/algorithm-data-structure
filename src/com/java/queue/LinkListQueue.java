package com.java.queue;

import java.util.NoSuchElementException;

public class LinkListQueue<T> {
	 class Node  {
		    public T data;
		    public Node  next;
		    Node(T data){
		        this.data=data;
		    }
		}
	 
	 	protected Node front;
	    protected Node rear;
	    public int size;
	 
	    public LinkListQueue() {
	        front = null;
	        rear = null;
	    }
	 
	    public boolean isEmpty() {
	        return size == 0;
	    }
	 
	    // insert to rear
	    public T enQueue(T e) {
	        Node node = new Node(e);
	        if (isEmpty()) {
	            front = new Node(null);
	            front.next = node;
	            rear = node;
	        } else {
	            rear.next = node;
	            rear = node;
	        }
	        size++;
	        return e;
	    }
	 
	    // Delete front
	    public T deQueue() {
	        if (size == 0) {
	            throw new NoSuchElementException("Queue underflow");
	        }
	        Node delete = front.next;
	        T e = (T) delete.data;
	        front.next = delete.next;
	        size--;
	        if (size == 0)
	            rear = null;
	        delete = null;
	        return e;
	    }
}
