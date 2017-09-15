package DP;
import java.lang.*;
import java.util.*;


/*
 * 
 * Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons.
 * Initially the miner is at first column but can be at any row. He can move only (right->,right up /,right down\) that is from a given cell, 
 * the miner can move to the cell diagonally up towards the right or right or diagonally down towards the right. 
 * Find out maximum amount of gold he can collect.
 */

//http://www.geeksforgeeks.org/gold-mine-problem/



public class GoldMineProblem {
	
	int maxGoldMineDP(int arr[][]){
		int m =  arr.length;
		int n =  arr[0].length;
		int dp[][] = new int[m][n] ;
		
		 for (int col=n-1; col>=0; col--)
		    {
		        for (int row=0; row<m; row++)
		        {
		            // Gold collected on going to the cell on the right(->)
		            int right = (col==n-1)? 0: dp[row][col+1];
		 
		            // Gold collected on going to the cell to right up (/)
		            int right_up = (row==0 || col==n-1)? 0:
		                            dp[row-1][col+1];
		 
		            // Gold collected on going to the cell to right down (\)
		            int right_down = (row==m-1 || col==n-1)? 0:
		                             dp[row+1][col+1];
		 
		            // Max gold collected from taking either of the
		            // above 3 paths
		            dp[row][col] = arr[row][col] + Math.max(right, Math.max(right_up, right_down));
		        }
		    }
		 
		    // The max amount of gold collected will be the max
		    // value in first column of all rows
		    int res = dp[0][0];
		    for (int i=1; i<m; i++)
		        res = Math.max(res, dp[i][0]);
		    return res;
	}
	

	//NOT SURE OF THE ALGO.. ITS LOOKS LIKE BACKTRACKING IS THE BEST	
	int maxGoldMine(int arr[][]){
		int max = 0;
		int randRow = (int)Math.random() * arr.length;
		for(int i = randRow; i < arr.length;){
			for(int j = 0; j < arr[0].length; j++){
				if(j + 1 < arr[0].length) {
					int right = arr[i][j + 1];
					int rightUp = i - 1 > 0 ? arr[i - 1][j + 1] : 0;
					int rightDown = i + 1 < arr.length ? arr[i + 1][j + 1]:0;
					
					if((right >= rightUp) && (right >= rightDown)){
						max = max + right;
					} else if ((rightUp >= right) && (rightUp >= rightDown)){
						max = max + rightUp;
						i = i - 1;
					} else {
						max = max + rightDown;
						i = i + 1;
					}
				} 
			}
		}
		return max;
	}
}
