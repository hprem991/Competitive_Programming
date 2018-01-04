package problemSet;
import java.lang.*;
import java.util.*;

//https://www.youtube.com/watch?v=yCQN096CwWM

//http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/
// Given a 2D array, find the maximum sum subarray in it.

public class MaximumSumRectangle {
	
	
	 class Result{
	        int maxSum;
	        int leftBound;
	        int rightBound;
	        int upBound;
	        int lowBound;
	        @Override
	        public String toString() {
	            return "Result [maxSum=" + maxSum + ", leftBound=" + leftBound
	                    + ", rightBound=" + rightBound + ", upBound=" + upBound
	                    + ", lowBound=" + lowBound + "]";
	        }
	        
	    }
	    
	 class KadaneResult{
	        int maxSum;
	        int start;
	        int end;
	        public KadaneResult(int maxSum, int start, int end) {
	            this.maxSum = maxSum;
	            this.start = start;
	            this.end = end;
	        }
	    }
	 
	 private KadaneResult kadane(int arr[]){
	        int max = 0;
	        int maxStart = -1;
	        int maxEnd = -1;
	        int currentStart = 0;
	        int maxSoFar = 0;
	        for(int i=0; i < arr.length; i++){
	            maxSoFar += arr[i];
	            if(maxSoFar < 0){
	                maxSoFar = 0;
	                currentStart = i+1;
	            }
	            if(max < maxSoFar){
	                maxStart = currentStart;
	                maxEnd = i;
	                max = maxSoFar;
	            }
	        }
	        return new KadaneResult(max, maxStart, maxEnd);
	    }
	 
	 
	 
	// THIS IS THE MAIN FUNCTION 
	 
	public static Result maxSum(int input[][]) {
		int rows =  input.length;
		int columns = input[0].length;
		int temp[] = new int[rows];
		
		 Result result = new Result();
		
		for(int left = 0; left < columns; left++){
			// Reset Temporary Array
			for(int i = 0;i < rows; i++)
				temp[i] = 0;
			
			for(int right = left; right < columns; right++){
				for(int  i = 0 ; i < rows; i++ )
					temp[i] = temp[i] + input[i][right];
				
				// Check geeks4geeksProblems package for my KadaneMaxSum
				KadaneResult kadaneResult = kadane(temp);// Call Kadane Algorithm on this temp array
				
				 if(kadaneResult.maxSum > result.maxSum){
	                    result.maxSum = kadaneResult.maxSum;
	                    result.leftBound = left;
	                    result.rightBound = right;
	                    result.upBound = kadaneResult.start;
	                    result.lowBound = kadaneResult.end;
	               }
			  }
		 }
		return result;
	}
}
