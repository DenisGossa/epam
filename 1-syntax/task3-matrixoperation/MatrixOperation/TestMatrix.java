/*
 * Operation with matrix - Test area
 *
 * Version 1.0
 *
 * Date 21.05.2019
 *
 * Writen by denisgossa doitnow@tut.by
 */

package MatrixOperation;

public class TestMatrix {

	
	public static void main(String[] args) {
		
		double[][] arr1= {
				{3,3,5,4,8,2},
				{2,5,1,6,4,7},
				{1,5,1,2,8,8},	
		};
		double[][] arr2= {
				{1,3,5,7},
				{2,4,8,67},
				{23,22,-5,28},	
				{21,20,70,13}
		};
		double[][] arr3= {
				{1,3,9,7},
				{2,4,9,67},
				{23,22,7,28},	
				{10,20,70,2},
				{19,20,70,2},
				{19,20,70,2}
		};
		double[][] arr4= {
				{1},
				{6},
				{4},
				{1}
				
				
				
		};
		double[][] arr5= {
				{6,9,7}
				
		};
		
		
		MatrixOperation mOp=new MatrixOperation();
		
////////////////////////////////////////////////////////////////////
//operation with arr1
///////////////////////////////////////////////////////////////////
				
		Matrix matrix=new  Matrix(arr1);
		
		System.out.print( matrix);
		System.out.println("FirstLocalMaximum: " + 	mOp.findFirstLocalMaximum(matrix));
		System.out.println("FirstLocalMinimum: " + 	mOp.findFirstLocalMinimum(matrix));
		System.out.println("findMinimum: " + mOp.findMinimum(matrix));
		System.out.println("findMaximum: " + mOp.findMaximum(matrix));
		System.out.println("findAverageGeom: " + 	mOp.findAverageGeom(matrix));
		System.out.println("findAverageArithm: " + 	mOp.findAverageArithmetic(new Matrix(matrix)));
		matrix=new Matrix(mOp.transposeMatrix(matrix.getArray())  );
		System.out.println("Transposed arr: " + matrix);
		System.out.println("////////////////////////////////////////////////" );
		
////////////////////////////////////////////////////////////////////
//operation with arr2
///////////////////////////////////////////////////////////////////
		matrix=new  Matrix(arr2);
		
		System.out.println(matrix);
		System.out.println("FirstLocalMaximum: " + 	mOp.findFirstLocalMaximum(matrix));
		System.out.println("FirstLocalMinimum: " + 	mOp.findFirstLocalMinimum(matrix));
		System.out.println("findMinimum: " + mOp.findMinimum(matrix));
		System.out.println("findMaximum: " + mOp.findMaximum(matrix));
		System.out.println("findAverageGeom: " + 	mOp.findAverageGeom(matrix));
		System.out.println("findAverageArithm: " + 	mOp.findAverageArithmetic(new Matrix(matrix)));
		matrix=new Matrix(mOp.transposeMatrix(matrix.getArray())  );
		System.out.println("Transposed arr: " + matrix);
		System.out.println("////////////////////////////////////////////////" );
		
////////////////////////////////////////////////////////////////////
//operation with arr3
///////////////////////////////////////////////////////////////////
		matrix=new  Matrix(arr3);
			
		System.out.println(matrix);
		System.out.println("FirstLocalMaximum: " + 	mOp.findFirstLocalMaximum(matrix));
		System.out.println("FirstLocalMinimum: " + 	mOp.findFirstLocalMinimum(matrix));
		System.out.println("findMinimum: " + mOp.findMinimum(matrix));
		System.out.println("findMaximum: " + mOp.findMaximum(matrix));
		System.out.println("findAverageGeom: " + 	mOp.findAverageGeom(matrix));
		System.out.println("findAverageArithm: " + 	mOp.findAverageArithmetic(new Matrix(matrix)));
		matrix=new Matrix(mOp.transposeMatrix(matrix.getArray())  );
		System.out.println("Transposed arr: " + matrix);	
		System.out.println("////////////////////////////////////////////////" );
		
////////////////////////////////////////////////////////////////////
//operation with arr4
///////////////////////////////////////////////////////////////////
matrix=new  Matrix(arr4);

		System.out.println(matrix);
		System.out.println("FirstLocalMaximum: " + 	mOp.findFirstLocalMaximum(matrix));
		System.out.println("FirstLocalMinimum: " + 	mOp.findFirstLocalMinimum(matrix));
		System.out.println("findMinimum: " + mOp.findMinimum(matrix));
		System.out.println("findMaximum: " + mOp.findMaximum(matrix));
		System.out.println("findAverageGeom: " + 	mOp.findAverageGeom(matrix));
		System.out.println("findAverageArithm: " + 	mOp.findAverageArithmetic(new Matrix(matrix)));
		matrix=new Matrix(mOp.transposeMatrix(matrix.getArray())  );
		System.out.println("Transposed arr: " + matrix);	
		System.out.println("////////////////////////////////////////////////" );

////////////////////////////////////////////////////////////////////
//operation with arr5
///////////////////////////////////////////////////////////////////
		matrix=new  Matrix(arr5);

		System.out.println(matrix);
		System.out.println("FirstLocalMaximum: " + 	mOp.findFirstLocalMaximum(matrix));
		System.out.println("FirstLocalMinimum: " + 	mOp.findFirstLocalMinimum(matrix));
		System.out.println("findMinimum: " + mOp.findMinimum(matrix));
		System.out.println("findMaximum: " + mOp.findMaximum(matrix));
		System.out.println("findAverageGeom: " + 	mOp.findAverageGeom(matrix));
		System.out.println("findAverageArithm: " + 	mOp.findAverageArithmetic(new Matrix(matrix)));
		matrix=new Matrix(mOp.transposeMatrix(matrix.getArray()));
		System.out.println("Transposed arr: " + matrix);
		System.out.println("////////////////////////////////////////////////" );

		
////////////////////////////////////////////////////////////////////
//operation with Random Values
///////////////////////////////////////////////////////////////////		
		
		matrix=new Matrix(8,5);
		mOp.setRNDValue(matrix, 2, 22);
		System.out.println(matrix);
		
		System.out.println("FirstLocalMaximum: " + 	mOp.findFirstLocalMaximum(matrix));
		System.out.println("FirstLocalMinimum: " + 	mOp.findFirstLocalMinimum(matrix));
		System.out.println("findMinimum: " + mOp.findMinimum(matrix));
		System.out.println("findMaximum: " + mOp.findMaximum(matrix));
		System.out.println("findAverageGeom: " + 	mOp.findAverageGeom(matrix));
		System.out.println("findAverageArithm: " + 	mOp.findAverageArithmetic(matrix));
		matrix=new Matrix(mOp.transposeMatrix(matrix.getArray())  );
		System.out.println("Transposed arr: " + matrix);
		System.out.println("////////////////////////////////////////////////" );
	}

	
	
	
}
