package com.adp.shopcart.helper;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import com.adp.shopcart.service.Categories;

public class XmlToObjectTest {

	// Negative test case commented below
	/*@Test(expected = RuntimeException.class)
	public void convertXMLToObjectWithError(){

		File file = new File("src/main/resources/XML/Categories.xml");
		XMLConverter.convertXMLToObject(Categories.class, file);
	}*/

	@Test
	public void convertXMLToObjectWithoutError(){

		File file = new File("src/main/resources/XML/Categories.xml");
		Categories categories = XmlToObject.convertXMLToObject(Categories.class, file);

		assertNotEquals(null, categories);
		assertEquals(7,categories.getCategory().get(1).getDiscPerc());
		assertEquals("Apparrel",categories.getCategory().get(4).getName());
		assertEquals(4,categories.getCategory().get(3).getId());


	}

}
