package common.Search;

public class MergeSort {
	
	void mergeSort(int elements[], int low, int high) {
		if(low < high){
			int mid = (low + high ) / 2;
			mergeSort(elements, low, mid);
			mergeSort(elements, mid + 1, high);
			merge(elements, low, mid, high);
		}
	}
	
	void merge(int elements[], int low, int mid, int high) {
		
		int i , j , k;
		int temp[] = new int[elements.length];
		i = low;
		j = low;
		k =  mid;
		
		while((i < mid ) && ( k < high)) {
			if(elements[i] < elements[k]) {
				temp[j++] = elements[i++];
			} else {
				temp[j++] = elements[k++];
			}
		}
		
		while(i < mid) {
			temp[j++] = elements[i++];
		}
		
		while(k < high) {
			temp[j++] = elements[k++];
		}
		
		elements = temp.clone(); // Careful with this clone tho, as if the objects has an internal references, it will mess up
	}
}
