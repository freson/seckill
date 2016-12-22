package org.seckill.designmode.strategy;

import static org.junit.Assert.*;

import org.junit.Test;

public class MallardDuckTest {

	@Test
	public final void test() {
		
		Duck duck = new MallardDuck();
		duck.performFly();
	}

}
