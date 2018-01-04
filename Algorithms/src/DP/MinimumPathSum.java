package DP;
import java.lang.*;
import java.util.*;

//https://leetcode.com/problems/minimum-path-sum/description/
//https://www.programcreek.com/2014/05/leetcode-minimum-path-sum-java/


public class MinimumPathSum {
	 public int minPathSum(int[][] grid) {
		 	int dp[][] = new int[grid.length][grid[0].length];
		 	
		 	dp[0][0] = grid[0][0];
		 	//initialize top row
		 	for(int i = 1; i < grid[0].length; i++)
		 		dp[0][i] = dp[0][i - 1] + grid[0][i];
		 	
		 	//initialize left column
		 	for(int i = 1; i < grid.length; i++)
		 		dp[i][0] = dp[i - 1][0] + grid[i][0];
		 	
		 	for(int i = 1; i < grid.length; i++){
		 		for(int j = 1; j < grid[0].length; j++){
		 			int val = Math.min(dp[i-1][j], dp[i][j-1]);
		 			dp[i][j] = val + grid[i][j];
		 		}
		 	}
		 	return dp[grid.length][grid[0].length];
	    }
}
