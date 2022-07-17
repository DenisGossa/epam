package test.by.epam.training.action;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.epam.training.action.*;
import by.epam.training.entity.*;


public class FigureActionTest {


 // FigureAction action;
  private final static double DELTA = 0.000000000001;

 // @BeforeClass
//  public void setUp() { action = new FigureAction(); }

  private final static Pyramid PYRAMID = new Pyramid(
          Figure.createID(),
          new Point(2, 2, 0),
          new Point(10,2, 0),
          new Point(2,-6,0),
          new Point(10,-6, 0)
  );


  @Test
  public void calculateVolume() {
    //given
    double expected = 320.0;
    //when
    double actual = FigureAction.calculateVolume(PYRAMID);
    //then
    Assert.assertEquals(actual, expected);
  }
  
  @Test
  public void calculateSquare() {
    //given
    double expected = 312.386795;
    //when
    double actual = FigureAction.calculateVolume(PYRAMID);
    //then
    Assert.assertEquals(actual, expected,DELTA  );
  }
  
  

}
	
	

