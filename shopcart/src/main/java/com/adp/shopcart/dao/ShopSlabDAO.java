package com.adp.shopcart.dao;

import java.util.List;

import com.adp.shopcart.service.Slab;

public class ShopSlabDAO {
	
	/**
	 * This function reads the slab discount from defined values, 
	 * compares the bill amount with defined slabs and
	 * return the discount percentage 
	 * @param finalAmount
	 * @param List
	 * @return discount%
	 */
	public static int findDiscountPercentBySlab(float finalAmount, List<Slab> List){

		for(int i =0 ; i< List.size();i++){
			if(finalAmount >= List.get(i).getRangeMin() && finalAmount <= List.get(i).getRangeMax())
				return List.get(i).getDiscPerc();
		}

		return 0;
	}

}
