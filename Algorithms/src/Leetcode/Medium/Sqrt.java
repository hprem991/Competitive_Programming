package Leetcode.Medium;
import java.util.*;
import java.lang.*;

public class Sqrt {
	
	// This is Newton Formula O(n) algorithm
	 public long mySqrt(int x) {
	       long r  = x;
	       while(r*r > x){
	    	   r = (r + x / r) / 2;
	       }
	       return r;
	    }
	 
	 // This is Binary Search Method for O(log n)
	 public long Sqrt(int x) {
		 int start = 0;
		 int end = x;
		 int ans = 0;
		 
		 // Base case 
		 if(x == 0 || x == 1)
			 return x;
		 while(start <= end){
			 int mid = start + end / 2;
			 if(mid * mid == x){
				 return mid;
			 }
			 if(mid * mid < x){
				 start = mid + 1;
				 ans = mid;
			 }
			 else {
				 end = end - 1;
			 }
		 }
		 return ans;
	 }
	 
}
