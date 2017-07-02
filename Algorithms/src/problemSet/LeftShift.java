package problemSet;


//Tricky question
/*
 * Algo :- Break array into 2 parts,
 *        1> reverse the first part, 
 *        2> reverse the second part 
 *        3> Now combine em and reverse the whole 
 *        */

public class LeftShift {
	  public void  reverse(int a[], int low, int high){
	        while(low < high){
	            int temp = a[low];
	            a[low] = a[high];
	            a[high] = temp;
	            low++;
	            high--;
	        }
	    }
	  
	  public void RotateArray(int array[], int arrayLength, int shiftBy){
		   	reverse(array, 0, shiftBy-1);
	        reverse(array, shiftBy, arrayLength - 1);
	        reverse(array, 0, arrayLength - 1);
	        
	        for(int i=0; i < arrayLength;i++){
	            System.out.print(array[i]+" ");
	        }  
	  }

}
