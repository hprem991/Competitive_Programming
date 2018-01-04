package DP;
import java.util.*;
import java.lang.*;

//http://www.programcreek.com/2013/01/leetcode-triangle-java/
//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.


//[
//		 [2],
//		[3,4],
//	   [6,5,7],
//	  [4,1,8,3]
//]

public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int dp[]= new int[triangle.size()];
		
		int len = triangle.size() - 1; // Total number of Arrays inside arraylist
		
		// going to the last row and filling the value as the respective element in last row
		for(int i = 0; i < triangle.get(len).size(); i++){
			dp[i] = triangle.get(len).get(i); 
		}
		
		// From second last row, till we come to first row
		for(int i = triangle.size() - 2; i >= 0; i--) {
			//get each element of the row below it by (i + 1).size() - 1
			for(int j = 0; j < triangle.get(i + 1).size() - 1; j++){
				//Check if value is less than earlier calculated value of j , j + 1 added to current index element 
				dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
			}
		}
		return dp[0]; // returning value formed at dp[0] index
	}
}
