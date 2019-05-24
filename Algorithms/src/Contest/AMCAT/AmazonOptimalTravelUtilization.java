 List<List<Integer>> optimalUtilization(int maxTravelDist, 
              List<List<Integer>> forwardRouteList,
              List<List<Integer>> returnRouteList)
	  	{
		  
		   int  maxOpt = 0;
		   List<List<Integer>> result = new ArrayList<List<Integer>>();
		    Map<Integer, List<List<List<Integer>>>> map = new TreeMap<Integer, List<List<List<Integer>>>>(Collections.reverseOrder());
		   for(int i = 0; i < forwardRouteList.size(); i++) {
			   for(int j = 0; j < returnRouteList.size(); j++) {
				     int traveldist = forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1);
				     if(traveldist <= maxTravelDist) {
				    	 List<Integer> pair = new ArrayList<Integer>();
				    	 pair.add(forwardRouteList.get(i).get(0));
				    	 pair.add(returnRouteList.get(j).get(0));
				    	 List<List<Integer>> res = new ArrayList<List<Integer>>();
				    	 res.add(pair);
				    	 if(map.containsKey(traveldist)) {
				    		 List<List<List<Integer>>> curr = map.get(traveldist);
				    		 curr.add(res);
				    		 map.put(traveldist, curr);
				    	 } else {
				    		 List<List<List<Integer>>> curr = new ArrayList<List<List<Integer>>>();
				    		 curr.add(res);
				    		 map.put(traveldist, curr);
				    	 }
				     }
			      }
			   }
		   	
		     for(Map.Entry<Integer, List<List<List<Integer>>>> entry : map.entrySet()) {
		    	 int key = entry.getKey();
		    	  if(key >= maxOpt) {
		    		  for(int i = 0; i < entry.getValue().size(); i++) {
		    			  result.addAll(entry.getValue().get(i));
		    		  }
		    		  maxOpt = key;
		    	  } 
		     }
		     return result;
	  		}
	  
