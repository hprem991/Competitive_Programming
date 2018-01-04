package classical;
import java.lang.*;
import java.util.*;

public class KnapSack {
	public int MaxKnapSack(int MaxWeight, int Items, int weights[], int values[]){
		int dp[][] = new int[MaxWeight][Items];
		for(int item = 0; item < Items; item++){
			for(int weight = 0; weight < MaxWeight; weight++){
				if((item == 0) || (weight == 0)) {
					dp[item][weight] = 0;
				} else if( weights[item - 1] < weight ){
					//If weight of item being picked is less than current weight being considered
					//Calculate the Maximum weight you can make by 
					//	1. Either picking up the item . i.e. value of item + previous calculated value
					//	2. Leaving the item. i.e. dp[item - 1][weight]
												
					dp[item][weight] = Math.max(values[item - 1] + dp[item - 1][weight - weights[item - 1]], dp[item - 1][weight]);
				} else {
					dp[item][weight] = dp[item][weight - 1];
				}
			}
		}
		return dp[MaxWeight][Items];
	}
}
