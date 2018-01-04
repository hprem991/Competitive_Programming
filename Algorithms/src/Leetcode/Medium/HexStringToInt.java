package Leetcode.Medium;
import java.lang.*;
import java.util.*;


// This question was being asked @ Mircrosoft Phone Screening
public class HexStringToInt {
	long hexToInt(String str){
		long res = 0;
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(c != ' '){ // Avoid Spaces
				if((c >='0') && (c <='9')){
					res = 16 * res + (c - '0'); 
				} else if( (c >= 'A') && (c <= 'F')){
					res = 16 * res + (10 + c - 'A');
				} else if( (c >= 'a') && (c <= 'f')){
					res = 16 * res + (10 + c - 'A');
				} else {
					// Invalid case 
					return 0;
				}
			}
		}
		return res;
	}

}
