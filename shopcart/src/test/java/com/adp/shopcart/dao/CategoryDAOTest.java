package com.adp.shopcart.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.adp.shopcart.service.Category;
public class CategoryDAOTest {

	private static List<Category> catList;

	@BeforeClass
	public static void defineList(){

		catList = new ArrayList<Category>();
		Category cat1 = new Category();
		cat1.setId(1);
		cat1.setName("Home Decor");
		cat1.setDiscPerc(10);

		Category cat2 = new Category();
		cat2.setId(2);
		cat2.setName("Vegetables");
		cat2.setDiscPerc(3);

		catList.add(cat1);
		catList.add(cat2);
	}

	@Test
	public void testForExistingCategory(){

		int discPerc = ShopCategoryDAO.findDiscountByCatergory(1, catList);

		assertEquals(10, discPerc);


	}

	@Test
	public void testForNonExistingCategory(){


		int discPerc = ShopCategoryDAO.findDiscountByCatergory(9, catList);

		assertEquals(0, discPerc);


	}
}
