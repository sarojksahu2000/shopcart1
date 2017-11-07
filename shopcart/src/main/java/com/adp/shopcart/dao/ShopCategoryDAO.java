package com.adp.shopcart.dao;

import java.util.List;

import com.adp.shopcart.service.Category;

public class ShopCategoryDAO {
	/**
	 * finds the discount percentage of product by category and returns the discount percent
	 * @param categoryId
	 * @param catList
	 * @return discount%
	 */
	public static int findDiscountByCatergory(int categoryId, List<Category> catList){

		for(int i =0 ; i< catList.size();i++){
			if(catList.get(i).getId() == categoryId)
				return catList.get(i).getDiscPerc();
		}

		return 0;
	}	
}
