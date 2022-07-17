/*
 * Operation with matrix - main container for array
 *
 * Version 1.0
 *
 * Date 21.05.2019
 *
 * Writen by denisgossa doitnow@tut.by
 */
package MatrixOperation;

public class Matrix {

	private double[][] array;
	private static final int DEF_SIZE = 5;
/////////////////////////////////////////////////	
	Matrix(){
		array=new double [DEF_SIZE][DEF_SIZE];
	}
	
/////////////////////////////////////////////////	
	public Matrix(double[][] array) {
        this.array = array;
    }
/////////////////////////////////////////////////
    public Matrix(int rows, int columns){
        if(rows<0) {rows=-rows;}
        if(columns<0) {columns=-columns;}
        	
        
        	array = new double[rows][columns];
       
    }

   
 /////////////////////////////////////////////////   
    public Matrix(Matrix matrix) {
    //	int i = matrix.length;
     //   int j = matrix[.length;
    	
    	try {
    	array=new double[matrix.array.length][ matrix.array[0].length];
        for (int i = 0; i < matrix.array.length; i++) {
            for (int j = 0; j < matrix.array[i].length; j++) {
                array[i][j] = matrix.array[i][j];
            }
        }
        
      } catch (Exception e) {
            e.printStackTrace();
        }
	
    }
/////////////////////////////////////////////////    
    public int getCountRows() {
        return array.length;
    }
/////////////////////////////////////////////////
    public int getCountColumns() {
        return array[0].length;
    }
/////////////////////////////////////////////////
    public double getElement(int i, int j) throws Exception{
    	 if (isValidRange(i, j)) {
             return array[i][j];
         } else {
  	         throw new Exception();
       		 }
    	
    	  	
    }
/////////////////////////////////////////////////
    public void setElement(int i, int j, double element)throws Exception{
        if(isValidRange(i, j)) {
        	array[i][j]	= element;
        	
        }else {
        	throw new Exception();
           	}
              
    }
    
 ////////////////////////////////////////////
  boolean  isValidRange(int i, int j) {
	  if(i<0||i>array.length-1||j<0||j>array[0].length-1) {
		  return false;
	  }
	  else {
		  return true;
	  }
  }   
	
////////////////////////////////////////////////	
	public double[][] getArray(){
		return this.array;
	}
  
  
///////////////////////////////////////////////// 
  @Override
  public String toString() {
      int rows = array.length;
      int columns = array[0].length;
      StringBuilder strBuild = new StringBuilder("\nMatrix (" + rows + "," + columns + ")\n");

      for (int i = 0; i < rows; i++) {
          for (int j = 0; j < columns; j++) {
              strBuild.append(array[i][j] + "   ");
          }
          strBuild.append("\n");
      }
      return strBuild.toString();
  }




}
