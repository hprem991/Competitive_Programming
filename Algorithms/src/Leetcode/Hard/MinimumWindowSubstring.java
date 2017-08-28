package Leetcode.Hard;
import java.lang.*;
import java.util.*;


//https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems

public class MinimumWindowSubstring {
	 public String minWindow(String s, String t) {
		  // Mapping the targets character count
		  Map<Character, Integer> map = new HashMap<Character, Integer>();
		  
		  int maxWindowSize = 0;
		  int head = 0;
		  int begin = 0;
		  int end = 0;
		  int counter = t.length(); // We got to match this many characters 
		  
		  for(int i = 0; i < t.length(); i++){
			  if(map.containsKey(t.charAt(i))){
				  int val = map.get(t.charAt(i));
				  map.put(t.charAt(i), val + 1);
			  } else {
				  map.put(t.charAt(i), 1);
			  }
		  }
		  
		  while(end < s.length()){
			  if(map.containsKey(s.charAt(end++))){
				  counter--;
			  }
			  
			  if(counter == 0) { // Valid Window
				  if((end - begin) < maxWindowSize){
					  maxWindowSize = end - begin;
					  head = begin;
				  }
				// if(map[s[begin++]]++==0) counter++;  //make it invalid
				 if(map.get(s.charAt(begin)) == 0)
					 counter++;
			  } 
		  }
		 return s.substring(begin, maxWindowSize);
	 }
}
