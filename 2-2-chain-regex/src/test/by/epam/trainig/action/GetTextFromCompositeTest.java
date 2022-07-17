package test.by.epam.trainig.action;

import by.epam.training.action.GetTextFromComposite;
import by.epam.training.entity.*;
import by.epam.training.reader.DataReaderFromFile;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

public class GetTextFromCompositeTest {
	String fromFileText;
	CompositeText compositeText;

	@BeforeMethod
	public void setUp() {
		try {
			fromFileText = DataReaderFromFile.loadData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		compositeText = new Text(new Paragraph(new Sentence(new Lexeme(null))));
		compositeText.runnerParse(fromFileText);

	}

	@Test
	public void CreateText() {
		String expectedText = fromFileText;
		String actualText = GetTextFromComposite.collectText(CompositeText.get—ompositTextList());

		Assert.assertEquals(actualText, expectedText);
	}

}
