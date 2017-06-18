package DP;

public class MatrixChainMultiplication {
	public int costOfMultiplication(int Matrices[]){
		int dp[][] = new int[Matrices.length][Matrices.length];
		
		//for each matrix of length 1, the cost of calculation is 0
		for(int i = 0 ; i < Matrices.length; i++ )
			dp[i][i] = 0;
		
		for(int Len = 2; Len < Matrices.length; Len++){
			for(int start = 0; start < Matrices.length - Len ; start++){
				int end = start + Len;
				dp[start][end] = 100000; // Some large Value
				for(int k = start + 1; k < end; k++){	
					dp[start][end] = Math.min(dp[start][end], 
											  dp[start][k] + dp[k][end] + Matrices[start] * Matrices[k] * Matrices[end]);
				}
			}
		}
		return dp[0][Matrices.length - 1];
	}
}
