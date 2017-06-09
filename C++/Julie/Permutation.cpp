#include <iostream>
#include <string>
using namespace std;

class Permutation {
 public:
	void Permute(string soFar, string rest){
	 if(rest == ""){
	   cout<<soFar<<endl;
	 } else {
	   for(int i = 0; i < rest.size() ; i++){
		string next = soFar + rest[i];
		string remaining = rest.substr(0, i) + rest.substr(i + 1); 
		Permute(next, remaining);
		}
	 }
    } 
};


int main() {
 Permutation permute;
 permute.Permute("", "abcd");
 return 0;
}
