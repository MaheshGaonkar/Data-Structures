/**
 * 
 */
package graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mahesh Gaonkar
 *	Date 12/15/2016
 */
public class DisjointSet<T> {
	
	private Map<T, Node> map = new HashMap<>();
	
	class Node{
		T data;
		Node parent;
		int rank;
		
		public Node(T data){
			this.data = data;
			parent = null;
			rank = 0;
		}
	}
	
	public void makeSet(T data){
		Node node = new Node(data);
		node.parent = node;
		map.put(data, node);
	}
	
	public boolean union(T data1, T data2){
		Node fistNode = map.get(data1);
		Node secondNode = map.get(data2);
		
		Node fistNodeParent = findSet(fistNode);
		Node secondNodeParent = findSet(secondNode);
		
		if(fistNodeParent.data == secondNodeParent.data){
			return false;
		}
		
		if(fistNodeParent.rank >= secondNodeParent.rank){
			fistNodeParent.rank = (fistNodeParent.rank == secondNodeParent.rank) 
				? (fistNodeParent.rank + 1) 
				: fistNodeParent.rank;
			secondNodeParent.parent = fistNodeParent;
		}else{
			fistNodeParent.parent = secondNodeParent;
		}
		return true;
	}
	
	public T findSet(T data){
		return findSet(map.get(data)).data;
	}
	
	private Node findSet(Node node){
		Node parent = node.parent;
		if(parent == node){
			return parent;
		}
		
		node.parent = findSet(node.parent);
		return node.parent;
	}
}
