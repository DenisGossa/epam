package by.epam.training.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.lexemtype.LexemType;

public class Text extends CompositeText {
	
	private static final Logger LOGGER = LogManager.getLogger( Paragraph.class);
	private final String PARAGRAPH_REGEX = "\\t|\\s{4}";

	public Text(CompositeText compositeText) {
		super(compositeText);
		lexemType = LexemType.TEXT;
	}

	@Override
	public void runnerParse(String parsingString) {

		ñompositTextList.add(this);
		LOGGER.log(Level.INFO,"TEXT added");
		String[] paragraphArray = parsingString.trim().split(PARAGRAPH_REGEX);

		for (String paragraphString : paragraphArray) {
			System.out.println("___find paragraph  " + paragraphString);
			compositeText.runnerParse(paragraphString);

		}

	}

	@Override
	public String toString() {
		StringBuilder beginingText = new StringBuilder();
		beginingText.append("");

		return beginingText.toString();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((PARAGRAPH_REGEX == null) ? 0 : PARAGRAPH_REGEX.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj) || getClass() != obj.getClass()) {
			return false;
		}

		Text other = (Text) obj;
		if (PARAGRAPH_REGEX == null) {
			if (other.PARAGRAPH_REGEX != null) {
				return false;
			}
		} else if (!PARAGRAPH_REGEX.equals(other.PARAGRAPH_REGEX)) {
			return false;
		}
		return true;
	}

}