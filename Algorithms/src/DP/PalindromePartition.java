package DP;
import java.util.*;
import java.lang.*;

public class PalindromePartition {
	public ArrayList<String> isPalindromePartition(String str, Map<String, Boolean> dict){
		
		ArrayList<String> results = new ArrayList<String>();
		
		if(str == null)
			return results;
		if(str.length() <= 1){
			 results.add(str);
			 return results;
		}
		
		int dp[][] = new int[str.length()][str.length()];
		
		
		for(int len = 1; len <= str.length(); len++){
			for(int start = 0; start <= len - str.length() - 1; start++){
				int end = start + len - 1;
				if(str.charAt(start) == str.charAt(end)){
					if((len == 1) || (len == 2)){
						dp[start][end] = 1;
					} else {
						dp[start][end] = dp[start -1][end - 1];
					}
					
					if(dp[start][end] == 1){
						results.add(str.substring(start, end + 1));
					}
				} else {
					dp[start][end] = 0;
				}
			}
		}
		return results;
	}
}
