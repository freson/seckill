package org.seckill.designmode.factory;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.util.Assert;

public class SingelltonTest {

	@Test
	public final void test() {
		Singellton s1 = Singellton.getInstance();
		Singellton s2 = Singellton.getInstance();
		//Singellton s3 = new Singellton();
		Assert.isTrue(s1==s2);
	  }
	}

