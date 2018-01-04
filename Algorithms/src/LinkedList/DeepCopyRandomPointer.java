package LinkedList;
import java.lang.*;
import java.util.*;

class Node{
	int data;
	Node next, random;
	
	Node(){
		
	}
}

public class DeepCopyRandomPointer {
	Node deepCopyRandomPointer(Node head){
		  Node current = head;
		  while(current != null){
			  Node interm = new Node();
			  interm.next = current.next;
			  current.next = interm;
			  
			  current = current.next.next; // Remember this next.next wont crash coz current.next is always interm a valid just created node
		  }
		  
		  //Copy the random pointer
		  current = head;
		  while(current != null){
			  current.next.random = current.random.next; // we are setting pointer to the next of the random node
			  current = (current.next != null) ? current.next.next : current.next;
		  }
		  
		  // Segregate the 2 nodes
		  current = head;
		  Node clone =  head.next;
		  Node cloneStart = head.next;
		  
		  while((current != null) && (clone != null)){
			  current.next = (current.next != null) ? current.next.next : current.next;
			  clone.next = (clone.next != null) ? clone.next.next : clone.next;
			  current = current.next;
			  clone = clone.next;
		  }
		  
		  return cloneStart;
	}
}
