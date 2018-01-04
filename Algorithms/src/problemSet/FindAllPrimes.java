package problemSet;
import java.util.*;

public class FindAllPrimes {
	public void allPrimes(int num){
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 2; i < num ;i++){
			result.add(i);
		}
		for(int i = 2; i < num ; i++){
			int temp = i * 2; // Dont remove the first occurance
			for(int j = 3; temp < num; j++){
				result.remove(Integer.valueOf(temp)); // Remember Integer.valueOf(temp)
				temp = j * i;
			}
		}
		
		for(int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
	}
}
