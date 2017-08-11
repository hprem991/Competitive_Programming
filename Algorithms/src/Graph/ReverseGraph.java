package Graph;
import java.lang.*;
import java.util.*;


// Taken from StackOverFlow
//Reversing the adjacency lists of a Directed Graph can be done in linear time. We traverse the graph only once. Order of complexity will be O(|V|+|E|).
//
//Maintain a HashMap of Adjacency Lists where the key is the vertex label and the value is an ArrayList of adjacent vertices of the key vertex.
//For reversing, create a new HashMap of the same kind. Scan the original hash map and for each key you come across, traverse the corresponding list.
//For each vertex found in the value list, 
//			add a key in the new hashMap, putting the key of the original HashMap as an entry in the ArrayList 
//			corresponding to the new key in the new HashMap.


public class ReverseGraph {
	public static HashMap<Character,ArrayList <Character>> getReversedAdjLists(RGraph g)
	{
	    HashMap <Character, ArrayList<Character>> revAdjListMap = new HashMap <Character, ArrayList<Character>>();
	    Set <Character> oldLabelSet = g.adjListMap.keySet();

	    for(char oldLabel:oldLabelSet)
	    {
	        ArrayList<Character> oldLabelList = g.adjListMap.get(oldLabel);

	        for (char newLabel : oldLabelList)
	        {
	            ArrayList<Character> newLabelList = revAdjListMap.get(newLabel);

	            if (newLabelList == null)
	            {
	                newLabelList = new ArrayList<Character>();
	                newLabelList.add(oldLabel);
	            }
	            else if ( ! newLabelList.contains(oldLabel))
	            {
	                newLabelList.add(oldLabel);
	            }

	            revAdjListMap.put(newLabel, newLabelList);
	        }
	    }

	    return revAdjListMap;
	}
}
