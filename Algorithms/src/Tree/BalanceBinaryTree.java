package Tree;
import java.lang.*;
import java.util.*;


//NOTE: untested code
public class BalanceBinaryTree {
	
	int height(TreeNode node){
		if(node == null)
			return 0;
		 return Math.max(height(node.left) , height(node.right) ) + 1;
	}
	public boolean isBalanced(TreeNode root) {
		  if(root == null)
			  return true;
		  else{
			  int left = height(root.left);
			  int right = height(root.right);
			  return (Math.abs(left - right) < 1) && (isBalanced(root.left)) && isBalanced(root.right)));
		  }
    }
}
