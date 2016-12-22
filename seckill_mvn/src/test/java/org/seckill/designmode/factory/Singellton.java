package org.seckill.designmode.factory;


public class Singellton {
	private static Singellton s;
	public static Singellton getInstance(){
		if(s == null)
			s = new Singellton();
		return s;
	}
	
	//私有化构造器,无法new一个
	private Singellton(){}
} 
