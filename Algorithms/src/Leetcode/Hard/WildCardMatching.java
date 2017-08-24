package Leetcode.Hard;
import java.lang.*;
import java.util.*;

//https://discuss.leetcode.com/topic/3040/linear-runtime-and-constant-space-solution

public class WildCardMatching {
	boolean comparison(String str, String pattern) {
		int strIndex = 0;
		int patternIndex = 0;
		int matchIndex = 0;
		int starIndex = -1;
		
		while(strIndex < str.length()){
			if(patternIndex < pattern.length() && ( (pattern.charAt(patternIndex) == '?') || (pattern.charAt(patternIndex) == str.charAt(strIndex)))){
				patternIndex++;
				strIndex++;
			}
			else if(patternIndex < pattern.length() && (pattern.charAt( patternIndex) == '*')){
				starIndex = patternIndex;
				matchIndex = strIndex;
				patternIndex++;
			}
			else if(starIndex != -1){
				patternIndex = starIndex + 1;
				matchIndex++;
				strIndex = matchIndex;
			} 
			else 
				return false;
		}
		
		while(patternIndex < pattern.length() && (pattern.charAt(patternIndex) == '*'))
			patternIndex++;
		
		return patternIndex == pattern.length();
	}
}
