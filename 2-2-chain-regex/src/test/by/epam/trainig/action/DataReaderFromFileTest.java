package test.by.epam.trainig.action;

import by.epam.training.reader.DataReaderFromFile;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataReaderFromFileTest {

	@Test
	public void readTextFromFileTest() {

		String expectedText = " 		Здесь мы создали объект BufferedInputStream. Он принимает на вход объ-"
				+ "ект InputStream или любого его наследника, так что предыдущий FileInputStream подойдет.Еще"
				+ " одно предложение в 1 параграфе."
				+ "    В качестве дополнительного параметра он принимает размер буфера в байтах... Теперь благода-"
				+ "ря этому данные будут считываться из файла не по одному байту, а по 200! Пред-"
				+ "ставь, насколько мы сократили количество обращений к файлу.Еще " + "одно предложение в 2 параграфе."
				+ "    Для сравнения производительности ты можешь взять какой-нибудь большой текстовый файл размером "
				+ "несколько мегабайт и сравнить, сколько займет его " + "чтение и вывод в консоль в миллисекундах с "
				+ "использованием FileInputStream и BufferedInputStream.  ";
		String actualText = null;
		try {
			actualText = DataReaderFromFile.loadData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(actualText, expectedText);
	}
}
