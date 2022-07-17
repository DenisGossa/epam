package test.by.epam.trainig.action;

import by.epam.training.reader.DataReaderFromFile;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataReaderFromFileTest {

	@Test
	public void readTextFromFileTest() {

		String expectedText = " 		����� �� ������� ������ BufferedInputStream. �� ��������� �� ���� ���-"
				+ "��� InputStream ��� ������ ��� ����������, ��� ��� ���������� FileInputStream ��������.���"
				+ " ���� ����������� � 1 ���������."
				+ "    � �������� ��������������� ��������� �� ��������� ������ ������ � ������... ������ �������-"
				+ "�� ����� ������ ����� ����������� �� ����� �� �� ������ �����, � �� 200! ����-"
				+ "�����, ��������� �� ��������� ���������� ��������� � �����.��� " + "���� ����������� � 2 ���������."
				+ "    ��� ��������� ������������������ �� ������ ����� �����-������ ������� ��������� ���� �������� "
				+ "��������� �������� � ��������, ������� ������ ��� " + "������ � ����� � ������� � ������������� � "
				+ "�������������� FileInputStream � BufferedInputStream.  ";
		String actualText = null;
		try {
			actualText = DataReaderFromFile.loadData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(actualText, expectedText);
	}
}
