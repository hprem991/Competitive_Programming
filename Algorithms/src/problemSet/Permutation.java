package problemSet;
import java.lang.*;
import java.util.*;

public class Permutation {

	 void Permute(String soFar, String rest){
		if(rest.isEmpty()){
			System.out.println(soFar);
		} else {
			for(int i = 0; i < rest.length() ; i++){
				String next = soFar + rest.charAt(i);
				String remaining = rest.substring(0, i) + rest.substring(i + 1); 
				Permute(next, remaining);
			}
		}
	}
	
	public void Permute(String str){
		Permute("", str);
	}
	
	
	 //Hide redundancy
	 List<String> PermuteString(String soFar, String rest, List<String> result){
		if(rest.isEmpty()){
			if(!result.contains(soFar)) // Can't put this if along with the first check for not letting fall into else case
				result.add(soFar);
		} else {
			for(int i = 0; i < rest.length() ; i++){
				String next = soFar + rest.charAt(i);
				String remaining = rest.substring(0, i) + rest.substring(i + 1); 
				PermuteString(next, remaining, result);
			}
		}
		return result;
	}
	
	public List<String> PermuteString(String str){
		List<String> result = new ArrayList<String>();
		return PermuteString("", str, result);
	}
	
	
	
}
