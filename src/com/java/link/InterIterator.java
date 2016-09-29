package com.java.link;

public class InterIterator<T> {
	class Link{
		public T data;
		public Link next;
		
		public Link(T data){
			this.data =data;
		}
		
		public void displayLink(){
			System.out.println(data.toString());
		}
	}
	
	class LinkList {
		private Link first;
		
		public LinkList(){
			first=null;
		}
		
		public Link getFirst(){
			return first;
		}
		
		public void setFirst(Link f){
			first =f;
		}
		
		
		public boolean isEmpty(){
			return first==null;
		}
		
		public InterIterator getIterator(){
			return new InterIterator(new LinkList());
		}
		
		public void displayList(){
			Link current =first;
			while(current!=null){
				current.displayLink();
				current=current.next;
			}
			System.out.println("");
		}
	}
	
	private Link current;
	private Link previous;
	private LinkList ourList;
	
	public InterIterator(LinkList list){
		ourList =list;
		reset();
	}
	
	public void reset(){
		current = ourList.getFirst();
		previous = null;
	}
	
	public boolean atEnd(){
		return current.next==null;
	}
	public void nextLink(){
		previous =current;
		current = current.next;
	}
	public Link getCurrent(){
		return current;
	}
	
	public void insertAfter(T data){
		Link newLink = new Link(data);
		
		if(ourList.isEmpty()){
			ourList.setFirst(newLink);
			current =newLink;
		}else{
			newLink.next = current.next;
			current.next =newLink;
			nextLink();
		}
			
	}
	
	public void insertBefore(T data){
		Link newLink = new Link(data);
		if(previous==null){
			newLink.next = ourList.getFirst();
			ourList.setFirst(newLink);
			current =newLink;
		}else{
			newLink.next = previous.next;
			previous.next =newLink;
			current=newLink;
		}
	}
	
	public T deleteCurrent(){
		T value = current.data;
		if(previous==null){
			ourList.setFirst(current.next);
			reset();
		}else{
			previous.next = current.next;
			if(atEnd()){
				reset();
			}else{
				current = current.next;
			}
			
		}
		return value;
	}
}
