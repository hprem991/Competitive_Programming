package problemSet;
import java.lang.*;
import java.util.*;

public class SpiralMatrix {
	 public List<Integer> spiralOrder(int[][] matrix) {
		 
		 List<Integer> res =  new ArrayList<Integer>();
		    
		 	int rowStart = 0, columnStart = 0;
		 	int rowEnds = matrix.length - 1, columnEnds = matrix[0].length - 1;
		 	
		 	while((rowStart <= rowEnds) && (columnStart <= columnEnds)){
		 		
		 		// traverse Right
		 		for(int i = columnStart; i <= columnEnds; i++){
		 			 res.add(matrix[rowStart][i]);
		 		}
		 		
		 		rowStart++;
		 		
		 		// Running down
		 		for(int i = rowStart; i <= rowEnds; i++){
		 			 res.add(matrix[i][columnEnds]);
		 		}
		 		
		 		columnEnds--;
		 		
		 		// Before traversing left and up, make sure you got enough indexes
		 		
		 		//  going left
		 		if(rowStart <= rowEnds){
		 			 for( int i = columnEnds; i >= columnStart; i--){
		 				 res.add(matrix[rowEnds][i]);
		 			 }
		 		}
		 		
		 		rowEnds--;
		 		
		 		// going up
		 		if(columnStart <= columnEnds){
		 			 for( int i = rowEnds; i >= rowStart; i--){
		 				 res.add(matrix[i][columnStart]);
		 			 }
		 		}
		 	   columnStart++;
		 	}
		 	
		 	return res;
		 	
	 }
}
