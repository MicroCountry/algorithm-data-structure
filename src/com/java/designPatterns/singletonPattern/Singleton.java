package com.java.designPatterns.singletonPattern;

public class Singleton {
	/**
	 * 饿汉式
	 */
/*	private static Singleton instance= new Singleton();
	
	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		return instance;
	}
	*/
	//*********************************我是分割线**************************************
	/**
	 * 饿汉式2 
	 */
	/*private static Singleton instance;
	 
	 static{
	 	instance=new Singleton();
	 }
	private Singleton(){
	}
	public static Singleton getInstance(){
		return instance;
	}
	*/
	
	//*********************************我是分割线*****************************************
	/**
	 * 静态内部类
	 * 避免 这个类被多次加载的话也会造成多次实例化
	 */
/*	
	//并且静态内部类只有在被调用的时候加载，并且当外部内多次加载也不会影响内部类的加载次数，静态内部类只会加载一次
	private static class SingletonHolder{
		//这里可以看出 静态类调用了外围类的构造方法，但是静态类不能直接访问非静态成员，所以构造器是隐式的为static
		private static final Singleton instance = new Singleton();
		
	}
	
	private Singleton(){
		
	}
	
	public static final Singleton getInstance(){
		return SingletonHolder.instance;
	}
	
	*/
	
	//**********************************我是分割线*******************************************
	/**
	 * 懒汉式
	 * 线程不安全，当在多线程的情况下，进入判断 instance==null的时候，都会进行创建实例
	 */
	/*
	private static Singleton instance;
	
	private Singleton(){
		
	}
	
	private static Singleton getInstance(){
		if(instance==null){
			instance=new Singleton();
		}
		return instance;
	}
	*/
	
	//***********************************我是分割线**********************************************
	/**
	 * 同步法懒汉式 
	 */
	/*private static Singleton instance;
	
	private Singleton(){
		
	}
	
	private static synchronized Singleton getInstance(){
		if(instance==null){
			instance = new Singleton();
		}
		return instance;
	}
	*/
	//***********************************我是分割线**********************************************
	/**
	 * 双重锁定懒汉式 :java 无序写
	 * 假设有两个线程A、B
		1、线程A进入getInstance()方法。
		2、因为此时instance为空，所以线程A进入synchronized块。
		3、线程A执行 instance = new Singleton(); 把实例变量instance设置成了非空。（注意，是在调用构造方法之前。）
		4、线程A退出，线程B进入。
		5、线程B检查instance是否为空，此时不为空（第三步的时候被线程A设置成了非空）。线程B返回instance的引用。（问题出现了，这时instance的引用并不是Singleton的实例，因为没有调用构造方法。） 
		6、线程B退出，线程A进入。
		7、线程A继续调用构造方法，完成instance的初始化，再返回。 
	 */
	/*
	private static Singleton instance;
	
	private Singleton(){
		
	}
	
	private static Singleton getInstance(){
		if(instance == null){
			synchronized (Singleton.class) {
				if(instance==null){
					//instance = new Singleton(); 这行其实做了两个事情：1、调用构造方法，创建了一个实例。2、把这个实例赋值给instance这个实例变量。可问题就是，
					//这两步jvm是不保证顺序的。也就是说。可能在调用构造方法之前，instance已经被设置为非空了
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	*/
	//***********************************我是分割线**********************************************
	/**
	 * 解决无序写问题
	 */
	//方法1：
	/*
	private static Singleton instance = null;
	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		if(instance == null){
			synchronized (Singleton.class) {
				Singleton temp = instance;
				if(temp==null){
					synchronized (Singleton.class) {
						temp=new Singleton();
					}
					instance = temp;
				}
			}
		}
		
		return instance;
	}
	*/
	//方法2 ：volattile
/*	private static volatile Singleton singleton;
	
	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		if(singleton==null){
			synchronized(Singleton.class){
				if(singleton==null){
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
	
	*/
	//***********************************我是分割线**********************************************
	/**
	 * 解决序列化的问题
	 * 待理解
	 */
	/*class FinalWrapper<T>{
		public final T value;
		
		public FinalWrapper(T value){
			this.value = value;
		}
	}
	
	private FinalWrapper<Singleton> helperWrapper = null;
	
	public Singleton getInstance(){
		FinalWrapper<Singleton> wrapper = helperWrapper;
		
		if(wrapper==null){
			synchronized(this){
				if(helperWrapper == null){
					helperWrapper = new FinalWrapper<Singleton>(new Singleton());
				}
				wrapper=helperWrapper;
			}
		}
		
		return wrapper.value;
	}
	
	*/
	
	//***********************************我是分割线**********************************************
	/**
	 * 枚举式
	 */
	/*
	public enum Singleton{
		INSTANCE;
		public void Singleton(){
			
		}
	}
	*/
}
