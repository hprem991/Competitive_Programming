package Leetcode.Hard;

import java.lang.*;
import java.util.*;



public class MedianOfSortedArray {

	//https://www.youtube.com/watch?v=3jJ6gojbr0A&t=395s
	//NOTE THIS ALGO ASSUMPS THAT BOTH ARRAYS ARE OF EQUAL LENGTH
	int findMedian(int X[], int Y[], int low, int high, int n){
		if(high < low)
			findMedian(Y, Y, 0, n, n); //Median not Found in X, now Search in Y 
		int mid = low + high / 2;
		
		if((Y[n - mid] <= X[mid]) && (X[mid] <= Y[n - mid + 1])){
			return X[mid];
		}
		
		if(X[mid] < Y[n - mid])
			return findMedian(X, Y, mid + 1, high, n);
		else
			return findMedian(X, Y, low, mid - 1, n);
	}
	
	//https://discuss.leetcode.com/topic/28602/concise-java-solution-based-on-binary-search/2
	//COMPLICATED CASE OF ARRAYS OF UNEQUAL LENGTH
	
	int findMedian(int X[], int Y[]){
		int m = X.length;
		int n = Y.length;
		int left = ( m + n + 1 ) / 2;
		int right = (m + n + 2) / 2;
		return ((findkthElement(X, 0, Y, 0, left) + findkthElement(X, 0, Y, 0, right)) / 2);
	}
	
	int findkthElement(int X[], int xStart, int Y[], int yStart, int k){
		if(xStart > (X.length - 1)) // If we ran out of Indexes in X and couldnt find median 
		{
			return Y[yStart + k - 1];
		}
		
		if(yStart > (Y.length - 1)) // If we ran out of Indexes in Y and couldnt find median 
		{
			return X[xStart + k - 1];
		}
		
		if(k == 1){ // then we found median
			return Math.min(X[xStart], Y[yStart]);
		}
		
		int xMid = Integer.MAX_VALUE;
		int yMid = Integer.MAX_VALUE;
		
		if(xStart + k/2 - 1 < X.length) // If we could find the mid within the X length
			xMid = X[xStart + k / 2 - 1];
		
		if(yStart + k/2 - 1 < Y.length) // If we could find the mid within the X length
			yMid = Y[yStart + k / 2 - 1];
		
		if(xMid < yMid){
			return findkthElement(X, xStart + k / 2, Y, yStart, k - k / 2); // Check X's right and  Y's left
		}
		else 
			return findkthElement(X, xStart , Y, yStart + k / 2, k - k / 2 ); // Check Y's right and  X's left
	}
	
}
