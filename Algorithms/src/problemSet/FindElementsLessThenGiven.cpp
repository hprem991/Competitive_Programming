//This is the question asked and coded correctly for Roku Telephonic


int BSearchCount(vector<int> sortedVec, int low, int high, int lessThan) {
    if(low > high)
         return -1;
    else {
        int mid = (low + high) / 2;
        if(sortedVec[mid] ==  lessThan)
            return mid;
        if(sortedVec[mid] < lessThan)
            return BSearchCount(sortedVec, mid + 1, high, lessThan);
        else 
           return BSearchCount(sortedVec, low, mid, lessThan);
    }
}


// Complete the countNumbers function below.
int countNumbers(vector<int> sortedVector, int lessThan) {

    return BSearchCount(sortedVector, 0, sortedVector.size(), lessThan);    
}

//Writing the Iterative version of Binary Search

int countNumbers(vector<int> sortedVector, int lessThan) {
   int low = 0;
   int high = sortedVector.size();
   while(low < high) {
	   int mid = (low + high ) / 2; 
      if(sortedVector[mid] == lessThan) 
	      return mid;
      else if(sortedVector[mid] < lessThan)
	      low = mid + 1;
      else
	      high = mid;
   }
   return -1;
}
