class Node {
  int val;
  Node left;
  Node right;
}

//Coded
int height(Node root) {
	int maxHeight = 0;
	if(root == null) return 0;
	else  {
		int left = height(root.left);
		int right = height(root.right);
		maxHeight = (left > right ?  left + 1 : right + 1)
	}
	return maxHeight;
}


// Could have been compacted to

int height(Node root) {
  if(root == null ) return 0;
  return Math.max(height(root.left), height(root.right)) + 1;
}
