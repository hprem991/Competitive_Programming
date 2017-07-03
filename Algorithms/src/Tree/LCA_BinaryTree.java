package Tree;

public class LCA_BinaryTree {
	
	
	//Check Tushar Video on LCA https://www.youtube.com/watch?v=13m9ZCB8gjw
	
	/** 
	 * Algo 
	 *  First Node which doesnt return null from both the branches are the node of interest
	 * 
	 */
	
	Node LowestCommonAncestorBinaryTree(Node root, Node first, Node second){
		if(root == null)
			return root;
		
		if((root ==  first) || (root == second))
			return root;
			
		Node left =  LowestCommonAncestorBinaryTree(root.left, first, second);
		Node right =  LowestCommonAncestorBinaryTree(root.right, first, second);
		
		if((left != null) && (right != null))
			return root;
		else
			return left != null ? left : right;
	}
}
