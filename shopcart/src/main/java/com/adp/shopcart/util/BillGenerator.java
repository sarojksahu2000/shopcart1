package com.adp.shopcart.util;

import java.util.List;

import com.adp.shopcart.dao.ShopCategoryDAO;
import com.adp.shopcart.dao.ShopSlabDAO;
import com.adp.shopcart.service.Category;
import com.adp.shopcart.service.Item;
import com.adp.shopcart.service.ShoppingCart;
import com.adp.shopcart.service.Slab;
import com.adp.shopcart.util.BillDiscountUtil;

public class BillGenerator {
	/**
	 * Generates final bill based on shopping cart menu and discount
	 * @param slabList
	 * @param catList
	 * @param shoppingCart
	 * @return
	 */
	public static ShoppingCart generateFinalBill(List<Slab> slabList, List<Category> catList, ShoppingCart shoppingCart){

		if (slabList == null || shoppingCart == null || catList== null){

			return shoppingCart;

		}else{

			List<Item> itemList = shoppingCart.getItems(); 
			BillDiscountUtil bd = new BillDiscountUtil();
			float totalAmount = 0;

			for(int i =0 ; i< itemList.size();i++){

				int discPerc = ShopCategoryDAO.findDiscountByCatergory(itemList.get(i).getItemCategoryID(), catList);
				itemList.get(i).setDiscount(discPerc);
				float value = bd.calculateDiscount(itemList.get(i).getQuantity(), itemList.get(i).getUnitPrice(), discPerc);
				itemList.get(i).setNetAmount(value);
				itemList.get(i).setTotAmount(itemList.get(i).getQuantity() * itemList.get(i).getUnitPrice());
				totalAmount += value;

			}

			shoppingCart.setTotalAmount(totalAmount);

			int slabDisc = ShopSlabDAO.findDiscountPercentBySlab(totalAmount, slabList);
			shoppingCart.setSlabDisc(slabDisc);

			float finalBillAmount = bd.calculateDiscount(1, totalAmount, slabDisc);
			shoppingCart.setFinalBillAmount(finalBillAmount);


			return shoppingCart;
		}
	}


	/**
	 * It Prints the final invoice 
	 * @param shoppingCart
	 */
	public static void printBill(ShoppingCart shoppingCart){

		if (shoppingCart == null){

			System.out.print("Shopping Cart is empty!");

		}else{
			List<Item> itemList = shoppingCart.getItems();
			int counter = 1;
			System.out.printf("%30s", "");
			System.out.printf("************ Bill ***********");
			System.out.println("\n");
			System.out.printf("%5s %30s %10s %10s %10s %10s %20s", "Serial", "Item Name", "Quantity", "Price", "Tot Price", "Discount(%)", "Final Price");
			System.out.println("\n");
			
			for(int i =0 ; i< itemList.size();i++){
				System.out.println();
				
				System.out.format("%5s %30s %10s %10s %10s %10s %20s", counter++, itemList.get(i).getItemName(), itemList.get(i).getQuantity(), itemList.get(i).getUnitPrice(), itemList.get(i).getTotAmount(), itemList.get(i).getDiscount(), itemList.get(i).getNetAmount());
				
				System.out.println();
			}

			System.out.printf("\nTotal after category discount");
			System.out.printf("%65s", "");
			System.out.format( "%.2f", shoppingCart.getTotalAmount());
			System.out.println("\n");
			System.out.printf( "Slab Discount  %84d", shoppingCart.getSlabDisc());
			System.out.println(" %");

			System.out.printf("\nFinal Amount");
			System.out.printf("%82s", "");
			System.out.format( "%.2f", shoppingCart.getFinalBillAmount());
		}	
	}

}
