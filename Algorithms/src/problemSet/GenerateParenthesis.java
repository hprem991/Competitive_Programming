package problemSet;
import java.lang.*;
import java.util.*;

public class GenerateParenthesis {
	
	public void generate(List<String> result, String soFar, int left, int right, int max){
		if( soFar.length() == 2 * max) {
		   result.add(soFar);
		    return;
		}
		if(left < max){
			generate(result, soFar + "(", left + 1, right, max);
		} 
		if(right < left) {
			generate(result, soFar + ")", left, right  + 1, max);
		}
	}
	
	public List<String> generateParenthesis(int n) {
      List<String> res = new ArrayList<String>();
       generate(res, "", 0, 0, n);
       return res;
    }
}
