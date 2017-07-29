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
	
	// LeetCode Solution
	
	public int findCelebrityleetCode(int n) {
		int celebrity = 0; // Assuming 0th Candidate is a celebrity
		for(int i = 0; i < n; i++ ){
			if(knows(celebrity, i)) // if celebrity knows i, means our assumption is wrong and we remove our last selected celebrity to be a real celebrity 
				  celebrity = i;
			//else part if celebrity does not know i, then we keep looking for next member to see if the last picked celebrity still holds good for him as well
		}
		
		// This is validation check to see if all values below yje current celebrity number still holds the validation
		// This is cause, in earlier celebrity selection loop, we pick potential celebrity increasing.
		for(int i = 0; i < celebrity; i++ ){
			if(knows(celebrity, i))
				return -1;
		}
		
		// This is reverse validation
		for(int i = 0; i < n; i++ ){
			if(!knows(celebrity, i))
				return -1;
		}
		return celebrity;
	}
}
