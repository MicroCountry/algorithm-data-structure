package com.java.designPatterns.singletonPattern;

import java.io.Serializable;

public class SingletonSerializable implements Serializable{
	private static volatile SingletonSerializable singleton;
	
	private SingletonSerializable(){
		
	}
	
	public static SingletonSerializable getInstance(){
		if(singleton==null){
			synchronized(Singleton.class){
				if(singleton==null){
					singleton = new SingletonSerializable();
				}
			}
		}
		return singleton;
	}
	
	private Object readResolve(){
		return singleton;
	}
}
