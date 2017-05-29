package Driver;

/**
 * @author Prem
 * 
 */

import problemSet.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hello World");
		SolutionInterface sol; // This is an Interface and we are using dynamic dispatch to call various problemset
		
		sol  = new ExcelSheetConverter();
		
		System.out.println(sol.convert("AB", 2));
		//System.out.println(sol.wordPattern("abba", "dog cat cat fish"));
	}
}
