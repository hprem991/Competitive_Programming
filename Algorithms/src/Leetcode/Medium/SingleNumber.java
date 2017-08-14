package Leetcode.Medium;
import java.lang.*;
import java.util.*;

//https://leetcode.com/problems/single-number/description/

public class SingleNumber {
	
	//Given an array of integers, every element appears twice except for one. Find that single one.
	 public int singleNumber(int[] nums) {
		 int result = 0;
		 for(int i = 0; i < nums.length; i++)
			 result ^= nums[i];
		 return result;
	 }
	 
	 
	 // Single Number 2, Use this logic over geeks for geeks logic
	 //Given an array of integers, every element appears three times except for one, which appears exactly once.
	 
//	 Algo :- 
//	 First time number appear -> save it in "ones"
//	 Second time -> clear "ones" but save it in "twos" for later check
//	 Third time -> try to save in "ones" but value saved in "twos" clear it.
	 
	 public int singleNumber2(int[] nums) {
		 int ones = 0;
		 int twos = 0;
		 
		 for(int i = 0; i < nums.length; i++){
			 ones =  (ones ^ nums[i]) & ~twos;
			 twos =  (twos ^ nums[i]) & ~ones;
		 }
		 return ones;
	  }
	 
	 
}
