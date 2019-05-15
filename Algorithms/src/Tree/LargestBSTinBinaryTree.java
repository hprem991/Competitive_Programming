package Tree;
/* To find the Largest Binary Search Tree in a Given Binary Tree 
 * Using four properties, boolean isBST, min, max, the size of the BST 
 */

//class TreeNode {
//	int val;
//	Node left;
//	Node right;
//} 

class LargestBSTInfo{
	boolean m_isBST;
	int m_size;
	int m_min;
	int m_max;
	
	LargestBSTInfo(boolean isBST, int size, int min, int max) {
		m_isBST = isBST;
		m_size = size;
		m_min =  min;
		m_max = max;
	}
}

// Function to return the size of the Largest BST
public class LargestBST {
	
	int largestBSTSize(TreeNode root) {
		LargestBSTInfo largest =  Largest(root);
		return largest.m_size;
	}
	
	LargestBSTInfo Largest(TreeNode root) {
		if(root == null) return new LargestBSTInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		
		LargestBSTInfo left = largest(root.left);
		LargestBSTInfo right = largest(root.right);
		
		LargestBSTInfo myInfo;
		
		if((left.m_isBST == false) ||(right.m_isBST == false) || (left.m_max > root.val) || (right.m_min < root.val)) {
			myInfo.m_isBST = false;
			myInfo.m_size = Math.max(right.m_size, left.m_size);
			return myInfo;
		} 
		
		myInfo.m_isBST = true;
		myInfo.m_max = root.right != null ? right.m_max : root.val;
		myInfo.m_min = root.left != null ? left.m_min : root.val;
		myInfo.m_size = left.m_size + right.m_size + 1;
		
		return myInfo;
	}
}

