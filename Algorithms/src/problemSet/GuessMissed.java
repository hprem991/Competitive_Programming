package problemSet;
import java.util.*;

/**http://www.programcreek.com/2014/05/leetcode-bulls-and-cows-java*/

public class GuessMissed {
	public String getHint(String secret, String guess){
		String result = "";
		
		Map<Character, Integer> map =  new HashMap<Character, Integer>();
		int matchCount = 0;
		int MissedCount = 0;
		for(int i=0; i < guess.length(); i++){
		
			Character s = secret.charAt(i);
			Character g = guess.charAt(i);
			if(s == g) {
				 matchCount++;
			} else {
				if(map.containsKey(s)){
					map.put(s, map.get(s));
				} else {
					map.put(s, 1);
				}
			}
		}
		
		for(int i=0; i< secret.length(); i++){
			Character s = secret.charAt(i);
			Character g = guess.charAt(i);
			if(s != g){
				if(map.containsKey(s)){
					MissedCount++;
					if(map.get(s) == 1){
						map.remove(s);
					} else {
						map.put(s, map.get(s) - 1);
					}
				}
			}
		}
		result = matchCount+"A"+MissedCount+"B";
		return result;
	}
}
