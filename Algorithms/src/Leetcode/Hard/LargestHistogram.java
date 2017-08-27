package Leetcode.Hard;
import java.lang.*;
import java.util.*;


// https://www.programcreek.com/2014/05/leetcode-largest-rectangle-in-histogram-java/
// https://leetcode.com/problems/largest-rectangle-in-histogram/description/

public class LargestHistogram {
	  public int largestRectangleArea(int[] heights) {
		     Stack<Integer> stack = new Stack<Integer>();
		        int max = 0;
		        int i = 0;
		        while( i < heights.length){
		        	//push index to stack when the current height is larger than the previous one
		        	if(stack.isEmpty() || (heights[i] >= heights[stack.peek()])){
		        		stack.push(i);
	                    i++;
		        	} else {
		        		int height = heights[stack.pop()];
		        		int width = stack.isEmpty() ? i : i - stack.peek() - 1;
		        		max = Math.max(max, height * width);
		        	}	
		        }
		        while(!stack.isEmpty()){
		        	int height = heights[stack.pop()];
	        		int width = stack.isEmpty() ? i : i - stack.peek() - 1;
	        		max = Math.max(max, height * width);
		        }
		        return max;
	    }
}
