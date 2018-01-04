package Tree;
import java.lang.*;
import java.util.*;

//http://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/

public class SpiralTree {
		public int height(TreeNode root){
			if(root == null)
				return 0;
			int left = height(root.left);
			int right = height(root.right);
			return (left > right? left + 1 : right + 1);
		}
		
		public void printSpiral(TreeNode root){
			int height = height(root);
			
			boolean leftToRight = true;
			for(int i=0; i<height; i++){
				printLevel(root, i, leftToRight);
				leftToRight = !leftToRight;
			}
		}
		
		public void printLevel(TreeNode root, int level, boolean leftToRight){
			if(root == null)
				return;
			
			if(level == 1)
				System.out.println(root.data);
			
			if(level > 1){
				if(leftToRight){
					printLevel(root.left, level - 1, leftToRight);
					printLevel(root.right, level - 1, leftToRight);
				} else {
					printLevel(root.right, level - 1, leftToRight);
					printLevel(root.left, level - 1, leftToRight);
				}
			}
		}
}
