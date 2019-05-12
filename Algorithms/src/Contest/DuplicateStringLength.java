https://leetcode.com/contest/weekly-contest-136/problems/longest-duplicate-substring/




public String longestDupSubstring(String S) {
		String max = "";   
		for(int l = 1; l <  S.length(); l++) {
			for(int s = 0; s < S.length() - l; s++) {
				int e = s + l;
				String str = S.substring(s, e); // Form first string
				String rem = S.substring(s+1); // Form the rest of the strings
				if(rem.toLowerCase().contains(str.toLowerCase()))
					if(max.length() < str.length())
						max = str;
			}
		}
		return max;
    }
