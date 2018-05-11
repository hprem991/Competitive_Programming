package Leetcode.Hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	  public List<String> fullJustify(String[] words, int maxWidth) {
	      ArrayList<String>  word =  new ArrayList<String>();
	      ArrayList<String>  result =  new ArrayList<String>();
	      int totalSpaces = 0;
		  for(int i=0; i < words.length; ){
			  if((totalSpaces + words[i].length() ) <=  maxWidth) {
				  word.add(words[i]);
				  totalSpaces += words[i].length();
				  if(!word.isEmpty()) // If this is not the first word :// Logic is to add spaces + word
					  totalSpaces++;// One extra space
				  i++; // Goto Next Character
			  } else {
				  int equalSpace = maxWidth / word.size();
				  String line = "";
				  for(int wordCounter = 0; wordCounter < word.size(); wordCounter++){
					  line += word.get(wordCounter);
					  for(int spaceCounter = 0 ; ((spaceCounter < equalSpace) && ( wordCounter < word.size())); spaceCounter++){
						  line += " ";
					  } // End of Space Addition
				  } // End of all Words Collected for the line
				  result.add(line);
				  word =  new ArrayList<String>();
				  totalSpaces = 0;
			  }
		  }
		  
		  // If loop existed before line delimiter then add those words in equal space
		  
		  if(!word.isEmpty()) {  
			  int equalSpace = maxWidth / word.size();
			  String line = "";
			  for(int wordCounter = 0; wordCounter < word.size(); wordCounter++){
				  line += word.get(wordCounter);
				  for(int spaceCounter = 0 ; (spaceCounter < equalSpace) ; spaceCounter++){
					  line += " ";
				  } // End of Space Addition
			  } // End of all Words Collected for the line
			  result.add(line);
			  word =  new ArrayList<String>();
			  totalSpaces = 0;
		  }
		  
		  return result;
	  }
}
