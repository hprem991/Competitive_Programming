package DP;

public class LongestPalindrome {
	public int LongestPalindromeStringLength(String str){
		
		int dp[][] = new int[str.length()][str.length()];
		
		for(int i = 0; i < str.length(); i++){
			dp[i][i] = 1;
		} 
		
		for(int stringlength = 2; stringlength <= str.length(); stringlength++){
			for(int startIndex =  0; startIndex < (str.length() - stringlength + 1 ); startIndex++){
				int endIndex = startIndex + stringlength - 1;
				if(str.charAt(startIndex) == str.charAt(endIndex) && stringlength == 2){
					dp[startIndex][endIndex] = 2;
				} else if(str.charAt(startIndex) == str.charAt(endIndex)){
					dp[startIndex][endIndex] = dp[startIndex + 1][endIndex - 1] + 2; // Looking diagonal Value
				} else {
					dp[startIndex][endIndex] = Math.max(dp[startIndex][endIndex -1],
														dp[startIndex + 1][endIndex]);
				}
			}
		}
		return dp[0][str.length() - 1];
	}
}
