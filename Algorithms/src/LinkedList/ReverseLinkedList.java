package LinkedList;
import java.util.*;
import java.lang.*;

class Node{
	int data;
	Node next;
	
	Node(int data, Node node){
		this.data = data;
		this.next = node;
	}
}
// Untested code

public class ReverseLinkedList {
    public Node reverseLinkedList(Node head){
    	if(head == null){
    		return head;
    	} else {
    		Node headRef = head;
    		Node nextNode = head.next;
    		while(nextNode.next != null){
    			Node nextToNextNode =  nextNode.next;
    			nextNode.next = head;
    			head = nextNode;
    			nextNode = nextToNextNode;
    		}
    		return nextNode;
    	}
    }
}
