package com.adp.shopcart.util;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class BillDiscountUtilTest {
	private static BillDiscountUtil discountUtil;

	@BeforeClass
	public static void iniDiscountUtil(){

		discountUtil = new BillDiscountUtil();

	}


	@Test
	public void calculateDiscountWithoutException() {

		float value = discountUtil.calculateDiscount(2, 100, 2);
		assertEquals(196.00,value,0.0);

	}


	@Test
	public void calculateDiscountWithException() {

		float value = discountUtil.calculateDiscount(2, 0, 2);
		assertEquals(0,value,0.0);

	}

}
