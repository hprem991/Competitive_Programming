package problemSet;
import java.util.*;

public class LargestRectangularHistogram {
	int largestRectangularHistogram(int arr[]) { // Assuming the arr contains the heights 
		Stack<Integer> stack = new Stack<Integer>();
		int max = Integer.MIN_VALUE; 
		int i = 0;
		while( i < arr.length) {
			if( stack.isEmpty() || (arr[i] > arr[stack.peek()])) { // If new value is greater than earlier one, keep pushing
				stack.push(i);  // Remember to push the index not the value itself
				i++;
			} else { 
				int heightIndex = stack.pop();
				int height = arr[heightIndex];
				int width = stack.isEmpty()? i : i - stack.peek() - 1;
				max = Math.max(height * width, max);
			}
		}
		
		while(!stack.isEmpty()) {
			int heightIndex = stack.pop();
			int height = arr[heightIndex];
			int width = stack.isEmpty()? i : i - stack.peek() - 1;
			max = Math.max(height * width, max);
		}
		return max;
	}
}

