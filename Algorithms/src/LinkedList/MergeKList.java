package LinkedList;
import java.lang.*;
import java.util.*;

 // Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 


public class MergeKList {
	
	public ListNode merge(ListNode l1, ListNode l2){
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		if(l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		} else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}
	
	 public ListNode partition(ListNode[] lists, int low, int high) {
		    if(low == high) return lists[low];
		    if(low < high){
		    	  int mid = (low + high) / 2;
		    	   ListNode l1 =  partition(lists, low, mid);
		    	   ListNode l2 =  partition(lists, mid + 1, high);
		    	   return merge(l1, l2);
		     }  else {
		    	 return null;
		     }  
	    }
	 
	 public ListNode mergeKLists(ListNode[] lists) {
	        return partition(lists, 0 , lists.length - 1);
	    }
}
