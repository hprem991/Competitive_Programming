package DP;

public class CoinDenomination {
	public int coinChangeDenomination(int Denominations[], int total){
		int T[] = new int[total + 1];
		int Indices[] = new int[total + 1];
		T[0] = 0;
		for(int i = 1; i <= total; i++) {
			T[i] = Integer.MAX_VALUE - 1;
			Indices[i] = -1;
		}
		
		for(int i = 0; i < Denominations.length; i++){
			for(int j = 1; j <= total; j++){
				if(j >= Denominations[i]) { // if this total can be formed  by picking ith denomination
					if( 1 + T[j - Denominations[i]] < T[j]){ // By picking ith coin, value reduced by T[currentValue - Coin value] and if that is less than existing value
						T[j] = 1 + T[j - Denominations[i]];
						Indices[i] = j;
					}
				}
			}
		}
		return T[total];
	}
}
