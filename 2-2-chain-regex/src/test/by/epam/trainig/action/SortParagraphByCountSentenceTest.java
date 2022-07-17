package test.by.epam.trainig.action;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.epam.training.action.SortParagraphByCountSentence;
import by.epam.training.entity.*;
import by.epam.training.exception.NonCorrectParameterFormat;
import by.epam.training.reader.DataReaderFromFile;

public class SortParagraphByCountSentenceTest {
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
    public void sortTest() throws NonCorrectParameterFormat {
		
		SortParagraphByCountSentence.sort(compositeText.get�ompositTextList());
		
		List<CompositeText> actual =compositeText.get�ompositTextList();
        String expected = "	��� ��������� ������������������ �� ������ ����� �����-������ �������"
        		+ " ��������� ���� �������� ��������� �������� � ��������, ������� ������ ��� ������ "
        		+ "� ����� � ������� � ������������� � �������������� FileInputStream � BufferedInputStream."
        		+ "	����� �� ������� ������ BufferedInputStream. �� ��������� �� ���� ���-��� InputStream ��� "
        		+ "������ ��� ����������, ��� ��� ���������� FileInputStream ��������.���	 ���� ����������� � "
        		+ "1 ���������. "
        		+ "	� �������� ��������������� ��������� �� ��������� ������ ������ � ������... ������ �������-��"
        		+ " ����� ������ ����� ����������� �� ����� �� �� ������ �����, � �� 200! ����-�����, ��������� �� "
        		+ "��������� ���������� ��������� � �����.��� ���� ����������� � 2 ���������.";

        	Assert.assertEquals(actual.toString(), expected);
    }
	
	
}
