package Tree;
import java.util.*;
import java.lang.*;


// Untested Code 
public class InvertTree {
	TreeNode invertHelper(TreeNode root){
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		if(root.left != null)
			invertHelper(root.left);
		if(root.right != null)
			invertHelper(root.right);
		return root;
	}
	
	public TreeNode invertTree(TreeNode root) {
		if(root != null)
			invertHelper(root);
		return root;
	}
}
