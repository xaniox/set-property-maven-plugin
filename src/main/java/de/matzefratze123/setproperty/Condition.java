package de.matzefratze123.setproperty;

public class Condition {

	private String string;
	private Operator operator;
	private String operand;
	
	public boolean process() {
		if (operator == Operator.EQUALS) {
			return string.equals(operand);
		} else {
			return string.matches(operand);
		}
	}
	
	public enum Operator {
		
		EQUALS,
		EQUALS_REGEX;
		
	}
	
}
