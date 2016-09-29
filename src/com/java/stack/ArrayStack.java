package com.java.stack;

public class ArrayStack<T> {
	private T[] t = (T[]) new Object[16];
	private int size =0;
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public void clear(){
		for(int i=0;i<t.length;i++){
			t[i]=null;
		}
		size =0;
	}
	
	public T pop(){
		if(size==0){
			return null;
		}else{
			T tmp = t[size-1];
			t[size-1]=null;
			size--;
			return tmp;
		}
	}
	
	public boolean push(T data){
		if(size>=t.length){
			resize();
		}
		t[size++]= data;
		return true;
	}
	
	public void resize(){
		T[] tmp = (T[]) new Object[t.length*2];
		for(int i=0;i<t.length;i++){
			tmp[i] = t[i];
			t[i]=null;
		}
		
		t= tmp;
		tmp=null;
	}
	
	public T peek(){
		if(size==0){
			return null;
		}else{
			return t[size-1];
		}
	}
	 public String toString() {  
         StringBuilder sb = new StringBuilder();    
            sb.append("ArrayStack:\n[\n");    
            for (int i = size-1; i >=0; i--) {    
                sb.append("   "+t[i].toString());    
                if (i != size + 1) {    
                    sb.append("\n");    
                }    
            }    
            sb.append("]");    
            return sb.toString();    
    }  
}
