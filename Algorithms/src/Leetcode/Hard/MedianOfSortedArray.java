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
}
