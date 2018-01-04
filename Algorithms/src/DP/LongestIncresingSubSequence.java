package DP;
import java.lang.*;
import java.util.*;


public class LongestIncresingSubSequence {
	public int LongestIncreasingSubSequence(int array[]){
		int dp[] =  new int[array.length];
		int max = 0;
		for(int i = 0 ; i < array.length; i++)
			dp[i] = 1;
		
		for(int i = 1; i < array.length; i++){
			for(int j = 0; j < i; j++){ // Everytime you check new ith element, scan the array / previous calculations to find any changes
				if((array[i] > array[j]) && (dp[i] < dp[j] + 1)){
					dp[j] = dp[j] + 1;
				}	
			}
		}
		
		for(int i = 0 ; i < dp.length; i++){
			if(max < dp[i])
				max = dp[i];
		}
		
		return max;
	}
}
