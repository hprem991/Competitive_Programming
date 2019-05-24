// 1> Some / Majority of the Basic Test cases can be easily covered by sorting the input parameters and summing up into the auxillary ArrayList before summing up all the arrayList values to form the result


// 2> DP Formula Biols down to this implementation, Also to note that Math.min in  both the occasion generally returns same sum also we gotto check the boundary checks
	int minimumTime(int numOfParts, List<Integer> parts)
	    {
		   int T[][] = new int[numOfParts][numOfParts];
		   for(int len = 2; len < numOfParts; len++) {
			   for(int start = 0; start < parts.size() - len ; start++) {
				   int end = start + len;
				   T[start][end] = Math.min(T[start][end], 
						   					Math.min(T[start][end - 1] + parts.get(end), parts.get(start) + T[start + 1][end]));
			   }
		   }
		   return T[0][numOfParts];
	    }
	   
