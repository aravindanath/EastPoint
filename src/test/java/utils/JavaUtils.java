package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class JavaUtils {

	public static String getValue(String key) throws IOException {
		FileInputStream fis =  new FileInputStream(new File(System.getProperty("user.dir")+"/testData/config.properties"));
		Properties prop = new Properties();
		prop.load(fis);
		String val = prop.getProperty(key);
		return val;
	}

}
