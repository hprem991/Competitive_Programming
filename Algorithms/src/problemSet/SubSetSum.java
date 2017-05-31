package problemSet;

public class SubSetSum {
	public boolean isSubSetSum(int set[], int sum){
		
		boolean dp[][] = new boolean[set.length + 1][sum + 1];
		
		//If sum == 0, then we can pick anything from the set to make the sum
		for(int i=0; i < set.length; i++)
			dp[i][0] = true;
		
		//if set == empty, then we cannot pick anything to make the sum
		for(int i=0; i < sum; i++)
			dp[0][i] = false;
		
		
		for(int i=1 ; i <= set.length ; i++){
			for(int j=1; j <= sum; j++){
				dp[i][j] = dp[i - 1][j]; // looking at just above element
				if(j >= set[i-1]) // Checking if sum can be formed by combination of multiple elements when sum > single element
					dp[i][j] = dp[i - 1][j] ||
							   dp[i -1][ j - set[i - 1]];
			}
		}
		return dp[set.length][sum];
	}
}
