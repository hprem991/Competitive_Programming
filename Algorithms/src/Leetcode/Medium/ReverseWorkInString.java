package Leetcode.Medium;
import java.util.*;
import java.lang.*;

public class ReverseWorkInString {
	 public String reverseWords(String s) {
		 String result = "";
		 String words[] = s.trim().split("\\s+");
		 for(int i = words.length - 1; i > 0; i--){	 
             result += words[i];  
             result += " ";
		 }
		 return result + words[0];
        
	 }
}
