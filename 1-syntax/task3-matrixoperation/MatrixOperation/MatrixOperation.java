/*
 * Operation with matrix - main fuction for array
 *
 * Version 1.0
 *
 * Date 21.05.2019
 *
 * Writen by denisgossa doitnow@tut.by
 */
package MatrixOperation;

public class MatrixOperation {

/////////////////////////////////////////////////////////
//Transpose matrix
/////////////////////////////////////////////////////////
 public static double[][] transposeMatrix(double [][] m){
	        double[][] temp = new double[m[0].length][m.length];
	        for (int i = 0; i < m.length; i++)
	            for (int j = 0; j < m[0].length; j++) {
	                temp[j][i] = m[i][j];
	            }
	        return temp;
 }
	

///////////////////////////////////////////////////////
//Transpose square matrix
/////////////////////////////////////////////////////////
	
	 public static double[][] transposeSquareMatrix(double [][] m){
	    /*Transpose without temp[][] array*/
	        double tmp;
	       
	       int i, j;
	        for(int k=0;k<m[0].length;++k) {
	        	i=k;
	        	j=k;
	        	while(j<m.length) {
	        						if(i==j) {
	        									++j;
	        									continue;
	        									}
	        						else {
	        								tmp=m[i][j];
	        								m[i][j]=m[j][i];
	        								m[j][i]=tmp;
	        								++j;
	        							}
	        	}
	        	
	        }	    
	        return m;
	 }
	
///////////////////////////////////////////////////////
///*Sub func for search in array[] */
/////////////////////////////////////////////////////////
	
