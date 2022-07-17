package by.epam.training.entity;

import by.epam.training.lexemtype.LexemType;

public class Word extends CompositeText {
	private String word = new String();

	public Word(String word) {
		super(null);
		this.word = word;
		lexemType = LexemType.WORD;
	}

	public int getWordLength() {
		return word.length();
	}

	@Override
	public String toString() {

		StringBuilder beginingWord = new StringBuilder();
		beginingWord.append(" ");
		beginingWord.append(word);
		return beginingWord.toString();

	}

}
