package com.adp.shopcart.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.adp.shopcart.service.Slab;

public class SlabDAOTest {

	private static List<Slab> slabList ;

	@BeforeClass
	public static void defineList(){

		slabList = new ArrayList<Slab>();

		Slab slab1 = new Slab();
		slab1.setRangeMin(2000);
		slab1.setRangeMax(4000);
		slab1.setDiscPerc(5);

		Slab slab2 = new Slab();
		slab2.setRangeMin(4001);
		slab2.setRangeMax(10000);
		slab2.setDiscPerc(10);

		slabList.add(slab1);
		slabList.add(slab2);

	}

	@Test
	public void testForDefinedSlab() {

		int discRec = ShopSlabDAO.findDiscountPercentBySlab(6000, slabList);
		assertEquals(10,discRec);

	}

	@Test
	public void testForNonDefinedSlab() {

		int discRec = ShopSlabDAO.findDiscountPercentBySlab(500, slabList);
		assertEquals(0,discRec);

	}

}
