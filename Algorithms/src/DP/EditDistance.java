package DP;

public class EditDistance {
	
	public int minDistance(String s1, String s2){
		int dp[][] = new int[s1.length() + 1][s2.length() + 1];
		
		for(int i=0; i <= s1.length(); i++){
			for(int j = 0; j <= s2.length(); j++){
				if(i == 0)
					dp[i][j] = j;
				
				else if (j == 0)
					dp[i][j] = i;
				
				else if(s1.charAt(i-1) ==  s2.charAt(j-1)){
						dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
				}	
			}
		}
		return dp[s1.length()][s2.length()];
	}
}
