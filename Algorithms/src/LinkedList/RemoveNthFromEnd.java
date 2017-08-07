package LinkedList;
import java.lang.*;
import java.util.*;

public class RemoveNthFromEnd {
	
	// This Logic should work, but Java got referece issue fix that using new head
	 public ListNode removeNthFromEnd(ListNode head, int n) {
			ListNode far = head;
		 	ListNode near = head;
		 	
		 	for(int i=0; ((i <= n) && (far != null)); i++){
		 		far = far.next; // Moved by n nodes
		 	}
		 	
		 	while(far != null){
		 		near = near.next;
		 		far = far.next;
		 	}
        if(near.next != null)
		 	near.next = near.next.next;
        else 
            near = near.next;
		 	return head;
	   }
}
