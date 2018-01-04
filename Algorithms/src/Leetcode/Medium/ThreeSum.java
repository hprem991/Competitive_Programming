package Leetcode.Medium;
import java.lang.*;
import java.util.*;

public class ThreeSum {
		List<List<Integer>> ThreeSum(int arr[]){
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			
			Arrays.sort(arr);
			
			for(int i=0; i < arr.length - 2; i++){
				if((i == 0) || (arr[i] > arr[i - 1])){
					int j = i + 1;
					int k = arr.length - 1;
					while(j < k){
						if(arr[i] + arr[j] + arr[k] == 0){
							List<Integer> l = new ArrayList<Integer>();
			                l.add(arr[i]);
			                l.add(arr[j]);
			                l.add(arr[k]);
			                result.add(l);
							j++;
							k--;
							
							while((j < k) && (arr[j] == arr[j - 1]))
								j++;
							
							while((j < k) && (arr[k] == arr[ k + 1]))
								k--;
						} else if(arr[i] + arr[j] + arr[k] < 0) {
							j++;
						} else {
							k--;
						}
					}
				}
			}
			return result;
		}
}
