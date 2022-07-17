package by.epam.training.action;

import java.util.List;
import org.apache.logging.log4j.*;
import by.epam.training.entity.CompositeText;

public class GetTextFromComposite {
	
	private static final Logger LOGGER = LogManager.getLogger(GetTextFromComposite.class);
	
	public static String collectText(List<CompositeText> ñompositTextList) {

		StringBuilder stringBuilder = new StringBuilder();

		for (CompositeText compositeText : ñompositTextList) {
			stringBuilder.append(compositeText.toString());
		}
		LOGGER.log(Level.INFO,"Getting text From Composite");
		return stringBuilder.toString();
	}

}
