package problemSet;

import java.util.ArrayList;

public class SlidingWindow implements SolutionInterface {
	  public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
	        // write your code here
		  	ArrayList<Integer> res = new ArrayList<Integer>();
		  	int sum = 0, i;
		  	for(i=0; i < k; i++)
		  		sum += nums[i];
		  	res.add(sum / k);
		  	for(;i< nums.length; i++) {
		  		sum -= nums[i-k];
		  		sum += nums[i];
		  		res.add(sum / k);
		  	}	
		  	return res;		
	   }

	@Override
	public String convert(String s, int numRows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int LongestCommonSubSequence(String first, String second) {
		// TODO Auto-generated method stub
		return 0;
	}
	    
}
