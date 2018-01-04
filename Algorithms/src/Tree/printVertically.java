package Tree;
import java.util.*;
import java.util.Map.Entry;
import java.lang.*;

// Structure for a binary tree node
class Tree
{
    int key;
    Tree left, right;
}
 

public class printVertically {
	// A utility function to create a new node
	public Tree createNode(int key)
	{
	    Tree node = new Tree();
	    node.key = key;
	    node.left = node.right = null;
	    return node;
	}
	
	void fillDeviation(Tree node, HashMap<Integer, ArrayList<Tree>> map, int currentDeviation){
		if(node == null)
			return;
	
		 ArrayList<Tree> nodes = map.get(currentDeviation);
		 nodes.add(node);
		 map.put(currentDeviation, nodes);
		
		 fillDeviation(node.left, map, currentDeviation - 1);

		 fillDeviation(node.right, map, currentDeviation + 1);
	}
	
	void printVertical(Tree root){
		// This map can be used a deviation to the list of node in that vertical deviation
		HashMap<Integer, ArrayList<Tree> > map = new HashMap<Integer, ArrayList<Tree> >();
		
		int initialDeviation = 0;
		
		fillDeviation(root, map, initialDeviation);
		
		for(Entry<Integer, ArrayList<Tree>> entry: map.entrySet()){
			ArrayList<Tree> nodes = entry.getValue();
			for(int i = 0; i < nodes.size(); i++){
				System.out.println("Print Deviation "+entry.getKey()+" Value "+nodes.get(i).key);
			}
		}	
	}	
}
