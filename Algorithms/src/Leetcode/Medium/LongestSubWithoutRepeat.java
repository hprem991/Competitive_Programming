package Leetcode.Medium;

import java.lang.*;
import java.util.*;

public class LongestSubWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      int max = 0, soFar = 0;
      for(int i=0; i< s.length();i++){
    	  char c = s.charAt(i);
    	  if(map.containsKey(c)){
    		  i =  map.get(c);
    		  max = Math.max(max,soFar);
    		  map = new HashMap<Character, Integer>();
    	  } else {
    		  map.put(c, i);
    		  soFar++;
    	  }
      }
      return max;
    }
}
