package com.adp.shopcart.util;

public class BillDiscountUtil {
	/**
	 * Calculates the net value of product. 
	 * @param quantity
	 * @param unitPrice
	 * @param discountPerc
	 * @return net value of product
	 */
	public float calculateDiscount(float quantity, float unitPrice, float discountPerc){


		float discountValue = (unitPrice * quantity * discountPerc)/100;
		return ((quantity * unitPrice) - discountValue );

	}

}
