package Leetcode.Medium;
import java.lang.*;
import java.util.*;

public class LongestSubString {
	
	String expandPalindrome(String s, int start, int end){
		while((start >= 0) && (end < s.length()) && (s.charAt(start) == s.charAt(end))){
			start--;
			end++;
		}
		return s.substring(start, end);
	}
	public String longestPalindrome(String s) {
		String result ="", str = "";
		int len = s.length();
		if(len < 2)
				return s;
		
		for(int i=0; i<s.length(); i++){
			str = expandPalindrome(s, i, i);
			if(str.length() > result.length())
				result = str;
			
			str = expandPalindrome(s, i, i + 1);
			if(str.length() > result.length())
				result = str;
		}
		return result;
	}
}