	 public  String findFirstLocalMinimumLinearArray(Matrix matrix) {
		 int rows=matrix.getCountRows();
		 int columns=matrix.getCountColumns();
		 double current=0.0;
		 double next=0.0;
		 double previous=0.0;
		 StringBuilder strout = new StringBuilder();
				 
		//Less then 3 elements- can't find local minimum
		 if((rows==1&&columns<3)||(columns==1&&rows<3)) {
			 return "-1";
			}//no local mininum
		
				
		//Three or More  elements in array
		 if(rows==1&&columns>=3) {
			 for(int i=0,j=1;j<columns-1;++j){
				 try {
		 				current = matrix.getElement(i, j); 
		 				if(matrix.isValidRange(i, j+1)) {  
		 					next = matrix.getElement(i, j+1);
		 				}
		 				else {
		 					break;
		 				}
		 				previous=matrix.getElement(i, j-1); 
				 	}catch(Exception e) {
				 		e.printStackTrace();
		 				}
				 if(previous>current&&current<next) {
				 		strout.append("(" + i + "," + j + ")\n");
				 		return strout.toString();
				 }
			  	else {
			 		continue;
				}
				 
			 }
		 }
	
		if(columns==1&&rows>=3){ 
			 for(int i=1,j=0;i<rows-1;++i){
				 try {
		 			current = matrix.getElement(i, j); 
		 			if(matrix.isValidRange(i+1, j)) {  
		 				next = matrix.getElement(i+1, j);
		 			}
		 			else {
		 				break;
		 			}
		 			previous=matrix.getElement(i-1, j); 
				 }catch(Exception e) {
					 e.printStackTrace();
		 			}
				 if(current<previous&&current<next) {
					 strout.append("(" + i + "," + j + ")\n");
					 return strout.toString();
				 }
			 
				 else {
					 continue;
				 }
			}
				 
		}	 
		
	 return "-1";
 } 
	 
///////////////////////////////////////////////////////
///*Sub func for search in array[] */
/////////////////////////////////////////////////////////
	 public  String findFirstLocalMaximumLinearArray(Matrix matrix) {
		 int rows=matrix.getCountRows();
		 int columns=matrix.getCountColumns();
		 double current=0.0;
		 double next=0.0;
		 double previous=0.0;
		 StringBuilder strout = new StringBuilder();
				 
		//Less then 3 elements- can't find local minimum
		 if((columns==1&&rows<3)||(rows==1&&columns<3)) {
			 return "-1";
			}//no local mininum
		 if(rows==1&&columns>=3) {
			 for(int i=0,j=1;j<columns-1;++j){
				 try {
		 				current = matrix.getElement(i, j); 
		 				if(matrix.isValidRange(i, j+1)) {  
		 					next = matrix.getElement(i, j+1);
		 				}
		 				else {
		 					break;
		 				}
		 				previous=matrix.getElement(i, j-1); 
				 	}catch(Exception e) {
				 		e.printStackTrace();
		 				}
				 if(previous<current&&current>next) {
				 		strout.append("(" + i + "," + j + ")\n");
				 		return strout.toString();
				 }
			 
				 else {
				 	continue;
				 		}
				 
			 }
		 }
	
		if(columns==1&&rows>=3){ 
			 for(int i=1,j=0;i<rows-1;++i){
				 try {
		 			current = matrix.getElement(i, j); 
		 			if(matrix.isValidRange(i+1, j)) {  
		 				next = matrix.getElement(i+1, j);
		 			}
		 			else {
		 				break;
		 				}
		 			previous=matrix.getElement(i-1, j); 
				 }catch(Exception e) {
					 e.printStackTrace();
		 			 }
				 if(current>previous&&current>next) {
					 strout.append("(" + i + "," + j + ")\n");
					 return strout.toString();
				 }
			 
				 else {
					 continue;
					 }
			}
				 
		}	 
		 
				
		//Three or More  elements in array
		 
	 return "-1";
 } 
/////////////////////////////////////////////////////////
//  Function for search FirstLocalMinimum
/////////////////////////////////////////////////////////
	 public  String findFirstLocalMinimum(Matrix matrix) {
		 int rows=matrix.getCountRows();
		 int columns=matrix.getCountColumns();
		 double current=0.0;
		
		 StringBuilder strout = new StringBuilder();
		
		 //if only one line in array
		if(rows==1||columns==1) {
			return findFirstLocalMinimumLinearArray(matrix);
			}
		
	
	/*
	 * 				leftupdiag    strictup    rightupdiag
	 * 				[r-1][j-1]  [r-1][j]   [r-1][j+1]
	 * 					  		
	 * strictleft	[r][j-1]	  elem     [r][j+1]   strictright
	 * 
	 * 				[r+1][j-1]  [r+1][j]   [r+1][j+1]
	 * leftdowndiag            strictdown     rightdowndiag
	 * 
	 */
		 
		 double leftupdiag=0.0;
		 double strictleft=0.0;
		 double leftdowndiag=0.0;
		 double strictup=0.0;
		 double rightupdiag=0.0;
		 double strictright=0.0;
		 double strictdown=0.0;
		 double rightdowndiag=0.0;
		 
		 
		 for(int i=0;i<rows;++i)
			for(int j=0;j<columns;++j) {
				 
//left upper corner
			if(i==0&&j==0) {
			 					
				try {
					current=matrix.getElement(i, j);
					strictright=matrix.getElement(i, j+1);
					strictdown=matrix.getElement(i+1, j);
				 	rightdowndiag=matrix.getElement(i+1, j+1);
				 																
				 	}catch(Exception e) {
				 		//System.err.println("Fail in left upper corner " + e);
				 		e.printStackTrace();
				 		}
				 								
				 if((current<strictright)&&(current<strictdown)&&(current<rightdowndiag)) {
					 strout.append("(" + i + "," + j + ")\n");
					 return strout.toString();
				 }		 								
			}
//right upper corner
			if(i==0&&j==columns-1) {
											
				try {
					current=matrix.getElement(i, j);
				 	strictleft=matrix.getElement(i, j-1);
				 	strictdown=matrix.getElement(i+1, j);
				 	leftdowndiag=matrix.getElement(i+1, j-1);
				 	}catch(Exception e) {
				 		//System.err.println("Fail in right upper corner " + e);
				 		e.printStackTrace();
				 		}
				 								
				 if((current<strictleft)&&(current<strictdown)&&(current<leftdowndiag)) {
					 strout.append("(" + i + "," + j + ")\n");
					 return strout.toString();
				 }		 								
			}
				 
//right down corner
			if((i==rows-1) &&(j==columns-1)) {
			 								
				try {
					current=matrix.getElement(i, j);
				 	strictleft=matrix.getElement(i, j-1);
				 	strictup=matrix.getElement(i-1, j);
				 	leftupdiag=matrix.getElement(i-1, j-1);													
				 	}catch(Exception e) {
				 		//System.err.println("Fail in right down corner " + e);
				 		e.printStackTrace();
				 		}
				if((current<strictleft)&&(current<strictup)&&(current<leftupdiag)) {
					strout.append("(" + i + "," + j + ")\n");
				 	return strout.toString();
				}		 								
			}
				 
//left down corner
			if((i==rows-1)&&(j==0)) {
				try {
					current=matrix.getElement(i, j);
				 	strictup=matrix.getElement(i-1, j);
				 	strictright=matrix.getElement(i, j+1);
				 	rightupdiag=matrix.getElement(i-1, j+1);
					}catch(Exception e) {
						//System.err.println("Fail in left down corner " + e);
						e.printStackTrace();
				 		}
				if((current<strictleft)&&(current<strictdown)&&(current<leftdowndiag)) {
					strout.append("(" + i + "," + j + ")\n");
				 	return strout.toString();
				 }		 								
			}
				 
//left border
			if((0<i&&i<rows-1)&&(j==0)) {
				try {
					current=matrix.getElement(i, j);
				 	strictup=matrix.getElement(i-1, j);
				 	strictright=matrix.getElement(i, j+1);
				 	strictdown=matrix.getElement(i+1, j);
				 	rightupdiag=matrix.getElement(i-1, j+1);
				 	rightdowndiag=matrix.getElement(i+1, j+1);
				 	}catch(Exception e) {
				 		//System.err.println("Fail in left border " + e);
				 		e.printStackTrace();
				 		}
				if((current<strictup)&&(current<strictright)&&(current<strictdown)
					&&(current<	rightupdiag)&&(current<rightdowndiag)){
						strout.append("(" + i + "," + j + ")\n");
				 		return strout.toString();
				 }		 								
			}
//right border
		if((0<i&&i<rows-1)&&(j==columns-1)) {
			try {
				current=matrix.getElement(i, j);
				strictup=matrix.getElement(i-1, j);
				strictleft=matrix.getElement(i, j-1);
				strictdown=matrix.getElement(i+1, j);
				leftupdiag=matrix.getElement(i-1, j-1);
				leftdowndiag=matrix.getElement(i+1, j-1);
			}catch(Exception e) {
				//System.err.println("Fail in right border " + e);
				e.printStackTrace();
				}
			if((current<strictup)&&(current<strictleft)&&(current<strictdown)
				&&(current <	leftupdiag)&&(current < leftdowndiag)){
					strout.append("(" + i + "," + j + ")\n");
				 	return strout.toString();
			}		 								
		}
//upper border
		if((i==0)&&((0<j)&&(j<columns-1))) {
			try {
				current=matrix.getElement(i, j);
				strictdown=matrix.getElement(i+1, j);
				strictleft=matrix.getElement(i, j-1);
				strictright=matrix.getElement(i, j+1);
				rightdowndiag=matrix.getElement(i+1, j+1);
				leftdowndiag=matrix.getElement(i+1, j-1);
				}catch(Exception e) {
					e.printStackTrace();
				 	//System.err.println("Fail in upper border " + e);
					}
			if((current<strictdown)&&(current<strictleft)&&(current<strictright)
				&&(current <	rightdowndiag)&&(current < leftdowndiag)){
					return strout.toString();
			}		 								
		}
//lower border
		if((i==rows-1)&&((0<j)&&(j<columns-1))) {
			try {
				current=matrix.getElement(i, j);
				strictup=matrix.getElement(i-1, j);
				strictleft=matrix.getElement(i, j-1);
				strictright=matrix.getElement(i, j+1);
				rightupdiag=matrix.getElement(i-1, j+1);
				leftupdiag=matrix.getElement(i-1, j-1);
			}catch(Exception e) {
				e.printStackTrace();
				//System.err.println("Fail in Getting from matrix " + e);
				}
			if((current<strictup)&&(current<strictleft)&&(current<strictright)
				&&(current <rightupdiag)&&(current < leftupdiag)){
				 	strout.append("(" + i + "," + j + ")\n");
				 	return strout.toString();
			}		 								
		}
//central elements
		if(((0<i)&&(i<rows-1))&&((0<j)&&(j<columns-1))) {
			try {
				current=matrix.getElement(i, j);
				strictup=matrix.getElement(i-1, j);
				strictdown=matrix.getElement(i+1, j);
				strictleft=matrix.getElement(i, j-1);
				strictright=matrix.getElement(i, j+1);
				rightupdiag=matrix.getElement(i-1, j+1);
				leftupdiag=matrix.getElement(i-1, j-1);
				rightdowndiag=matrix.getElement(i+1, j+1);
				leftdowndiag=matrix.getElement(i+1, j-1);
			}catch(Exception e) {
				e.printStackTrace();
				//System.err.println("Fail in central elements " + e);
		 		}
			if((current<strictup)&&(current<strictleft)&&(current<strictright)
					&&(current <rightupdiag)&&(current < leftupdiag)){
				
					strout.append("(" + i + "," + j + ")\n");
					return strout.toString();
			}		 								
		}
	}
return "-1"; 
}

/////////////////////////////////////////////////////////
//Function for search FirstLocalMaximum
/////////////////////////////////////////////////////////
	 public  String findFirstLocalMaximum(Matrix matrix) {
		 int rows=matrix.getCountRows();
		 int columns=matrix.getCountColumns();
		 double current=0.0;
		 
		 StringBuilder strout = new StringBuilder();
		
		//if only one line in array
		 if(rows==1||columns==1) {
			 return findFirstLocalMaximumLinearArray(matrix);
			 }
		 		 
		 
	/*
	 * 
	 * 				leftupdiag    strictup    rightupdiag
	 * 				[r-1][j-1]  [r-1][j]   [r-1][j+1]
	 * 					  		
	 * strictleft	[r][j-1]	  elem     [r][j+1]   strictright
	 * 
	 * 				[r+1][j-1]  [r+1][j]   [r+1][j+1]
	 * leftdowndiag            strictdown     rightdowndiag
	 * 
	 * 
	 */
		 
	double leftupdiag=0.0;
	double strictleft=0.0;
	double leftdowndiag=0.0;
	double strictup=0.0;
	double rightupdiag=0.0;
	double strictright=0.0;
	double strictdown=0.0;
	double rightdowndiag=0.0;
		 
		 
for(int i=0;i<rows;++i)
	for(int j=0;j<columns;++j) {
//left upper corner
		if(i==0&&j==0) {
			try {
				current=matrix.getElement(i, j);
				strictright=matrix.getElement(i, j+1);
				strictdown=matrix.getElement(i+1, j);
				rightdowndiag=matrix.getElement(i+1, j+1);
				}catch(Exception e) {
					e.printStackTrace();
				 	//	System.err.println("Fail in left upper corner " + e);
		}
			if((current>strictright)&&(current>strictdown)&&(current>rightdowndiag)) {
				strout.append("(" + i + "," + j + ")\n");
				return strout.toString();
			}		 								
		}
//right upper corner
		if(i==0&&j==columns-1) {
			try {
				current=matrix.getElement(i, j);
				strictleft=matrix.getElement(i, j-1);
				strictdown=matrix.getElement(i+1, j);
				leftdowndiag=matrix.getElement(i+1, j-1);
				}catch(Exception e) {
					e.printStackTrace();
				 	//System.err.println("Fail in right upper corner " + e);
		 			}
			if((current>strictleft)&&(current>strictdown)&&(current>leftdowndiag)) {
				strout.append("(" + i + "," + j + ")\n");
				return strout.toString();
			}		 								
		}
//right down corner
		if((i==rows-1) &&(j==columns-1)) {
			try {
				current=matrix.getElement(i, j);
				strictleft=matrix.getElement(i, j-1);
				strictup=matrix.getElement(i-1, j);
				leftupdiag=matrix.getElement(i-1, j-1);
				}catch(Exception e) {
					e.printStackTrace();
				 	//System.err.println("Fail in right down corner" + e);
					}
			if((current>strictleft)&&(current>strictup)&&(current>leftupdiag)) {
				strout.append("(" + i + "," + j + ")\n");
				return strout.toString();
				}		 								
		}
//left down corner
		if((i==rows-1)&&(j==0)) {
			try {
				current=matrix.getElement(i, j);
				strictup=matrix.getElement(i-1, j);
				strictright=matrix.getElement(i, j+1);
				rightupdiag=matrix.getElement(i-1, j+1);
				}catch(Exception e) {
					e.printStackTrace();
				 	//System.err.println("Fail in left down corner " + e);
		 			}
			if((current>strictleft)&&(current>strictdown)&&(current>leftdowndiag)) {
				strout.append("(" + i + "," + j + ")\n");
				return strout.toString();
			}		 								
		}
//left border
		if((0<i&&i<rows-1)&&(j==0)) {
			try {
				current=matrix.getElement(i, j);
				strictup=matrix.getElement(i-1, j);
				strictright=matrix.getElement(i, j+1);
				strictdown=matrix.getElement(i+1, j);
				rightupdiag=matrix.getElement(i-1, j+1);
				rightdowndiag=matrix.getElement(i+1, j+1);
				}catch(Exception e) {
					e.printStackTrace();
				 	//System.err.println("Fail in left border " + e);
		 			}
			if((current>strictup)&&(current>strictright)&&(current>strictdown)
				&&(current<	rightupdiag)&&(current<rightdowndiag)){
				 	strout.append("(" + i + "," + j + ")\n");
				 	return strout.toString();
			}		 								
		}
//right border
		if((0<i&&i<rows-1)&&(j==columns-1)) {
			try {
				current=matrix.getElement(i, j);
				strictup=matrix.getElement(i-1, j);
				strictleft=matrix.getElement(i, j-1);
				strictdown=matrix.getElement(i+1, j);
				leftupdiag=matrix.getElement(i-1, j-1);
				leftdowndiag=matrix.getElement(i+1, j-1);
				}catch(Exception e) {
					e.printStackTrace();
				 	//System.err.println("Fail in right border " + e);
					}
			if((current>strictup)&&(current>strictleft)&&(current>strictdown)
				&&(current >	leftupdiag)&&(current > leftdowndiag)){
					strout.append("(" + i + "," + j + ")\n");
					return strout.toString();
			}		 								
		}
//upper border
		if((i==0)&&((0<j)&&(j<columns-1))) {
			try {
				current=matrix.getElement(i, j);
				strictdown=matrix.getElement(i+1, j);
				strictleft=matrix.getElement(i, j-1);
				strictright=matrix.getElement(i, j+1);
				rightdowndiag=matrix.getElement(i+1, j+1);
				leftdowndiag=matrix.getElement(i+1, j-1);
				}catch(Exception e) {
					e.printStackTrace();
				 	//System.err.println("Fail in upper border " + e);
					}
			if((current>strictdown)&&(current>strictleft)&&(current>strictright)
				&&(current >	rightdowndiag)&&(current > leftdowndiag)){
					strout.append("(" + i + "," + j + ")\n");
				 	return strout.toString();
			}		 								
		}
//lower border
		if((i==rows-1)&&((0<j)&&(j<columns-1))) {
			try {
				current=matrix.getElement(i, j);
				strictup=matrix.getElement(i-1, j);
				strictleft=matrix.getElement(i, j-1);
				strictright=matrix.getElement(i, j+1);
				rightupdiag=matrix.getElement(i-1, j+1);
				leftupdiag=matrix.getElement(i-1, j-1);
				}catch(Exception e) {
					e.printStackTrace();
				 	//System.err.println("Fail in lower border " + e);
		 			}
			if((current > strictup)&&(current > strictleft)&&(current > strictright)
				&&(current >rightupdiag)&&(current > leftupdiag)){
				 	strout.append("(" + i + "," + j + ")\n");
				 	return strout.toString();
			}		 								
		}
//central elements
		if(((0<i)&&(i<rows-1))&&((0<j)&&(j<columns-1))) {
			try {
				current=matrix.getElement(i, j);
				strictup=matrix.getElement(i-1, j);
				strictdown=matrix.getElement(i+1, j);
				strictleft=matrix.getElement(i, j-1);
				strictright=matrix.getElement(i, j+1);
				rightupdiag=matrix.getElement(i-1, j+1);
				leftupdiag=matrix.getElement(i-1, j-1);
				rightdowndiag=matrix.getElement(i+1, j+1);
				leftdowndiag=matrix.getElement(i+1, j-1);
				}catch(Exception e) {
					e.printStackTrace();
				 	//System.err.println("Fail in central elements " + e);
		 			}
			if((current > strictup)&&(current > strictleft)&&(current > strictright)
				&&(current > strictdown)&&(current > rightupdiag )&&(current > leftupdiag)
				&&(current > rightdowndiag)&&(current > leftdowndiag)){
					strout.append("(" + i + "," + j + ")\n");
					return strout.toString();
			}		 								
		}
				 
	}
	return "-1";
}


/////////////////////////////////////////////////////////
//Function for search FifindMinimum
/////////////////////////////////////////////////////////	
public String findMinimum(Matrix matrix) {
	int rows=matrix.getCountRows();
	int columns=matrix.getCountColumns();
	double minvalue,tmp;
	StringBuilder strout = new StringBuilder();
		 
		 
		//get first
	try {
		if(matrix.isValidRange(0, 0)) {
			minvalue=matrix.getElement(0, 0);
			strout.append("value: "+minvalue +" index:"+" (" + 0 + "," + 0 + ")\n");
		}
		else {
			return "-1";
			 } 
		 
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				tmp=matrix.getElement(i, j);
				if(tmp<minvalue) {
					minvalue=tmp;
					strout.setLength(0);
					strout.append("value="+minvalue + " index:"+"(" + i + "," + j + ")\n");
				}
			 	//else {continue;}
			 }
		}
		 
	}catch(Exception e) {	
		System.err.println("Fail in findMinimum " + e);
		e.printStackTrace();	
		}
				 
	return strout.toString();	 
		 
}
/////////////////////////////////////////////////////////
//Function for search FifindMaximum
/////////////////////////////////////////////////////////	 
public String findMaximum(Matrix matrix) {
	int rows=matrix.getCountRows();
	int columns=matrix.getCountColumns();
		
	StringBuilder strout = new StringBuilder();
	double maxvalue,tmp;
//get first
	try {
		if(matrix.isValidRange(0, 0)) {
			maxvalue=matrix.getElement(0, 0);
			strout.append("value: "+maxvalue +" index "+" (" + 0 + "," + 0 + ")\n");
		 }
		else {
			return "-1";
			} 
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				tmp=matrix.getElement(i, j);
				
				if(maxvalue<tmp) {
					maxvalue=tmp;
					strout.setLength(0);
					strout.append("value="+maxvalue +" index:"+"(" + i + "," + j + ")\n");
			 	}
				//else {continue;}
			 }
		}
	}catch(Exception e) {
		System.err.println("Fail in findMaximum " + e);
		e.printStackTrace();	
		}
			
	return strout.toString();	 
		 
}

