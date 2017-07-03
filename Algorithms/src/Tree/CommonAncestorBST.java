package Tree;


//Notice LCA of BST is different than Binary tree and is easlier of the two
public class CommonAncestorBST {	
	// Algo :  We look for a root whose first value is < root.value and second.value > root.value recursively
	Node lowestCommonAncestor(Node root, Node first, Node second){
    	if((root.data > first.data) && (root.data < second.data))
    		return root;
    	else if(root.left != null)
    		return lowestCommonAncestor(root.left, first, second);
    	else if (root.right != null)
    		 return lowestCommonAncestor(root.right, first, second);
    	else 
    		return null;
    	}
   }
