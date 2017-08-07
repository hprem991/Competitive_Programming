package problemSet;
import java.lang.*;
import java.util.*;

public class Shuffle {
    	void shuffle(int cards[], int number){
    		for(int i = 0; i < cards.length; i++){
    			int randomIndex =  (int) (Math.random() * cards.length);
    			int temp = cards[i];
    			cards[i] = cards[randomIndex];
    			cards[randomIndex] = temp;
    		}
    	}
}
