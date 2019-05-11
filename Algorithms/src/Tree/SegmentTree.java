package Tree;


// Segment Tree is a basically a Tree which represents the range based query efficiently.
// In order to reduce the Space complexity, Array based representation of Segment Tree gives the best results
class SegmentTreeNode{
	int val;
	SegmentTreeNode left;
	SegmentTreeNode right;	
}


public class SegmentTree {

	private static final int NODES = 100; // This is the only way to get a features like C++ #define in Java
	static SegmentTree []segmentTree = new SegmentTree[NODES];

	int ConstructSegmentTree(int arr[], int start, int end, SegmentTree SegmentTree, int SegmentTreeNodePosition) {
		if(start == end) {
			// If we have reached dividing, we fill the the array Index with the Index we reached
			SegmentTree[SegmentTreeNodePosition] = arr[start];
			return arr[start];
		} 
		
		int mid = ( start + end ) / 2;
		SegmentTree[SegmentTreeNodePosition] = Math.min(ConstructSegmentTree(arr, start, mid, SegmentTree, 2 * SegmentTreeNodePosition + 1),
														ConstructSegmentTree(arr, start, mid + 1, SegmentTree, 2 * SegmentTreeNodePosition + 2));
		return SegmentTree[SegmentTreeNodePosition];
	}
}

