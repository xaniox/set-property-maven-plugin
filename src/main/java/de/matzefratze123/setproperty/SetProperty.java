package de.matzefratze123.setproperty;

import java.util.Properties;

public class SetProperty {

	private String property;
	private String value;

	public void set(Properties properties) {
		properties.setProperty(property, value);
	}
	
	public String getProperty() {
		return property;
	}
	
	public String getValue() {
		return value;
	}
	
}
