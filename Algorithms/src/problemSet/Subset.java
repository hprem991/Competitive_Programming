package problemSet;

public class Subset {
	void subSet(String soFar, String rest){
		if(rest.isEmpty()){
			System.out.println(soFar);
		} else {
			subSet(soFar + rest.charAt(0), rest.substring(1));
			subSet(soFar, rest.substring(1));
		}
	}
	
	public void subSet(String str){
		subSet("", str);
	}
}
