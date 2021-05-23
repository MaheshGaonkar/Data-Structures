package graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

enum Color{WHITE,GRAY,BLACK}

/*
 * @author Mahesh Gaonkar
 * @Date 12/12/2016
 */

public class GraphTraversal<T>{
	
	private Set<T> visited;
	//private Map<T, Color> color;
	private Queue<Vertex<T>> queue;
	private Map<T, Integer> distance;
	private Map<T, Integer> finishedTime;
	private Map<T, T> parent;
	
	private void init(){
		visited = new HashSet<T>();
		queue = new LinkedList<Vertex<T>>();
		distance = new HashMap<T, Integer>();
		finishedTime = new HashMap<T, Integer>();
		parent = new HashMap<T,T>();
		//color = new HashMap<T, Color>();
	}
	
	public void BFS(Graph<T> graph){
		init();
		
		Collection<Vertex<T>> vertices = graph.getAllVertex();
		/*
		for(Vertex<T> vertex : vertices){
			color.put(vertex.getId(), Color.WHITE);
		} */
		
		for(Vertex<T> vertex : vertices){
			//if(color.get(vertex.getId() == Color.WHITE)
			if(!visited.contains(vertex.getId())){ 
				//color.put(vertex.getId(), Color.GRAY);
				distance.put(vertex.getId(), 0);
				parent.put(vertex.getId(), null);
				queue.add(vertex);
				visited.add(vertex.getId());

				while(!queue.isEmpty()){
					Vertex<T> temp = queue.poll();
					for(Vertex<T> v : temp.getAdjacentVertexes()){
						//if(color.get(v.getId() == Color.WHITE){
						if(!visited.contains(v.getId())){
							queue.add(v);
							visited.add(v.getId());
							//color.put(v.getId(), Color.GRAY);
							int dis = 1 + distance.get(temp.getId());
							distance.put(v.getId(), dis);
							parent.put(v.getId(), temp.getId());
						}
						//color.put(temp.getId(), Color.BLACK);
					}
				}
			}
		}
	}

	public void DFS(Graph<T> graph){
		init();
		Collection<Vertex<T>> vertices = graph.getAllVertex();
		/*
		for(Vertex<T> vertex : vertices){
			color.put(vertex.getId(), Color.WHITE);
		} */
		
		int time = 0;
		for(Vertex<T> vertex : vertices){
			//if(color.get(vertex.getId() == Color.WHITE){
			if(!visited.contains(vertex.getId())){
				time = DFSUtil(vertex, time);
			}
		}
	}

	private int DFSUtil(Vertex<T> v, int time){
		////color.put(v.getId(), Color.GRAY);
		visited.add(v.getId());
		time = time + 1;
		distance.put(v.getId(), time);

		for(Vertex<T> vertex : v.getAdjacentVertexes()){
			//if(color.get(vertex.getId() == Color.WHITE){
			if(!visited.contains(vertex.getId())){
				parent.put(vertex.getId(), v.getId());
				time = DFSUtil(vertex, time);
			}
		}
		//color.put(v.getId(), Color.BLACK);
		time = time + 1;
		finishedTime.put(v.getId(), time);
		return time;
	}
	
	public void printPath(T s, T v){
		if( v == s){
			System.out.print(s);
		}else{
			if(parent.get(v) == null){
				System.out.print("No path from " + s + " to " + v + " exists");
			}else{
				printPath(s, parent.get(v));
				System.out.print(" -> " + v);
			}
		}
	}
}
