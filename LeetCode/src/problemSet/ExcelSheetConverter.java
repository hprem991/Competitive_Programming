package problemSet;

import java.util.ArrayList;

public class ExcelSheetConverter implements SolutionInterface {

// Convert Functionality 	
public String convert(String s, int numRows) {
	   String res =""; 
	   int currentRow = 1;
	   for(int i = 0; i < s.length(); ){
	            res += s.charAt(i);
	            i += numRows;
	            if(i > s.length()) {
	                i = currentRow;
	                if(currentRow < numRows)
	                   currentRow++;
                } //End of if
	       }
	       return res;
	  }

@Override
public int LongestCommonSubSequence(String first, String second) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
	// TODO Auto-generated method stub
	return null;
}
}
