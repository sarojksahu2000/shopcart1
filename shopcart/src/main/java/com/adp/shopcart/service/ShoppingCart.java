package com.adp.shopcart.service;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ShoppingCart")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoppingCart {

	@XmlElement(name = "Item")
	private List<Item> items =  null;

	private int slabDisc;
	private float totalAmount;
	private float finalBillAmount;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getSlabDisc() {
		return slabDisc;
	}

	public void setSlabDisc(int slabDisc) {
		this.slabDisc = slabDisc;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public float getFinalBillAmount() {
		return finalBillAmount;
	}

	public void setFinalBillAmount(float finalBillAmount) {
		this.finalBillAmount = finalBillAmount;
	}


}
