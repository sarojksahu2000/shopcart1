package com.adp.shopcart.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Slab")
@XmlAccessorType(XmlAccessType.FIELD)
public class Slab {


	private int RangeMin;
	private int RangeMax;
	private int discPerc;

	public int getRangeMin() {
		return RangeMin;
	}

	public void setRangeMin(int rangeMin) {
		this.RangeMin = rangeMin;
	}

	public int getRangeMax() {
		return RangeMax;
	}

	public void setRangeMax(int rangeMax) {
		this.RangeMax = rangeMax;
	}

	public int getDiscPerc() {
		return discPerc;
	}

	public void setDiscPerc(int discPerc) {
		this.discPerc = discPerc;
	}




}
