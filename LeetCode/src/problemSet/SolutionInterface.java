/**
 * 
 */
package problemSet;

import java.util.ArrayList;

/**
 * @author Prem
 * Purpose: To allow one Driver to Manage all Problem Set
 *
 */
public interface SolutionInterface {
	// List the method you wanna create
	public String convert(String s, int numRows);
	public int LongestCommonSubSequence(String first, String second);
	public ArrayList<Integer> medianSlidingWindow(int[] nums, int k);
}
