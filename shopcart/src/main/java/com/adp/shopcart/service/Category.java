package com.adp.shopcart.service;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Category")
public class Category {

	private int id;
	private String name;
	private int discPerc;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDiscPerc() {
		return discPerc;
	}
	public void setDiscPerc(int discPerc) {
		this.discPerc = discPerc;
	}


}
