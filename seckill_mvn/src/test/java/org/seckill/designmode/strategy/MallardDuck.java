package org.seckill.designmode.strategy;

public class MallardDuck extends Duck{
	//建一个构造无参构造器,并实例化flyBehavior;
	public MallardDuck() {       
		flyBehavior = new FlyNoWay();
    }
      //因为MallardDuck 继承了Duck，所有具有flyBehavior  实例变量}
    public void display(){
     //具体的实现
   }

}
