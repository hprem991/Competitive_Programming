package Tree;
import java.lang.*;
import java.util.*;

class TreeNode{
	int data;
	TreeNode left, right;
}
//NOTE: untested code



public class BalanceBinaryTree {
	
	// Use bottom Up method to calculate the height as well as balance each time , Runtime Complexity = O(N)
	public int isBalance(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftHeight, rightheight;
		
		leftHeight = isBalance(root.left);
		rightheight = isBalance(root.right);
		if(leftHeight == -1 || rightheight == -1)
			return -1;
		if(Math.abs(rightheight - leftHeight) > 1)
			return -1;
		else 
			return Math.max(leftHeight, leftHeight) + 1;
	}

	
	public boolean isBalancedBottomUp(TreeNode root) {
		  if(root == null)
			  return true;
		  else{
			  return isBalance(root) != -1;
		  }
	}
	
	// This is top down approach, where we are calculating height at each node making it O(N^2) algorithms
	
	int height(TreeNode node){
		if(node == null)
			return 0;
		 return Math.max(height(node.left) , height(node.right) ) + 1;
	}
	public boolean isBalancedTopDown(TreeNode root) {
		  if(root == null)
			  return true;
		  else{
			  int left = height(root.left);
			  int right = height(root.right);
			  return (Math.abs(left - right) < 1) && (isBalancedTopDown(root.left)) && (isBalancedTopDown(root.right));
		  }
    }
}
