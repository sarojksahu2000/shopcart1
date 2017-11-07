package com.adp.shopcart.service;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FlatDiscountSlabs")
@XmlAccessorType(XmlAccessType.FIELD)
public class FlatDiscountSlabs {

	@XmlElement(name = "Slab")
	private List<Slab> slab = null;

	public List<Slab> getSlab() {
		return slab;
	}

	public void setSlab(List<Slab> slab) {
		this.slab = slab;
	}



}
