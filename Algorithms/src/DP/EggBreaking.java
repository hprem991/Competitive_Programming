package DP;

public class EggBreaking {
	public int eggDrop(int eggs, int floors){
		int dp[][] = new int[eggs + 1][floors + 1];
		
		for(int f = 0; f <= floors; f++)
			dp[1][f] = f;
		
		for(int e = 2; e <= eggs; e++){
			for(int f = 1; f <= floors; f++ ){
				dp[e][f] = Integer.MAX_VALUE;
				for(int k = 1; k <= f; k++) {
					int val = 1 + Math.max(dp[e - 1][k - 1], dp[e][f - k]);
					if(val < dp[e][f]){
						dp[e][f] = val;
					}
				}
			}
		}
		return dp[eggs][floors];
	}
}
