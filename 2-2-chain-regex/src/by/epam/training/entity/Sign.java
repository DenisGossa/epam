package by.epam.training.entity;

import by.epam.training.lexemtype.LexemType;

public class Sign extends CompositeText {
	private String sign = new String();
	
	public Sign(String sign,LexemType lexemType) {
		super(null);
		this.sign = sign;
		this.lexemType = lexemType;
	}

		 
	@Override
	    public String toString() {
	        return sign;
	    }
	
}

