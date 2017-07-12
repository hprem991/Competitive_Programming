package Leetcode.Hard;
import java.util.*;
import java.lang.*;


// Check https://www.youtube.com/watch?v=IFNibRVgFBo for explanation

public class BalloonBursting {
	public int maxCoins(int ballons[]) {
		int dp[][] = new int[ballons.length][ballons.length];
		
		for(int len=1; len <= ballons.length; len++){
			for(int start=0; start <= ballons.length - len; start++){
				int end = ballons.length - start - 1;
				
				for(int k = start; k <= end; k++){
					int right = 1;
					int left = 1;
					
					if(start != 0){
						left = ballons[start - 1];
					}
					if(end != ballons.length - 1){
						right = ballons[end + 1];
					}
					
					int before = 0;
					int after = 0;
					
					if(start != k){
						before = dp[start][k-1];
					}
					
					if(end != k){
						after = dp[k+1][end];
					}
					
					dp[start][end] = Math.max(dp[start][end], 
									left * ballons[k] * right + after + before);
				} // End of k
			} // End of start Index
		} // End of length
		return dp[0][ballons.length - 1];
	}
}
