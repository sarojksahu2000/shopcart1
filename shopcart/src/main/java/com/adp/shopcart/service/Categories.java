package com.adp.shopcart.service;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Categories")
@XmlAccessorType (XmlAccessType.FIELD)
public class Categories {

	@XmlElement(name = "Category")
	private List<Category> category = null;

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	} 

}
