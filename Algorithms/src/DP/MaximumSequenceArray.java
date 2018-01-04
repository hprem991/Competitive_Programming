package DP;

public class MaximumSequenceArray {
	public int maximumSeq(int arr[]){
		int dp[] = new int[arr.length];
		int index[] = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++){
			dp[i] = arr[i];
			index[i] = i;
		}
		
		for(int i = 1; i < arr.length; i++){
			for(int j = 0; j < i; j++){
				if(arr[j] < arr[i] ) {// if value is greater in sequence
					dp[i] = Math.max(dp[j], dp[j] + arr[i]);
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < dp.length; i++){
			if(dp[i] > max)
				max = dp[i];
		}
		return max;
	}
}
