package LinkedList;
import java.util.*;
import java.lang.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


//http://www.programcreek.com/2014/02/leetcode-intersection-of-two-linked-lists-java/
// UNtested code

/*   ALGO:- First calculate the length of two lists and find the difference. 
 * 			Then start from the longer list at the diff offset,
 *  		iterate though 2 lists and find the node.
 */


public class Intersectionof2List {
	 public Node Intersection(Node first, Node second){
		 
		 Node result = null;
		 int firstLen = 0;
		 int secondLen = 0;
		 
		 
		 Node temp1 = first;
		 Node temp2 = second;
		 while(temp1 != null){
			 temp1 = temp1.next;
			 firstLen++;
		 }
		 
		 while(temp2 != null){
			 temp2 = temp2.next;
			 secondLen++;
		 }
		 
		 
		 String  longest = firstLen > secondLen ? "First" : "Second";
		 int diff = Math.abs(firstLen - secondLen);
		 
		 Node longestList;
		 if(longest.equals("First")){
			 longestList = first;
		 } else {
			 longestList = second;
		 }
		 
		 for(int i = 0; i < diff; i++)
			 longestList = longestList.next;
		 
		 if(longest.equals("First")){
			 temp1 = longestList;
		 } else {
			 temp2 = longestList;
		 }
		 // At this point both list have equal length
		 while((temp1 != null) && (temp2 != null)){
			 if(temp1 == temp2) {
				 result = temp1;
				 break;
			 }
			 else
				 temp1 = temp1.next;
			 	 temp2 = temp2.next;
		 }
		 return result;
	 }
}
