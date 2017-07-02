package problemSet;
import java.lang.*;
import java.util.Comparator;
import java.util.*;


//QUESTION -> https://www.careercup.com/question?id=5748104113422336


class FreqWord{
	int count;
	String word;
	
	public String getWord(){
		return word;
	}
	
	int getCount(){
		return count;
	}
	
	void setCount(int aIncount){
		count = aIncount;
	}
}

public class PriorityQueueExample {
	public void maxFreqWordusingPQ(String words[]){
		PriorityQueue<FreqWord> pq = new PriorityQueue<FreqWord>( new Comparator<FreqWord>(){ 
			public int compare(FreqWord first, FreqWord second) {
				return (first.getCount() - second.getCount());
			}});
		
		// Void Implementation
				
		}
	
	
	//This works but need to replace the implementation with PQ;
	// Also you can use TreeMap or Sort this map
	
	public String maxFreqWord(String words[]){
	  Map<String, Integer> map = new HashMap<String, Integer>();
	  for(int i = 0; i<words.length; i++){
		  if(map.containsKey(words[i])){
			  int count = map.get(words[i]);
			  count++;
			  map.put(words[i], count );
		  } else {
			  map.put(words[i], 1);
		  }
	  }
	  
	  int MaxCount = 0;
	  int SecondCount  = 0;
	  String MaxWord = "";
	  String secondWord = "";
	  for(Map.Entry<String, Integer> entry: map.entrySet()){
		  if(entry.getValue() > MaxCount){
			  secondWord = MaxWord;
			  MaxWord = entry.getKey();
			  MaxCount = entry.getValue();
		  } else if(entry.getValue() > SecondCount){
			  secondWord = entry.getKey();
			  SecondCount = entry.getValue();
		  }
	   }
	  return secondWord;
	}
}
