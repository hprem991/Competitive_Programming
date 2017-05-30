package problemSet;
import java.util.*;

public class MaxInArray {
	// Max Element Frequency O(1) space, O(n) time complexity
	public int maxFreq(int array[]){
		int maxFreq = 0, maxElem = 0;
		for(int elem : array){
			if(elem == maxElem)
				maxFreq ++;
			else if(elem > maxElem){
				maxElem = elem;
				maxFreq = 1;
			}
		}
		return maxFreq;
	}
}
