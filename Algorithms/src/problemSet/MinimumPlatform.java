package problemSet;
import java.lang.*;
import java.util.*;

public class MinimumPlatform {
     public int minimumNoOfPlatform(int start[], int end[]){
    	 Arrays.sort(start);
    	 Arrays.sort(end);
    	 
    	 int platform = 1, max = 1;
    	 int i = 1;
    	 int j = 0;
    	 while((i<start.length) && (j<end.length)){
    		 if(start[j] < end[i]){ // If another starts before this gets end
    			 platform++;
    			 j++;
    			 if(platform > max)
    				 max = platform;
    		 } else{
    			 platform--;
    			 i++;
    		 }
    	 }
    	 return platform;
     }
}

