package problemSet;

public class RegularExpressionMatching {
	
	public boolean isMatch(String str, String regEx){
		
		//if empty string than regEx has to be empty or *
		if(str.length() == 0)
			return ((regEx.length() == 0) || ((regEx.length() == 1) && (regEx.charAt(0) == '*')));
		
		boolean[][] dp = new boolean[str.length() + 1][regEx.length() + 1];
		
		
		dp[0][0] = true;
		//Base case is you only have one Star *
		for(int i = 1; i <= regEx.length(); i++) {	
			if(regEx.charAt(i - 1) == '*') {
				dp[0][i] = dp[0][i - 1];
			}	
		}	
		
		for(int i = 1; i < str.length(); i++){
			for(int j = 1; j < regEx.length(); j++){
				if((str.charAt(i) == regEx.charAt(j)) || (regEx.charAt(j) == '?')){
					dp[i][j] = dp[i-1][j-1];
				} else if(regEx.charAt(j) == '*'){
					dp[i][j] = dp[i-1][j] || dp[i][j-1]; // look at eariler Match
				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[str.length() - 1][regEx.length() - 1];
	}
}
