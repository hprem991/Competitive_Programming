package LinkedList;
import java.util.*;
import java.lang.*;


public class ReverseKNodesGroups {
	
	public Node reverseKNode(Node head, int k){
		int count = 0;
		Node current  =  head;
		Node next = null;
		Node pre = null;
		Node start = head;
		while((current != null) && (count < k)){
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
			count++;
		}
		
		if(next != null)
			head.next = reverseKNode(next, k);
		
		return pre;
	}
}
