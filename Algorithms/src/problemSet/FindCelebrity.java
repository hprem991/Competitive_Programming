package problemSet;
import java.util.*;
import java.lang.*;

//http://www.geeksforgeeks.org/the-celebrity-problem/

public class FindCelebrity {
	
	 // Person with 2 is celebrity
    static int MATRIX[][] = { { 0, 0, 1, 0 },
                              { 0, 0, 1, 0 }, 
                              { 0, 0, 0, 0 },
                              { 0, 0, 1, 0 } };
    
	
	boolean knows(int a, int b) 
	    {
	        boolean res = (MATRIX[a][b] == 1) ? true : false;
	        return res;
	    }
	
	
	 
	public int findCelebrity(int n) {
		  int candidate = 0;
	      for(int i = 1; i < n; i++){
	           if(knows(candidate, i))
	               candidate = i;
	       }
	      
	      // Check if a is actually a celebrity or not
	       for (int i = 0; i < n; i++) 
	        {
	            // If any person doesn't know 'a' or 'a'
	            // doesn't know any person, return -1
	           if (i != candidate && (knows(candidate, i) || !knows(i, candidate)))
	                return -1;
	        }
	        return candidate;	
	}
}
