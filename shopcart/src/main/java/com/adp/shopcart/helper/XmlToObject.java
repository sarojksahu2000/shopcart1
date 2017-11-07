package com.adp.shopcart.helper;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XmlToObject {
	/**
	 * Generic method for converting XML data to objects.
	 * @param clas
	 * @param file
	 * @return Object 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T convertXMLToObject(Class<?> clas, File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(clas);
			Unmarshaller um = context.createUnmarshaller();
			return (T) um.unmarshal(file);
		} catch (JAXBException je) {

			throw new RuntimeException("Error interpreting XML response");
		}
	}

}
