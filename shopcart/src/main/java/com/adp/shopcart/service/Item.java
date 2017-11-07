package com.adp.shopcart.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Item")
public class Item {

	private int itemID;
	private int itemCategoryID;
	private String itemName;
	private float unitPrice;
	private float quantity;
	private int discount;
	private float netAmount;
	private float totAmount;


	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public int getItemCategoryID() {
		return itemCategoryID;
	}
	public void setItemCategoryID(int itemCategoryID) {
		this.itemCategoryID = itemCategoryID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public float getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(float netAmount) {
		this.netAmount = netAmount;
	}
	
	public float getTotAmount() {
		return totAmount;
	}
	public void setTotAmount(float totAmount) {
		this.totAmount = totAmount;
	}
	
	/*public BigDecimal getTotalCost() {
		return this.price.multiply(new BigDecimal(this.quantity)).setScale(2, RoundingMode.CEILING);
	}*/



}
