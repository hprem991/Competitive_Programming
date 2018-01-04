package problemSet;

import java.util.*;

class Point {
	int x, y;
	int distance;
	
	Point(int x, int y, int distance){
		this.x = x;
		this.y =y;
		this.distance = distance;
	}
	
	Point(Point point, int distance){
		this.x = point.x;
		this.y = point.y;
		this.distance = distance;
	}
	
	boolean compare(Point point){
		return ((this.x == point.x) && (this.y == point.y));
	}
}

public class Maze {
	
	    boolean ValidPoint(int matrix[][], Point point){
	    	return ((point.x >=0) && (point.x <= matrix.length) &&
	    			(point.y >=0) && (point.x <= matrix[0].length));   	
	    }
	    
	    boolean Moveable(int matrix[][], Point point){
	    	return matrix[point.x][point.y] != 0;
	    }
	   
		public void findPath(int[][] matrix, Point src, Point dst){
			 ArrayList<Point> visited = new ArrayList<Point>();
			 visited.add(new Point(src, 0));
			 
			 Queue<Point> queue = new LinkedList<Point>();
			 
			 queue.offer(src);
			 
			 while(!queue.isEmpty()){
				 Point point = queue.peek();
				 if(point.compare(dst)){
					 // Found the path
					 //return point;
					 System.out.println("Distance is"+point.distance);
					 return;
				 }
				  queue.poll();
				  //Look for all the 4 direction from the current point
				  
				  Point nextPoint;
				  
				  //Look down from the current point;
				  nextPoint = new Point(point.x + 0,  point.y + 1, point.distance + 1);
				  if(ValidPoint(matrix, nextPoint) && Moveable( matrix, point) && !visited.contains(nextPoint)){
					  visited.add(nextPoint);
					  queue.offer(nextPoint);
				  }
				  
				  //Look up from the current point;
				  nextPoint = new Point(point.x + 0,  point.y - 1, point.distance + 1);
				  if(ValidPoint(matrix, nextPoint) && Moveable( matrix, point) && !visited.contains(nextPoint)){
					  visited.add(nextPoint);
					  queue.offer(nextPoint);
				  }
				  
				  //Look right from the current point;
				  nextPoint = new Point(point.x + 1,  point.y + 0, point.distance + 1);
				  if(ValidPoint(matrix, nextPoint) && Moveable( matrix, point) && !visited.contains(nextPoint)){
					  visited.add(nextPoint);
					  queue.offer(nextPoint);
				  }
				  
				  //Look left from the current point;
				  nextPoint = new Point(point.x - 1,  point.y + 0, point.distance + 1);
				  if(ValidPoint(matrix, nextPoint) && Moveable( matrix, point) && !visited.contains(nextPoint)){
					  visited.add(nextPoint);
					  queue.offer(nextPoint);
				  }	  
			  }
	    }
   }
