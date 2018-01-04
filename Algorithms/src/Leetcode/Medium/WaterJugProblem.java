package Leetcode.Medium;
import java.lang.*;
import java.util.*;

public class WaterJugProblem {
	public boolean canMeasureWater(int x, int y, int z){
		  //limit brought by the statement that water is finallly in one or both buckets
	    if(x + y < z) return false;
	    //case x or y is zero
	    if( x == z || y == z || x + y == z ) return true;
	    
	    //get GCD, then we can use the property of Bézout's identity
	    return z%GCD(x, y) == 0;
	}
	
	int GCD(int a, int b){
		if(a == 0) 
			return b;
		return GCD(b % a, a);
	}
}
