package Leetcode.Medium;

import java.util.*;
import java.lang.*;

public class RemoveKDigits {
	 public String removeKdigits(String num, int k) {
		   	int min = 0;
	     	int result = Integer.MAX_VALUE;
	     	String lowerSide = "";
	     	String upperSide = "";
	     	for(int i = num.length() - k; i > 0; i--){ 
	     		lowerSide = num.substring(0, i);
	     		upperSide = num.substring(i+k);
	     		min = Integer.parseInt(lowerSide + upperSide);
	     		if(min <= result){
	     			result = min;
	     		}
	     	}
	     	return Integer.toString(result);
	    }
}
