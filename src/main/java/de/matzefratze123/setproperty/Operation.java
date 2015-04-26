package de.matzefratze123.setproperty;

import java.util.List;
import java.util.Properties;

public class Operation {
	
	private Condition condition;
	private List<SetProperty> setpropertiestrue;
	private List<SetProperty> setpropertiesfalse;
	
	public List<SetProperty> execute(Properties properties) {
		List<SetProperty> result;
		
		result = condition.process() ? setpropertiestrue : setpropertiesfalse;
		
		for (SetProperty property : result) {
			property.set(properties);
		}
		
		return result;
	}
	
}
