package test.by.epam.training.reader;

import java.util.*;
import org.testng.Assert;
import org.testng.annotations.Test;


import by.epam.training.exception.DataFileReaderException;
import by.epam.training.reader.LoadFigureDataFromFile;


public class LoadFigureDataFromFileTest {

	
	@Test(description = "read data from file")
	 void load() throws DataFileReaderException {
	//given
	List<String> expected = Arrays.asList("10;3 5 0; 2 0 0;",
	"15; 2 2 0; 10 2 0; 2 -6 0; 10 -6 0;", 
	"17; 8 0 0 ; 14 0 0; 3g 5 0; 6  8 0; 10 11 0;",
	 " 14; 8 0 0; 14 0 0; 8 6 0;  14 6 0  ;",
	"8h;9 4 0; 7 7 0; 3 4 0; 6  13 0; 13 14 0;",
	"13;2 12 0; 5 3 0; 3 5 0; 10 11 0 7  ;",
	"19;20 19 0; 15 6 0; 8 5 0; 6  8 0; 10 11 0;",
	"7;0 0 0; 10 0 0  ; -0  10 0; 10 10 0;",
	"1; 2 0 0;",
	"71;30 0 0; 10 0 0  ; 14  10 0; 10 10 0;",
	"25;0 10 0; 10 5 0  ; -10  50 0; 10 10 0;",
	"33;0 0 0; 10 0 0  ; -20  10 0; 20 10 0");
	

	 //when
	LoadFigureDataFromFile loadFigureDataFromFile = new LoadFigureDataFromFile();
	 List<String> actual = loadFigureDataFromFile.load();
	 
	//then
	Assert.assertEquals(actual, expected);
	 }
	
}
