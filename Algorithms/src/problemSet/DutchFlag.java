package problemSet;
import java.util.*;
import java.lang.*;
//http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/

public class DutchFlag {
	void DutchFlag(int a[], int arr_size){
		int low = 0;
		int high = arr_size - 1;
		int mid = 0;
		int temp = 0; // Swapper Variable
		while(mid <= high){
			switch(a[mid]){
			case 0 :
				  temp = a[low];
				  a[low] = a[mid];
				  a[mid] = temp;
				  low++;
				  mid++;
				  break;
			case 1:
					mid++; 
					break;
			case 2:
				  temp = a[mid];
				  a[mid] = a[high];
				  a[high] = temp;
				  high--;
				  break;
			}
		}
	}
}
