package DP;

public class MinimumJump {
	public int minimumJump(int arr[]){
		int dp[] = new int [arr.length];
		int index[] = new int [arr.length];
		
		for(int i = 1; i < arr.length; i++) {
			dp[i] = Integer.MAX_VALUE;
			index[i] = i;
		}
		for(int i = 1; i < arr.length; i++){
			for(int j = 0; j < i; j++){
				if(arr[j] + j >= i){ // Can I reach to i from j
					if(dp[i] > dp[j] + 1){
						dp[i] = dp[j] + 1;
						index[i] = j;
					}
				}
			}
		}
		return dp[arr.length - 1];
	}
}
