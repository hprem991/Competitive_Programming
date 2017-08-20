package Leetcode.Medium;

//https://leetcode.com/problems/kth-largest-element-in-an-array/description/
import java.lang.*;
import java.util.*;

public class KthElement {
	
	// PriorityQueue Solution of O(k)
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i = 0; i < nums.length; i++){
			pq.offer(nums[i]);
			if(pq.size() > k)
				pq.poll();
		}					
		return pq.peek();
    }
}
