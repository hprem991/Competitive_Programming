package Leetcode.Medium;
import java.util.*;
import java.lang.*;

public class Sqrt {
	 public long mySqrt(int x) {
	       long r  = x;
	       while(r*r > x){
	    	   r = (r + x / r) / 2;
	       }
	       return r;
	    }
}
