package DP;

import java.util.*;

// NOTE : UNTESTED CODE

class Box implements Comparable<Box>{
	
	Box(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	int x,y,z;
	
	int area;
	
	@Override
	public int compareTo(Box box){
		this.area = this.x * this.y;
		box.area = box.x * box.y;
		if((this.x * this.y)  >= (box.x * box.y))
			return -1;
		else 
			return 1;
	}
}

public class BoxStacking {
	
		public void createAllRotation(Box[] boxes, ArrayList<Box> allBoxes){
			for(int i=0; i < boxes.length; i++){
				allBoxes.add(boxes[i]);
				if(boxes[i].y > boxes[i].z){
					allBoxes.add(new Box(boxes[i].y, boxes[i].z, boxes[i].x));
				} 
				if(boxes[i].y < boxes[i].z){
					allBoxes.add(new Box(boxes[i].z, boxes[i].y, boxes[i].x));
				}
				if(boxes[i].x > boxes[i].z){
					allBoxes.add(new Box(boxes[i].x, boxes[i].z, boxes[i].y));
				} 
				if(boxes[i].x < boxes[i].z){
					allBoxes.add(new Box(boxes[i].z, boxes[i].x, boxes[i].y));
				} 
				if(boxes[i].x > boxes[i].y){
					allBoxes.add(new Box(boxes[i].x, boxes[i].y, boxes[i].z));
				} 
				if(boxes[i].x < boxes[i].y){
					allBoxes.add(new Box(boxes[i].y, boxes[i].x, boxes[i].z));
				} 
			}
		}
		
		public int maxHeight(Box[] boxes){
			ArrayList<Box> allBoxes =  new ArrayList<Box>();
			this.createAllRotation(boxes, allBoxes);
			
			Box[] allRotation = new Box[allBoxes.size()];
			Arrays.sort(allRotation);
			
			int dp[] =  new int[allRotation.length];
			int index[] = new int[allRotation.length];
			
			for(int i = 0; i < allRotation.length;i++){
				dp[i] = allRotation[i].z;
				index[i] = i;
			}
			
			
			for(int i = 1; i < allRotation.length; i++){
				for(int j = 0; j < i; j++){
					//Check if the box jth box length as well as width is less than box ith to go on its top
					if((allRotation[i].x < allRotation[j].x) && (allRotation[i].y < allRotation[j].y)){
						//Check if this box addition increases total height
						if(dp[j] + allRotation[i].z > dp[i]){
							dp[i] = dp[j] + allRotation[i].z;
						}
					}
				}
			}
			
			// Now find max height
			int max = 0;
			for(int i = 0; i< dp.length;i++){
				max = Math.max(max, dp[i]);
			}
			return max;
		}

	public static void main(String a[]){
		 BoxStacking bs = new BoxStacking();
	     Box input[] = { new Box(3, 2, 5), new Box(1, 2, 4) };
	     int maxHeight = bs.maxHeight(input);
	     System.out.println("Max height is " + maxHeight);
		
	}		
	
}
