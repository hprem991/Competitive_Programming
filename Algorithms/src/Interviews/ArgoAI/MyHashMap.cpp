#include <iostream>
#include <string>
#include <vector>

using namespace std;

#define SIZE 100

template <typename KeyT, typename ValueT >
class MyHashMap {
    private :
           KeyT bucket[SIZE];
           KeyT rehash[];
    public:
           MyHashMap() {
               memeset(0, SIZE, bucket, SIZE + 1);
            //   for(int i = 0; i < bucket.size(); i++)
            //       bucket[i] = null;
           }
           void insert(KeyT key, ValueT value, void( *) customHasher(KeyT key)) {
               int  bucketNo = 0;
               
                bucketNo =  customHasher(key);
                // if(String == key) {
                //     int count = 0;
                //     for(int i =0; i < key.size(); i++){
                //         count += key[i] - 'a';
                //     }
                //      bucketNo = count % SIZE;
                // } else { 
                //      bucketNo =  key % SIZE;
                // }
                int isFull = 0;
                while(bucket[bucketNo] != (SIZE + 1)) {
                      bucketNo =  customHasher(key);
                      isFull++;
                }
                if(isFull == SIZE) {
                    cout<<"Bucket is full"<<endl;
                    return;
                }
                    
                bucket[bucketNo] = value;
                rehas[key] = isFull;
           }
           
           KeyT getKey(ValueT input,  void( *) customHasher(KeyT key)) {
               int bucketNo = 0;
               for(int i = 0 ; i < rehash.size(); i++) {
                   bucketno = customHasher(input);
               }
               return bucket[bucketNo];
           }
           
};

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    MyHashMap<int, int> map;// = new MyHashMap();
    
    int arr[] = {3, 7, 89, 54, 78};
    
    for(int i : arr) {
        map.insert(i, 45 + i, (int i)->{return (i % SIZE);});
    }

    for(int i : arr) {
        cout<<map.getKey(i)<<endl;
    }
    
    
    return 0;
}

