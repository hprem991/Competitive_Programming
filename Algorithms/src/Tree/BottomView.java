package Tree;
import java.lang.*;
import java.util.*;

//UNTESTED CODE

public class BottomView {

	//using HashMap
	
	public Map<Integer, Integer> bottomView(TreeNode root, Map<Integer, Integer> map, int level){
		if(root == null)
			return map;
		if( ( root.left == null ) && (root.right == null)){
				//Overright it directly without checking 
				map.put(level, root.data);
		 }
		if(root.left != null){
			bottomView(root.left, map, level - 1);
		}
		if(root.right != null){
			bottomView(root.right, map, level + 1);
		}
		return map;
	}
	
	public void printView(Map<Integer, Integer> map){
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			System.out.print(entry.getValue() + " ");
		}
	}
	public void bottomView(TreeNode root){
		if(root == null)
			return;
		else {
			Map<Integer,Integer> map = new HashMap<Integer, Integer>(); // Mapping of Level to Value
			map = bottomView(root, map, 0);
			printView(map);
		}
	} 
}
