package com.cursosalternativos.Tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class propertiesTools {

	public static final String CFG_PATH = paramConstantes.LOG_HOME_CONFIG_DIR;
	public static final String CFG_FNAME = File.separator + paramConstantes.ARCHIVO_CONFIG;
	
	
	public String propertyValue(String key) {
		
		String value;
		try (InputStream input = new FileInputStream(CFG_PATH + CFG_FNAME)) {
		
            Properties prop = new Properties();

            prop.load(input);
            
            System.out.println(prop.getProperty(key));
            value = prop.getProperty(key);

            return value;

        } catch (IOException ex) {
            ex.printStackTrace();
            return "";
        }
		
		
	}
}
