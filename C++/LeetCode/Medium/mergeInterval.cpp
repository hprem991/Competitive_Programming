https://leetcode.com/problems/merge-intervals/



 vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if(intervals.size() < 2)
            return intervals;
        sort(intervals.begin(), intervals.end());
        for(int  i = 1 ; i < intervals.size(); ){
           if(intervals[i - 1][1] >= intervals[i][0]) {
               // This is a merge Case
               intervals[i - 1][0] = min(intervals[i - 1][0], intervals[i][0]);
               intervals[i - 1][1] = max(intervals[i - 1][1], intervals[i][1]);
               intervals.erase(intervals.begin() + i); // Delete that index, so now that index refers to the next value
           } else {
               i++;
           }
        }
        return intervals;
    }
