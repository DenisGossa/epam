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
		
		SortParagraphByCountSentence.sort(compositeText.getСompositTextList());
		
		List<CompositeText> actual =compositeText.getСompositTextList();
        String expected = "	Для сравнения производительности ты можешь взять какой-нибудь большой"
        		+ " текстовый файл размером несколько мегабайт и сравнить, сколько займет его чтение "
        		+ "и вывод в консоль в миллисекундах с использованием FileInputStream и BufferedInputStream."
        		+ "	Здесь мы создали объект BufferedInputStream. Он принимает на вход объ-ект InputStream или "
        		+ "любого его наследника, так что предыдущий FileInputStream подойдет.Еще	 одно предложение в "
        		+ "1 параграфе. "
        		+ "	В качестве дополнительного параметра он принимает размер буфера в байтах... Теперь благода-ря"
        		+ " этому данные будут считываться из файла не по одному байту, а по 200! Пред-ставь, насколько мы "
        		+ "сократили количество обращений к файлу.Еще одно предложение в 2 параграфе.";

        	Assert.assertEquals(actual.toString(), expected);
    }
	
	
}
