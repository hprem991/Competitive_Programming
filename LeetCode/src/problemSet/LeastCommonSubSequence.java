package problemSet;

import java.util.ArrayList;

public class LeastCommonSubSequence implements SolutionInterface {
	  public int LongestCommonSubSequence(String first, String second){
		  int dp[][] = new int[first.length()][second.length()];
		  
		  for(int i = 0; i < first.length(); i++){
			  for(int j = 0; j < second.length(); j++){
				  if((i == 0) || (j == 0)) {
					  dp[i][j] = 0;
				  } else if(first.charAt(i) == second.charAt(j)){
					  dp[i][j] = dp[i-1][j-1] + 1;
				  } else {
					  dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				  }
			  }	  
		  }
		  return dp[first.length()][second.length()];
	  }
	  
	  
    // Following Method are overridden due to Inheritance
	@Override
	public String convert(String s, int numRows) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
		// TODO Auto-generated method stub
		return null;
	} 
}
