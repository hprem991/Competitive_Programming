package problemSet;
import java.util.*;

public class ThreeSum {
	void ThreeSum(int arr[]) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				int findNum = -(arr[i] + arr[j]);
				if(hashSet.contains(findNum)) {
					System.out.println("Found Numbers as "+findNum+" "+arr[i]+" "+arr[j]+" ");
					return;
				} else {
					hashSet.add(findNum);
				}
			}
		}
	} 
}

