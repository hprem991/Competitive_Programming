package Leetcode_Premium;
import java.util.*;

public class LongestSubString {
	 Map<Character, Integer> map = new HashMap<>();
	 	int result = 0;
	 	int lastIndex = 0;
	 	for(int i = 0; i < s.length(); i++) {
	 		if(map.containsKey(s.charAt(i))) {
	 			lastIndex = Math.max(map.get(s.charAt(i)), lastIndex);
	 		}
	 	  result = Math.max(result, i - lastIndex + 1);	
	 	  map.put(s.charAt(i), i + 1);
	 	}
	 	return result;
	}
