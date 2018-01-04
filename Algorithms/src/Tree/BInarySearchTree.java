package Tree;

public class BInarySearchTree {
		
	public boolean isSame(Tree t1, Tree t2){
		if(t1 == null) 
			return t2 == null ? true : false;
		if(t2 == null)
			return t1 == null ? true : false;
		if(t1.key == t2.key){
			return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
		} else {
			return false;
		}
	}
}
