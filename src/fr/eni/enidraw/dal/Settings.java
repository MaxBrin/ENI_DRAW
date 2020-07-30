/**
 * 
 */
package fr.eni.enidraw.dal;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Maxime Brin
 * @version
 * @dateDeCréation 23 juil. 2020
 */
public class Settings {
	private static Properties properties;
	static {
		try {
			properties = new Properties();
			properties.load(Settings.class.getResourceAsStream("settings.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);

	}
}
