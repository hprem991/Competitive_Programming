package problemSet;
import java.util.*;

public class TwoSum {
	  public int[] twoSum(int[] nums, int target) {
		  Map<Integer, Integer> map =  new HashMap<Integer, Integer>(); // Value to Indices Map
		  int result[] = new int [2];
		  for(int i = 0; i < nums.length; i++){
			  int lowerDiff = target - nums[i];
			  int higherDiff = target + nums[i];
			  if(map.containsKey(lowerDiff)){
				  result[0] = i;
				  result[1] = map.get(lowerDiff);
				  System.out.println("Val "+nums[i]+" and "+lowerDiff);
				  System.out.println("Indices Val "+i+" and "+map.get(lowerDiff));
			  } else if(map.containsKey(higherDiff)){
				  result[0] = map.get(higherDiff);
				  result[1] = i;
				  System.out.println("Val "+nums[i]+" and "+higherDiff);
				  System.out.println("Indices Val "+i+" and "+map.get(higherDiff));
			  } else {
				  map.put(nums[i],i);
			  }
		  }
		  return result;
	   }
}
