package DP;

public class RodCutting {
	public int maxProfit(int costs[]){
		int dp[] = new int[costs.length + 1];
		
		for(int i=1; i <= costs.length; i++){
			for(int j = i; j <= costs.length; j++){
				dp[j] = Math.max(dp[j], dp[j - i] + costs[ i - 1] );
			}
		}
		return dp[costs.length];
	}
}