/////////////////////////////////////////////////////////
//Function for search Average Geometric
/////////////////////////////////////////////////////////
public double findAverageGeom(Matrix matrix) {
	int rows=matrix.getCountRows();
	int columns=matrix.getCountColumns();
		
	double tmp=1.0;
	int count=0;
		
//get first
				 
	try {
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				tmp*=matrix.getElement(i, j);
				++count;
		 	}
		}
		 
	}catch(Exception e) {
		System.err.println("Fail in findAverageGeom " + e);
		e.printStackTrace();			}
		 
	return (double)Math.pow(tmp, (double)1/count); 
		 
}
/////////////////////////////////////////////////////////
//Function for search Average Arithmetic
/////////////////////////////////////////////////////////	
public double findAverageArithmetic(Matrix matrix) {
	int rows=matrix.getCountRows();
	int columns=matrix.getCountColumns();
		
	double tmp=0.0;
	int count=0;
		
//get first
	try {
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				tmp+=matrix.getElement(i, j);
				++count;
			}
		}
	}catch(Exception e) {
		System.err.println("Fail in findAverageArithmetic " + e);
		e.printStackTrace();		
		}
		 
	return (double)(tmp/count); 
		 
}
	 
/////////////////////////////////////////////////////////
//Function for setting array random values
/////////////////////////////////////////////////////////	 
public  void setRNDValue(Matrix matrix,double minrandom, double maxrandom) {
	int rows = matrix.getCountRows();
	int columns = matrix.getCountColumns();
	double tmp;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				try {
					tmp = (Math.random() * (maxrandom - minrandom) + minrandom);
	                tmp= (double)Math.round(tmp * 10d) / 10d;
	                matrix.setElement(i, j, tmp);
	            	}catch (Exception e) {
	            		System.err.println("Fail in Generate Matrix " + e);
	            		e.printStackTrace();	
	              	    }
	         }
	     }
 }  

}
