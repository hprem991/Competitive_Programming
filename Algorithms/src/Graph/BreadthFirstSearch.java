package Graph;
import java.util.*;

public class BreadthFirstSearch {
	private int m_Vertices;
	private LinkedList<Integer> adjList[];
	
	public void addEdge(int vertex, int weight){
		adjList[vertex].add(weight);	
	}
	
	public BreadthFirstSearch(int aVertices){
		m_Vertices =  aVertices;
		adjList = new LinkedList[aVertices];
		for(int i = 0; i< aVertices; i++){
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	public void BFS(int vertex){
		boolean visited[] = new boolean[m_Vertices];
		visited[vertex] = true;
		Queue<Integer> queue =  new LinkedList<Integer>();
		
		queue.add(vertex);
		while(!queue.isEmpty()){
			int vertx =  queue.poll();
			System.out.println("Vertex is -> "+vertx);
			Iterator<Integer> iter =  adjList[vertx].listIterator();
			while(iter.hasNext()){
				int elem =  iter.next();
				if(!visited[elem]){
					visited[elem] = true;
					queue.add(elem);
				}
			}
		}
	}
	
}
