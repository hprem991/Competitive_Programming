package Leetcode.Medium;
import java.lang.*;
import java.util.*;


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }


public class AddTwoNumber {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode first = l1;
		ListNode second = l2;
		ListNode head = new ListNode(0);
		ListNode ref = head;
		int sum = 0;
		
		while( (l1 != null) || (l2 != null)){
			sum /= 10; // Carry from last Calculation
			if(l1 != null){
				sum += l1.val;
				l1 = l1.next;
			}
			
			if(l2 != null){
				sum += l2.val;
				l2 = l2.next;
			}	
			ref.next = new ListNode(sum % 10);
			ref = ref.next;
		}
		if(sum / 10 == 1)
			ref.next = new ListNode(sum / 10);
		return head.next;
	}
	
	// Extremely hard way but faster as inplace
	 public ListNode addTwoNumbersHard(ListNode l1, ListNode l2) {
		 	
		    ListNode headRef1 = l1;
		    ListNode headRef2 = l2;
		    ListNode lastNode;
		    if(l1 != null)
		    	lastNode = l1;
		    else
		    	lastNode = l2;
		 	int previousCarry = 0, currentCarry = 0;
		 	String longestList = "";
		 	while((l1 != null) || (l2 != null)){
		 		
		 		// both list is not empty
		 		if((l1 != null) && (l2 != null)){ 
		 			int sum = l1.val + l2.val + previousCarry;
		 			if(sum > 9){
		 				currentCarry = 1;
		 				sum = sum % 10;
		 			} else {
		 				currentCarry = 0;
		 			}
		 			l1.val = l2.val = sum;
		 			lastNode = l1;
		 			l1 = l1.next;
		 			l2 = l2.next;
		 		} else if(l1 == null) {
                 int sum = l2.val + previousCarry;
		 			if(sum > 9){
		 				currentCarry = 1;
		 				sum = sum % 10;
		 			} else {
		 				currentCarry = 0;
		 			}
		 			l2.val = sum;
		 			lastNode = l2;
		 			l2 = l2.next;
		 		} else if(l2 == null) {
                 int sum = l1.val + previousCarry;
		 			if(sum > 9){
		 				currentCarry = 1;
		 				sum = sum % 10;
		 			} else {
		 				currentCarry = 0;
		 			}
		 			l1.val = sum;
		 			lastNode = l1;
		 			l1 = l1.next;
		 		}
		 		
		 		if(longestList.isEmpty()) { // Yet to figure out which one is longest
		 			if((l1 == null) && (l2 == null))
		 				longestList ="First"; // either one can be returned
		 			else if((l1 != null) && (l2 == null))
		 				longestList = "First";
		 			else if((l1 == null) && (l2 != null))
		 				longestList = "Second";
		 		 }  // else its already figured out
		 		
		 		previousCarry = currentCarry;
		 	}
		 	
		 	if(previousCarry == 1){
		 		ListNode newNode = new ListNode(1);
		 		newNode.next = null;
		 		lastNode.next = newNode;
		 	}
		 	
		 	if(longestList.equals("First") ? true : false)
		 		return headRef1;
		 	else
		 		return headRef2;
	   }
}
