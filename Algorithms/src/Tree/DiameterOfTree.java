package Tree;
import java.lang.*;
import java.util.*;

//http://www.geeksforgeeks.org/diameter-of-a-binary-tree/

public class DiameterOfTree {
	
	int height(Node root){
		if(root == null)
			return 0;
		
		return (1 + Math.max(height(root.left), height(root.right)));
	}
	
	/* Method to calculate the diameter and return it to main */
    int diameter(Node root){
    	if(root == null)
    		return 0;
    	
    	int leftHeight = height(root.left);
    	int rightHeight = height(root.right);
    	
    	int leftDiameter = diameter(root.left);
    	int rightDiameter = diameter(root.right);
    	
    	return Math.max(leftHeight + rightHeight + 1,  Math.max(leftDiameter, rightDiameter));
    }
    
//    int diameterOptimised(Node root, int height){
//    	
//    	int leftHeight, rightHeight;
//    	if(root ==  null) {
//    		height = 0;
//    		return 0;
//    	}
//    	
//    	leftHeight++; 
//    	rightHeight++;
//    	
//    	int leftDiameter = diameterOptimised(root.left, leftHeight);
//    	int rightDiameter = diameterOptimised(root.right, rightHeight);
//    	
//    	return Math.max(a, b)
//    	
//    }
}
