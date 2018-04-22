package Contest.Contest80;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MostCommonWord {
	 public String mostCommonWord(String paragraph, String[] banned) {
	        Map<String, Integer> map = new HashMap<String, Integer>();
	        paragraph = paragraph.toLowerCase();
	        String[] words = paragraph.split("\\s+"); 
	        
	        for(int i = 0; i < words.length; i++){
	            if(map.containsKey(words[i])) {
	                int count = map.get(words[i]) + 1;
	                map.put(words[i], count);
	            } else {
	                boolean found = false;
	                for(int j = 0; j < banned.length; j++) {
	                    if(words[i].equals(banned[j])) {
	                        found = true; break;
	                    }
	                }
	                if(!found)
	                    map.put(words[i], 1);
	            }
	        }
	        
	        int maxCount = 0;
	        String max = "";
	        for(Entry<String, Integer> entry :  map.entrySet()) {
	            if(maxCount < entry.getValue()) {
	                maxCount = entry.getValue();
	                max = entry.getKey();
	            }
	        }
	        return max;
	     }
}
