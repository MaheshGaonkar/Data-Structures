package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @author Mahesh Gaonkar
 * @Date 12/12/2016
 */

public class Graph<T> {
	private List<Edge<T>> allEdges;
	private Map<T, Vertex<T>> allVertices;
	boolean isDirected;
	
	Graph(){
		this(false);
	}
	
	Graph(boolean isDirected){
		allEdges = new ArrayList<Edge<T>>();
		allVertices = new HashMap<T, Vertex<T>>();
		this.isDirected = isDirected;
	}
	
	public void addEdge(T id1, T id2){
		addEdge(id1,id2,0);
	}
	
	public void addEdge(T id1, T id2, int weight){
		Vertex<T> v1 = defaultOrFirstVertex(id1);
		allVertices.put(id1, v1);
		
		Vertex<T> v2 = defaultOrFirstVertex(id2);
		allVertices.put(id2, v2);
		
		Edge<T> edge = new Edge<T>(v1,v2,isDirected,weight);
		allEdges.add(edge);
		v1.addAdjacentVertex(edge, v2);
		if(!isDirected){
			v2.addAdjacentVertex(edge, v1);
		}
	}
	
	private Vertex<T> defaultOrFirstVertex(T id){
		if(allVertices.containsKey(id)){
			return allVertices.get(id);
		}	
		return new Vertex<T>(id);
	}
	
	public boolean isDirected(){
		return this.isDirected;
	}
	
	public Vertex<T> getVertex(T id){
		return allVertices.get(id);
	}
	
	public List<Edge<T>> getAllEdges(){
		return allEdges;
	}
	
	public Collection<Vertex<T>> getAllVertex(){
		return allVertices.values();
	}
}


class Vertex<T>{
	T id;
	private T data;
	private List<Edge<T>> edges = new ArrayList<>();
	private List<Vertex<T>> adjancentVertex = new ArrayList<>();
	
	Vertex(T id){
		this.id = id;
	}
	
	public T getId(){
		return this.id;
	}
	
	public void setData(T data){
		this.data = data;
	}
	
	public T getData(){
		return this.data;
	}
	
	public void addAdjacentVertex(Edge<T> e, Vertex<T> v){
		edges.add(e);
		adjancentVertex.add(v);
	}
	
	public List<Edge<T>> getEdges(){
		return edges;
	}
	
	public List<Vertex<T>> getAdjacentVertexes(){
		return adjancentVertex;
	}
	public int getDegree(){
		return edges.size();
	}
}

class Edge<T>{
	private boolean isDirected = false;
	private int weigth;
	private Vertex<T> vertex1;
	private Vertex<T> vertex2;
	
	Edge(Vertex<T> v1, Vertex<T> v2){
		this(v1,v2,false,0);
	}
	
	Edge(Vertex<T> v1, Vertex<T> v2, boolean isDirected){
		this(v1,v2,isDirected,0);
	}
	
	Edge(Vertex<T> v1, Vertex<T> v2, int weight){
		this(v1,v2,false,weight);
	}
	
	Edge(Vertex<T> v1, Vertex<T> v2, boolean isDirected, int weight){
		vertex1 = v1;
		vertex2 = v2;
		this.isDirected = isDirected;
		this.weigth = weight;
	}
	
	public Vertex<T> getFirstVertex(){
		return this.vertex1;
	}
	
	public Vertex<T> getSecondVertex(){
		return this.vertex2;
	}
	
	public int getWeight(){
		return this.weigth;
	}
	
	public boolean isDirected(){
		return this.isDirected;
	}
}
