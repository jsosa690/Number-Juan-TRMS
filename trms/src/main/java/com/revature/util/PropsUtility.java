package com.revature.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsUtility {

	private static Properties props;

	   public static Properties getProps() {
	       if (PropsUtility.props != null) {
	           return props;
	       }
	       props = new Properties();
	       try {
	           InputStream resource = PropsUtility.class.getResourceAsStream("/database.properties");
	           props.load(resource);
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	       return props;
	   }
}
