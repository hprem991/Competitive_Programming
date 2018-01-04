package DP;
import java.lang.*;
import java.util.*;

public class WordBreak {
	public boolean wordBreak(String str, Set<String> dict){
		
		boolean dp[] = new boolean[str.length()];
		
		for(int len = 1; len < str.length(); len++){
			for(int start = 0; start < len; start++){
				if(dp[start] && dict.contains(str.substring(start, len))){
					dp[start] = true;
					break;
				}
			}
		}
		
		return dp[str.length()];
	} 
}
