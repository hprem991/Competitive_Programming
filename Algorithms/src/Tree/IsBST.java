package Tree;

class Node {
	int data;
	Node left;
	Node right;
}

public class IsBST {
	  boolean IsBST(Node root, int min, int max){
	        if(root == null)
	            return true;
	        if(root.data < min || root.data > max)
	            return false;
	        return IsBST(root.left, min, root.data - 1) &&
	               IsBST(root.right, root.data + 1, max);
	    }

	    boolean checkBST(Node root) {
	       return IsBST(root, -100000, +100000);
	    }
}
