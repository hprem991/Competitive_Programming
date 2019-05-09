package Tree;
import java.util.*;


//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
//Heaven knows why the HashSet Contains fails to solve this problem but the algorithm works flawlessly

class Node {
	int val;
	Node left, right;
}

public class TwoSumBST {

	 void inorderTraversal(Node node, ArrayList<Integer> accu) {
		 if(node != null) {
			 inorderTraversal (node.left, accu);
			 accu.add(node.val);
			 inorderTraversal (node.right, accu);
		 }
	 }
	 
	 public boolean isTwoSum(Node root, int sum) {
		 ArrayList<Integer> accu = new ArrayList<Integer>();
		 inorderTraversal(root, accu);
		 
		 Set<Integer> set = new HashSet<Integer>();
		 for (int val : accu) {
			 int find = sum - val;
			 if(set.contains(find)) {
				 return true;
			 } else {
				 set.add(find);
			 }
		 }
		 
		 for( int val : set)
			 System.out.println(val);
			 
		 return false;
	 }
}

