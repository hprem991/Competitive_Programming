package Tree;

//class Tree{
//	Tree  left, right;
//	int val;
//}

public class DifferentViews {
	static int max_visited_level = 0; // Important to track whats the max level visited so far
	
	// Left View
	public void leftview(Tree tree, int level){
		if(tree == null)
			return;
		if(level > max_visited_level){
			System.out.println(tree.left);
			max_visited_level = level;
		}
		
		leftview(tree.left, level + 1);

		leftview(tree.right, level + 1);
	} 
	
	//Right View
	public void rightview(Tree tree, int level){
		if(tree == null)
			return;
		if(level > max_visited_level){
			System.out.println(tree.right);
			max_visited_level = level;
		}
		
		leftview(tree.left, level + 1);

		leftview(tree.right, level + 1);
	} 
	
	//Top View
}
