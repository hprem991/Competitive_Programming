 public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
		    // Write your code here
		     List<Integer> result = new ArrayList<Integer>();
		 	for(int i = 0; i < a.size(); i++) {
		 		if(a.get(i).length() != b.get(i).length())
		 			result.add(-1);
		 		else {
		 			int res = 0;
		 			Map<Character, Integer> map = new HashMap<Character, Integer>();
		 			char []first = a.get(i).toCharArray();
		 			for(char c: first) {
		 				if(map.containsKey(c)) {
		 					int count = map.get(c);
		 					count++;
		 					map.put(c, count);
		 				} else {
		 					map.put(c, 1);
		 				}
		 			}
		 			
		 			char []second = b.get(i).toCharArray();
		 			for(char c : second) {
		 			   if(map.containsKey(c)) {
		 				   int count = map.get(c);
		 				   count--;
		 				   if(count == 0)
		 					   map.remove(c);
		 				   else
		 					   map.put(c, count);
		 			   }
//		 			   } else {
//		 				   res++;
//		 			   }	
		 			}
		 			
		 			for(Map.Entry<Character, Integer> entry: map.entrySet()) {
		 				res += Math.abs(entry.getValue());
		 			}
		 			result.add(res);
		 		}
		 	}
		 	return result;
	 }
