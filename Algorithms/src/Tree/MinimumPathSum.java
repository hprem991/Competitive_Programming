package Tree;
import java.lang.*;
import java.util.*;

public class MinimumPathSum {
	int minSumPath(TreeNode root) {
	    if(root == null)
	        return 0;

	    int sum = root.data;

	    int left_sum = minSumPath(root.left);
	    int right_sum = minSumPath(root.right);

	    if(left_sum <= right_sum)
	        sum += left_sum;
	    else
	        sum += right_sum;

	    return sum;
	}
}
