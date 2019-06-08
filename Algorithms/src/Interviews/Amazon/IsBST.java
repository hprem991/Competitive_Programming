
class Node {
   int val;
   Node left;
   Node right;
}




bool isBST(Node root) {
  return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

bool isBST(Node root, int min, int max){
         if(root == null)
            return true;
         if(root.val < max && root.val > min) {
             return (isBST(root.right,  root.val, max) && isBST(root.left, min, root.val) );
         } else {
             return false;
         }
    }



	
