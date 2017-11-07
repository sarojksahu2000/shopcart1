package com.adp.shopcart.util;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.adp.shopcart.service.Category;
import com.adp.shopcart.service.Item;
import com.adp.shopcart.service.ShoppingCart;
import com.adp.shopcart.service.Slab;

public class BillGeneratorTest {
	
	private static List<Category> catList;
	private static List<Item> itemList;
	private static List<Slab> slabList;
	private static ShoppingCart shoppingCart = new ShoppingCart();
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@BeforeClass
	public static void DefineLists() {
		
		catList = new ArrayList<Category>();
		itemList = new ArrayList<Item>();
		slabList = new ArrayList<Slab>();
		
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
		
		Slab slab1 = new Slab();
		slab1.setRangeMin(2000);
		slab1.setRangeMax(4000);
		slab1.setDiscPerc(5);
		
		Slab slab2 = new Slab();
		slab2.setRangeMin(4001);
		slab2.setRangeMax(15000);
		slab2.setDiscPerc(10);
		
		slabList.add(slab1);
		slabList.add(slab2);
		
		Item item1 = new Item();
		item1.setItemID(1);
		item1.setItemCategoryID(1);
		item1.setUnitPrice(15000);
		item1.setItemName("Dinning Table");
		item1.setQuantity(1);
		
		Item item2 = new Item();
		item2.setItemID(2);
		item2.setItemCategoryID(2);
		item2.setUnitPrice(25);
		item2.setItemName("Green vegetables");
		item2.setQuantity(3);
		
		itemList.add(item1);
		itemList.add(item2);
		
		shoppingCart.setItems(itemList);
		
	}
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	
	
	@Test
	public void generateFinalBill(){
		
		ShoppingCart shoppingDetails = BillGenerator.generateFinalBill(slabList, catList, shoppingCart);
		
		assertEquals(10,shoppingDetails.getItems().get(0).getDiscount());
		assertEquals(13500.00,shoppingDetails.getItems().get(0).getNetAmount(),0.1);
		assertEquals(72.75,shoppingDetails.getItems().get(1).getNetAmount(),0.1);
		//assertEquals(12214.79,shoppingDetails.getFinalBillAmount(),0.1);
		
	}

	
	@Test
	public void generateFinalBilWithBlankList()
	{
		
		ShoppingCart shoppingDetails = BillGenerator.generateFinalBill(slabList, catList, null);
		assertEquals(null,shoppingDetails);
	}
	
	
	@Test
	public void printBillWithBlankList()
	{
		ShoppingCart shoppingDetails = BillGenerator.generateFinalBill(slabList, catList, null);
		BillGenerator.printBill(shoppingDetails);
		 assertEquals("Shopping Cart is empty!", outContent.toString());
		   
	}

}
