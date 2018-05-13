package Leetcode.Hard;

public class PartitionEqualArray {
	boolean partitionArray(int arr[]){
		boolean result = false;
		int sumOfArray = 0;
		for(int val : arr)
			sumOfArray += val;
		
		int half = sumOfArray / 2;
		
		return subSetSum(arr[], half);
	}
}
