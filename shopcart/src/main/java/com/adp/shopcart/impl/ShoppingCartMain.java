package com.adp.shopcart.impl;

import java.io.File;
import java.util.List;

import com.adp.shopcart.service.Categories;
import com.adp.shopcart.service.Category;
import com.adp.shopcart.service.FlatDiscountSlabs;
import com.adp.shopcart.service.ShoppingCart;
import com.adp.shopcart.service.Slab;
import com.adp.shopcart.helper.XmlToObject;
import com.adp.shopcart.util.BillGenerator;

public class ShoppingCartMain {
	
	/**
	 * main class - execution starts here.
	 * @author saroj sahu
	 * 
	 */
	public static void main (String args[])
	{

		// Read xml files and convert them to objects.
		// Create a classLoader object, load class and get resources
		ClassLoader classLoader = new ShoppingCartMain().getClass().getClassLoader();
		File file = new File(classLoader.getResource("XML/FlatDiscountSlabs.xml").getFile());
		
		FlatDiscountSlabs flatDiscountSlabs = XmlToObject.convertXMLToObject(FlatDiscountSlabs.class, file);
		List<Slab> slabList = flatDiscountSlabs.getSlab(); 

		file = new File(classLoader.getResource("XML/Categories.xml").getFile());
		Categories categories = XmlToObject.convertXMLToObject(Categories.class, file);
		List<Category> catList = categories.getCategory(); 
		
		file = new File(classLoader.getResource("XML/ShoppingCart.xml").getFile());
		ShoppingCart shoppingCart = XmlToObject.convertXMLToObject(ShoppingCart.class, file);

		// Generate bill and print it on console. 
		ShoppingCart shoppingDetails = BillGenerator.generateFinalBill(slabList, catList, shoppingCart);
		BillGenerator.printBill(shoppingDetails);

	}

}
