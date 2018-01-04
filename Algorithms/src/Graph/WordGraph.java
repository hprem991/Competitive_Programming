package Graph;
import java.util.*;
import java.lang.*;

/*
 * 
 * Given two words (start and end), and a dictionary, 
 * find the length of shortest transformation sequence from start to end,
 * such that only one letter can be changed at a time and each 
 * intermediate word must exist in the dictionary.
 */

class WordNode{
	String word;
	int steps;
	
	WordNode(String word, int steps){
		this.word = word;
		this.steps = steps;
	}
}

public class WordGraph {
		public int wordLadder(String start, String end, Set<String> dict){
			
			Queue<WordNode> queue = new LinkedList<WordNode>();
			queue.add(new WordNode(start , 1));
			dict.add(end);
			
			while(!queue.isEmpty()){
				WordNode  node = queue.remove();
				if(node.word.equals(end)){
					return node.steps;
				}
				
				char[] arr = node.word.toCharArray();
				for(int i = 0; i < arr.length; i++) {
					char temp = arr[i];
					for(char c = 'a'; c <= 'z'; c++){
						 if(c != arr[i])
							 arr[i] = c;
						 String newWord = new String(arr);
						 if(dict.contains(newWord)){
							 queue.add(new WordNode(newWord, node.steps + 1));
							 dict.remove(newWord);
						 }
						 arr[i] = temp;
					}
				}
			}
			return 0;
		}
}
