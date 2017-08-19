package Leetcode.Medium;
import java.util.*;
import java.lang.*;

//https://leetcode.com/problems/find-peak-element/description/
// Remember num[i] ≠ num[i+1], meaning 3 3 , 2 2 isnt possible

public class FindPeakElement {
	
	// Smart O(log n) solution,
	 public int findPeakElement(int[] nums, int low, int high) {
		 if(low == high)
			 return low;
		 else {
			 int mid = ( low + high ) / 2;
			 if(nums[mid] > nums[mid + 1]){
				 return findPeakElement(nums, low, mid);
			 } else {
				 return findPeakElement(nums, mid + 1, high);
			 }
		 }
	  }
	 
	 public int findPeakElement(int[] nums) {
	        return findPeakElement(nums, 0, nums.length - 1);
	    }
}
