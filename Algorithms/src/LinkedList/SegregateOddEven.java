package LinkedList;
import java.lang.*;
import java.util.*;

//http://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/


//The idea is to split the linked list into two: one containing all even nodes and other containing all odd nodes. 
//And finally attach the odd node linked list after the even node linked list.


public class SegregateOddEven {
	 public void segregateEvenOdd(Node head) {
         
	        Node evenStart = null;
	        Node evenEnd = null;
	        Node oddStart = null;
	        Node oddEnd = null;
	        Node currentNode = head;
	         
	        while(currentNode != null) {
	            int element = currentNode.data;
	             
	            if(element % 2 == 0) {
	                 
	                if(evenStart == null) {
	                    evenStart = currentNode;
	                    evenEnd = evenStart;
	                } else {
	                    evenEnd.next = currentNode;
	                    evenEnd = evenEnd.next;
	                }
	                 
	            } else {
	                 
	                if(oddStart == null) {
	                    oddStart = currentNode;
	                    oddEnd = oddStart;
	                } else {
	                    oddEnd.next = currentNode;
	                    oddEnd = oddEnd.next;
	                }
	            }
	                        // Move head pointer one step in forward direction
	            currentNode = currentNode.next; 
	        }
	         
	         
	        if(oddStart == null || evenStart == null) {
	            return;
	        }
	         
	        evenEnd.next = oddStart;
	        oddEnd.next = null;
	        head=evenStart;
	    }
}
