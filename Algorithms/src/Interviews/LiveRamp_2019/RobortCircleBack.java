public static List<String> doesCircleExist(List<String> commands) {
		    // Write your code here
		       List <String> result = new ArrayList<String>();
		       for(int robert = 0; robert < commands.size(); robert++) {
		    	   	int x = 0, y = 0, i = 0, d[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		    	   	String inputString = commands.get(robert);
		       		for (int j = 0; j < inputString.length(); ++j) {
		       			if (inputString.charAt(j) == 'R')
		       				i = (i + 1) % 4;
		       			else if (inputString.charAt(j) == 'L')
		       				i = (i + 3) % 4;
		       			else {
		       				x += d[i][0];
		       				y += d[i][1];
		       			}
		       		}
		        result.add ( (x == 0 && y == 0 || i > 0) ? "YES" : "NO");
		       }
		       return result;

		    }
