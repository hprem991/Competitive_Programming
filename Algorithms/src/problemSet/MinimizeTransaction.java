package problemSet;
import java.lang.*;
import java.util.*;

//http://www.geeksforgeeks.org/minimize-cash-flow-among-given-set-friends-borrowed-money/

public class MinimizeTransaction {
	
	public int getMin(int amount[]){
		int min = 0;
		for(int i=0; i < amount.length;i++)
			min = Math.min(min, amount[i]);
		return min;
	}
	
	public int getMax(int amount[]){
		int max = 0;
		for(int i=0; i < amount.length;i++)
			max = Math.min(max, amount[i]);
		return max;
	}
	
	public void resolveTransaction(int amount[]){
		// Find the indexes of minimum and maximum values in amount[]
	    // amount[mxCredit] indicates the maximum amount to be given
	    //                  (or credited) to any person .
	    // And amount[mxDebit] indicates the maximum amount to be taken
	    //                  (or debited) from any person.
	    // So if there is a positive value in amount[], then there must
	    // be a negative value
		
		int mxCredit = getMin(amount);
		int mxDebit = getMax(amount);
		
		//Base Case
		// // If both amounts are 0, then all amounts are settled
	    if (amount[mxCredit] == 0 && amount[mxDebit] == 0)
	        return;
	    
	    // Find the minimum of two amounts
	    int min = Math.min(-amount[mxDebit], amount[mxCredit]);
	    amount[mxCredit] -= min;
	    amount[mxDebit] += min;
	    
	    // If minimum is the maximum amount to be
	    System.out.println("Person " + mxDebit + " pays " + min + " to " + "Person " + mxCredit); 
	 
	    // Recur for the amount array.  Note that it is guaranteed that
	    // the recursion would terminate as either amount[mxCredit] 
	    // or  amount[mxDebit] becomes 0
	    resolveTransaction(amount);
	}
	
	public void  getTransaction(int graph[][]){
		// Create an array amount[], initialize all value in it as 0.
		int numberOfFriends = graph[1].length;
	    int amount[] = new int[numberOfFriends];
	 
	    // Calculate the net amount to be paid to person 'p', and
	    // stores it in amount[p]. The value of amount[p] can be
	    for(int friend = 0; friend < numberOfFriends; friend++){
	    	for(int otherfriend = 0 ; otherfriend < numberOfFriends; otherfriend++){
	    		amount[friend] += ( graph[otherfriend][friend] - graph[friend][otherfriend]);
	    	}
	    }
	    
	    resolveTransaction(amount);
	}

}
