package Contest.Contest80;

// Edge Cases Missing
// Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
public class LinkedListComponents {
	 public int numComponents(ListNode head, int[] G) {
		 int components = 0;
		 int currentGIndex  = 0;
		 boolean lastMatched = false;
		 int len = G.length;
		 while(head != null){
			 if(G[currentGIndex] != head.val){
				 if(lastMatched) {
					 lastMatched = false;
					 components++;
				 }
			 } else {
				 lastMatched = true;
				 if(len <= ++currentGIndex)
					 currentGIndex++;
				 else 
					 break;
			 }
			 head = head.next;
		 }
		 if(lastMatched)
             components++;
		 return components ;
	    }
}
