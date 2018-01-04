package problemSet;
import java.util.*;
import java.lang.*;

//https://discuss.leetcode.com/topic/2289/my-o-n-solution-using-a-stack

/* ALGO :
 * The workflow of the solution is as below.

1> Scan the string from beginning to end.
2> If current character is '(',
push its index to the stack. If current character is ')' and the
character at the index of the top of stack is '(', we just find a
matching pair so pop from the stack. Otherwise, we push the index of
')' to the stack.
3> After the scan is done, the stack will only
contain the indices of characters which cannot be matched. Then
let's use the opposite side. that is substring between adjacent indices
should be valid parentheses.

4> If the stack is empty, the whole input
string is valid. Otherwise, we can scan the stack to get longest
valid substring as described in step 3.
 */
	
public class LongestBalancedParenthesis {
	public int longestValidParenthesis(String str){
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == '('){
				stack.push(i);
			} else {
				if(!stack.isEmpty() && str.charAt(stack.peek()) == '('){
					stack.pop();
				} else {
					stack.push(i);
				}
			}
		}
		
		if(stack.isEmpty()) 
			return str.length();
		
		int longest = 0;
		int lowerIndex = 0; 
		int upperIndex = str.length();
		
		while(!stack.isEmpty()){
			lowerIndex = stack.pop();
			longest = Math.max(longest, upperIndex - lowerIndex - 1);
			upperIndex = lowerIndex;
		}
		return Math.max(longest, upperIndex);
	}
}
