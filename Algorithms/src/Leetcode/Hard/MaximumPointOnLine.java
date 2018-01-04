package Leetcode.Hard;
import java.util.*;
import java.lang.*;


//  Definition for a point.
  class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
 
  
  // Some case Missing 
  // Input:
  // [[0,0],[1,0]]
  //		  Output: 1
  //		  Expected: 2

public class MaximumPointOnLine {
	 public int maxPoints(Point[] points) {
	        Map<Double, Integer> map = new HashMap<Double, Integer>();
	        for(int i=0; i <  points.length; i++){
	             double d;
	            if( points[i].x == 0)
	                d = 1.0;
	            else
	                d = points[i].y / points[i].x;
	            if(map.containsKey(d)){
	                int count = map.get(d);
	                count++;
	                map.put(d, count);
	            } else {
	                map.put(d, 1);
	            }
	        }
	        int max = 0;
	        for (Map.Entry<Double, Integer> entry : map.entrySet()){
	            if(entry.getValue() > max)
	                max = entry.getValue();
	        }
	        return max;
	    }

}
