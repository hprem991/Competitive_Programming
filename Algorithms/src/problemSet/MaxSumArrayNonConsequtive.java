package problemSet;
import java.lang.*;
import java.util.*;

//http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/

public class MaxSumArrayNonConsequtive {
		int maxSum(int arr[]){
			int incl = arr[0];
			int excl = 0;
			
			for(int i = 1; i< arr.length;i++){
				int new_max = incl > excl ? incl : excl;
				incl = excl + arr[i];
				excl = new_max;
			}
			
			return (incl > excl ? incl : excl);
		}
}
