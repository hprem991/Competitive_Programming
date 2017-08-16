package Leetcode.Medium;

public class ExcelSheetConverter {
	public int convert(String s, int numRows) {
		int result = 0;
		for(int i =0; i < s.length(); i++)
			result = result * numRows + (s.charAt(i) - 'A' + 1);
		return result;
	}
}
