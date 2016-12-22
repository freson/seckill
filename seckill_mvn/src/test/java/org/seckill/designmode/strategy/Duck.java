package org.seckill.designmode.strategy;

public abstract class Duck{        //在抽象类中,声明各接口,定义各接口对应的方法.
    FlyBehavior flyBehavior;//接口
     public Duck(){}
     public abstract void display();//外貌显示
     public void swim(){
      //实现游泳的行为
      }
     
     //执行具体的FlyBehavior接口实现
     public void performFly(){
          flyBehavior.fly(); //由于是接口,会根据继承类实现的方式,而调用相应的方法.
   }
}
