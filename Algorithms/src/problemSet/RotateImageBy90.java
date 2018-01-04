package problemSet;
import java.lang.*;
import java.util.*;

//https://discuss.leetcode.com/topic/6796/a-common-method-to-rotate-the-image

public class RotateImageBy90 {
	
	/*
	 * clockwise rotate
	 * first reverse up to down, then swap the symmetry 
	 * 1 2 3     7 8 9     7 4 1
	 * 4 5 6  => 4 5 6  => 8 5 2
	 * 7 8 9     1 2 3     9 6 3
	*/
	
	public void swap(int first, int second){
		int temp = first;
		first = second;
		second = temp;
	}
	
	public void reverse(int[][] matrix){
		for(int i = 0; i < (matrix.length / 2); i++){ // Swap the top half with the lower half
			for(int j = 0; j < matrix[0].length; j++) {
				//swap(matrix[i][j], matrix[matrix.length - i - 1][j]);
				 int temp =  matrix[i][j];
				 matrix[i][j] = matrix[matrix.length - i - 1][j];
				 matrix[matrix.length - i - 1][j] = temp;		
			}
		}
	}
	
	 public void rotateClockwise(int[][] matrix) {
	     reverse(matrix);
		 // Java restriction (only by value ) making us to swap element here rather than a call to swap function
		 for(int i = 0; i < matrix.length; i++){
			 for(int j = i+1; j < matrix[0].length; j++){
				 //swap(matrix[i][j], matrix[j][i]);
				 int temp =  matrix[i][j];
				 matrix[i][j] = matrix[j][i];
				 matrix[j][i] = temp;
			  }
		  }
	 } 
	
	/*
	 * anticlockwise rotate
	 * first reverse left to right, then swap the symmetry
	 * 1 2 3     3 2 1     3 6 9
	 * 4 5 6  => 6 5 4  => 2 5 8
	 * 7 8 9     9 8 7     1 4 7
	*/
			 
	public 	void reverseRightToLeft(int [][] matrix){
		 for(int i = 0; i < matrix.length; i++){
			for(int j =0 ; j < matrix[0].length / 2 ; j++){ // Going half
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix.length - j - 1];
				matrix[i][matrix.length - j - 1] = temp;
			}
		}
	}
			 
	 public void rotateAntiClockwise(int[][] matrix) {
	    reverseRightToLeft(matrix);    
	    for(int i=0; i< matrix.length; i++){
	    	for(int j = i+1; j < matrix[0].length; j++){
	    		int temp = matrix[i][j];
	    		matrix[i][j] = matrix[j][i];
	    		matrix[j][i] = temp;
	    	}	
	    }
	 }
}
