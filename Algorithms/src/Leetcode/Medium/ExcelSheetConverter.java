package Leetcode.Medium;

public class ExcelSheetConverter {
	
	// Converting String to a number
	public int convert(String s, int numRows) {
		int result = 0;
		for(int i =0; i < s.length(); i++)
			result = result * numRows + (s.charAt(i) - 'A' + 1);
		return result;
	}
	
	//Converting String to a number
	//Recursive One Liner
	public int titleToNumber(String s) {
		return s.isEmpty() ? 0 : 26 * titleToNumber(s.substring(0,s.length()-1)) + s.charAt(s.length() - 1) -'A'+1;
	}
	
	// Converting number to a String Column
	public String convertToTitle(int n) {
			return n == 0 ? "" : convertToTitle((n - 1) / 26) + (char) ((n - 1) % 26 + 'A');
	}
}
