package problemSet;

public class Permutation {

	 void Permute(String soFar, String rest){
		if(rest.isEmpty()){
			System.out.println(soFar);
		} else {
			for(int i = 0; i < rest.length() ; i++){
				String next = soFar + rest.charAt(i);
				String remaining = rest.substring(0, i) + rest.substring(i + 1); 
				Permute(next, remaining);
			}
		}
	}
	
	public void Permute(String str){
		Permute("", str);
	}
}
