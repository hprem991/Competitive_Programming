package Leetcode.Hard;

public class RegularExpression {
	
	  boolean isMatch(String str, String pattern){
		  
		     /**
	         * f[i][j]: if s[0..i-1] matches p[0..j-1]
	         * if p[j - 1] != '*'
	         *      f[i][j] = f[i - 1][j - 1] && s[i - 1] == p[j - 1]
	         * if p[j - 1] == '*', denote p[j - 2] with x
	         *      f[i][j] is true iff any of the following is true
	         *      1) "x*" repeats 0 time and matches empty: f[i][j - 2]
	         *      2) "x*" repeats >= 1 times and matches "x*x": s[i - 1] == x && f[i - 1][j]
	         * '.' matches any single character
	         */
		  
		  boolean dp[][] = new boolean[str.length() + 1][pattern.length() + 1] ;
		  
		  dp[0][0] = true; // 0 length string, matches with 0 length pattern
		  
		  for(int i = 1; i <= str.length();  i++) // String with no patterns always fails so false
			  dp[i][0] = false;
		  
		  for(int j = 1; j <= pattern.length(); j++)
			 dp[0][j] = (j > 1) && (pattern.charAt(j - 1) == '*') && (dp[0][j -2]); // just before char is '*' and before that value is true / false dp[0][j - 2]
		  
		  for(int i = 1; i <= str.length(); i++){
			  for(int j = 1; j <= pattern.length() ; j++){
				  if(pattern.charAt(j - 1) == '*')
					  dp[i][j] = dp[i][j - 2] || ((str.charAt(i - 1) == pattern.charAt(j - 2)) || (pattern.charAt(j - 2) == '.')) && dp[i -1][j];
				  else 
					  dp[i][j] = dp[i - 1][j - 1] && ((str.charAt(i - 1) == pattern.charAt(j - 1)) || (pattern.charAt(j - 1) == '.'));
			  }
		  }
		  return dp[str.length()][pattern.length()];
	  }
}
