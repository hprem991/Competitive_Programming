package Tree;

import LeetCode.ContestOne.Node;

//Notice LCA of BST is different than Binary tree and is easlier of the two
public class CommonAncestorBST {	
	
	//Use this Call and ignore the next one,coz the later has major flaws
    Node LCA(Node node, int n1, int n2) 
    {
        if (node == null)
            return null;
  
        if (node.data > n1 && node.data > n2)
            return LCA(node.left, n1, n2);
  
        if (node.data < n1 && node.data < n2) 
            return LCA(node.right, n1, n2);
  
        return node;
    }
    
    
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
