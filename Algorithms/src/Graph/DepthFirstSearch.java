package Graph;

import java.util.*;

//Implementation Dependent

//Adjacency List Implementation
public class DepthFirstSearch {

	private int m_Vertices;
	private LinkedList<Integer>  adjList[];
	
	public DepthFirstSearch(int aVertices){
		m_Vertices = aVertices;
		adjList = new LinkedList[aVertices];
		for(int i = 0; i < aVertices; i++)
			adjList[i] = new LinkedList();
	}
	
	public void addEdge(int vertex, int weight){
		adjList[vertex].add(weight);
	}
	
	void DFSUtil(int vertex, boolean visited[]){
		visited[vertex] = true;
		System.out.print(vertex+" "); // Print here
		Iterator<Integer> iter = adjList[vertex].listIterator();
		while(iter.hasNext()){
			int value =  iter.next();
			if(!visited[value])
				DFSUtil(value, visited);
		}
	}
	
	public void DFS(/**int vertex **/){	
		boolean visited[] = new boolean[m_Vertices];
		for(int i = 0; i < m_Vertices; i++)
			if(!visited[i])
				DFSUtil(i, visited);
	}
}
