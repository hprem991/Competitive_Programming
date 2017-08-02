package Leetcode.Medium;
import java.lang.*;
import java.util.*;

public class LetterCombination {
	 public List<String> letterCombinations(String digits) {
	        Map<Character, String> map = new HashMap<Character, String>(); // Mapping of Digit to List of characters
	        map.put('0', "");
	        map.put('1', "");
	        map.put('2', "abc");
	        map.put('3', "def");
	        map.put('4', "ghi");
	        map.put('5', "jkl");
	        map.put('6', "mno");
	        map.put('7', "pqrs");
	        map.put('8', "tuv");
	        map.put('9', "wxyz");
	        
	        
	        List<String> result = new ArrayList<String>();
	        for(int i = 0; i < digits.length(); i++){
	        	char c = digits.charAt(i);
	        	if(map.containsKey(c)){ // This should obviously pass
	        		String values =  map.get(c);
	        		for(char ch : values.toCharArray()){
	        		   for(int index=0; index < result.size(); index++){
	        			  result.add( result.get(index) + ch);
	        		   }
	        		}
	        	}
	        }
	        return result;
	  }
}
