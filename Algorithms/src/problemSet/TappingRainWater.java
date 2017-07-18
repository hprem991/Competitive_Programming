package problemSet;
import java.util.*;
import java.lang.*;

public class TappingRainWater {
	public int trap(int[] height) {
		int result = 0;
		
		if((height == null) || (height.length < 2))
			return result;
		
		int left[] = new int[height.length];
		int right[] = new int[height.length];
		
		left[0] = height[0];
		int max = left[0];
		
		//Scan from left to right 
		for(int i = 1; i< height.length; i++){
			if(height[i] < max)
				left[i] = max;
			else {
				left[i] = height[i];
				max = left[i];
			}
		}
		
		right[height.length - 1] =height[height.length - 1];
		max = height[height.length - 1];
		
		// Scan from right to left
		for(int i = height.length - 2; i >=0 ; i--){
			if(height[i] < max)
				right[i] = max;
			else {
				right[i] = height[i];
				max = right[i];
			}
		}
		
		for(int i=0; i<height.length; i++){
			result += Math.min(left[i], right[i]) - height[i];
		}
		return result;
	}
}
