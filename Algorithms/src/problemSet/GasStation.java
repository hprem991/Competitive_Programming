package problemSet;


//http://www.programcreek.com/2014/03/leetcode-gas-station-java/
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int sumRemaining = 0;
		int remaining = 0;
		int total = 0;
		int startIndex = 0;
		for(int i=0; i< gas.length;i++){
			remaining = gas[i] - cost[i];
			if(sumRemaining>=0){
				sumRemaining += remaining;
			} else {
				sumRemaining = remaining;
				startIndex = i;
			}
			total += remaining;
		}
		if(total <= 0){
			 return -1;
		} else {
			return startIndex;
		}
	 }
}
