package by.epam.training.entity;

import java.util.ArrayList;
import java.util.List;

import by.epam.training.lexemtype.LexemType;

public class CompositeText implements CompositeTextSpecification {

	static List<CompositeText> ÒompositTextList = new ArrayList<>();
	protected LexemType lexemType;
	CompositeText compositeText;

	public CompositeText(CompositeText compositeText) {
		this.compositeText = compositeText;
	}

	@Override
	public void runnerParse(String parsingString) {

	}

	public static List<CompositeText> get—ompositTextList() {
		return ÒompositTextList;
	}

	public LexemType getLexemType() {
		return lexemType;
	}

	@Override
	public void add(CompositeText compositeText) {
		get—ompositTextList().add(compositeText);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compositeText == null) ? 0 : compositeText.hashCode());
		result = prime * result + ((lexemType == null) ? 0 : lexemType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		CompositeText other = (CompositeText) obj;
		if (compositeText == null) {
			if (other.compositeText != null) {
				return false;
			}
		} else if (!compositeText.equals(other.compositeText)) {
			return false;
		}
		if (lexemType != other.lexemType) {
			return false;
		}
		return true;
	}

}
