package problemSet;
import java.util.*;
import java.lang.*;

/*
	There are N children standing in a line. Each child is assigned a rating value. You are giving candies to these children subjected to the following requirements:

	1. Each child must have at least one candy.
	2. Children with a higher rating get more candies than their neighbors.

	What is the minimum candies you must give?
 */		

public class AssignMinimumCandies {
	public int candy(int[] ratings) {
			if((ratings == null) || (ratings.length == 0))
				return 0;
			
			int candies[] = new int[ratings.length];
			int minimumCandies = 0;
			candies[0] = 1;
			
			// Scanning from left to right for ascending ratings
			for(int i=1; i < ratings.length; i++){
				if(ratings[i] > ratings[i-1])
					candies[i] = candies[i-1] + 1;
				else
					candies[i] = 1;
			}
			
			// Scanning from right to left for ascending ratings
			for(int i = ratings.length - 2; i >=0 ; i--){
				if(ratings[i] > ratings[i + 1])
					candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
			}
			
			for(int i=0; i < ratings.length; i++)
				minimumCandies += candies[i];
			
			return minimumCandies;
	}
}
