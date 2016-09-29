package com.java.link;

public class DoublyLinkList<T> {
	class Node{
		private T data;
		private Node prev = null;
		private Node next = null;
		
		public boolean equals(Node node){
			if(data.equals(node.data))
					return true;
			return false;
		}
		
		public int hashCode(){
			return data.hashCode();
		}
		
		public String toString(){
			return data.toString();
		}
	}
	
	private Node head;
	private Node tail;
	
	public DoublyLinkList(){
		head=new Node();
		tail=new Node();
	}
	
	public void addToHead(Node node){
		if(null==head.next){
			head.next =node;
			tail.next =node;
		}else{
			node.next=head.next;
			head.next.prev = node;
			head.next = node;
		}
	}
	
	public boolean isEmpty(){
		if(null==head.next||null==tail.next){
			return true;
		}
		
		return false;
	}
	
	
	public void traversalFromHead(){
		if(isEmpty()){
			System.out.println("is empty");
		}else{
			Node node = head;
			while(null!=node.next){
				System.out.print(node.next+"--->");
				node=node.next;
			}
			System.out.println();
		}
	}
	
	public void traversalFromTail(){
		if(isEmpty()){
			System.out.println("is empty");
		}else{
			Node node = tail;
			while(null!=node.prev){
				System.out.print(node.prev+"--->");
				node=node.prev;
			}
			System.out.println();
		}
	}
	
	public void insertAfter(Node node,T data){
		if(null==head.next||null==tail.next){
			System.out.println("is empty");
		}else{
			Node theNode=head;
			while(null!=theNode.next){
				if(theNode.next.data.equals(data)){
					node.next = theNode.next.next;
					theNode.next.next.prev = node;
					theNode.next.next=node;
					node.prev=theNode.next;
					break;
				}
				theNode=theNode.next;
			}
		}
	}
	
	public void insertBefore(Node node,T data){
		if(null==head.next||null==tail.next){
			System.out.println("is empty");
		}else{
			Node theNode=head;
			while(null!=theNode.next){
				if(theNode.next.data.equals(data)){
					node.next = theNode.next;
					theNode.next.prev = node;
					theNode.next=node;
					node.prev=theNode;
					break;
				}
				theNode=theNode.next;
			}
		}
	}
}
