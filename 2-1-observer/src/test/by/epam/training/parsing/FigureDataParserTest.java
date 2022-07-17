package test.by.epam.training.parsing;

import java.util.*;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.epam.training.parsing.FigureDataParser;

public class FigureDataParserTest {

	
	String str1 = "10;3 5 0; 2 0 0; ";
	String str2 ="15; 2 2 0; 10 2 0; 2 -6 0; 10 -6 0;"; 
	String str3 = "14; 8 0 0; 14 0 0; 8 6 0;  14 6 0  ; ";
	String str4 ="13;2 12 0; 5 3 0; 3 5 0; 10 11 0 7  ;";
	String str5 ="19;20 19 0; 15 6 0; 8 5 0; 6  8 0; 10 11 0;";
	String str6 ="7;0 0 0; 10 0 0  ; -0  10 0; 10 10 0;";
	String str7 ="1; 2 0 0;";
	String str8 ="	71;30 0 0; 10 0 0  ; 14  10 0; 10 10 0;";
	String str9 ="25;0 10 0; 10 5 0  ; -10  50 0; 10 10 0;";
	String str10 ="33;0 0 0; 10 0 0  ; -20  10 0; 20 10 0;";

	@Test
	void parseValues() {
		 FigureDataParser  figureDataParser = new  FigureDataParser();
		
		List<Integer>	expected1,expected2,expected3,expected4,expected5,
						expected6,expected7,expected8,expected9,expected10;
		
		
		expected1 = figureDataParser.parseValues(str1);
		expected2 = figureDataParser.parseValues(str2);
		expected3 = figureDataParser.parseValues(str3);
		expected4 = figureDataParser.parseValues(str4);
		expected5 = figureDataParser.parseValues(str5);
		expected6= figureDataParser.parseValues(str6);
		expected7= figureDataParser.parseValues(str7);
		expected8= figureDataParser.parseValues(str8);
		expected9= figureDataParser.parseValues(str9);
		expected10= figureDataParser.parseValues(str10);
		
		
		 Assert.assertEquals(str1, expected1 );
		 Assert.assertEquals(str2, expected1 );
		 Assert.assertEquals(str3, expected1 );
		 Assert.assertEquals(str4, expected1 );
		 Assert.assertEquals(str5, expected1 );
		 Assert.assertEquals(str6, expected1 );
		 Assert.assertEquals(str7, expected1 );
		 Assert.assertEquals(str8, expected1 );
		 Assert.assertEquals(str9, expected1 );
		 Assert.assertEquals(str10, expected1 );

	}

	
}
