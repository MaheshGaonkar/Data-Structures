package tree;

/**
 * 
 * @author Mahesh Gaonkar
 * @Date 26-06-2017
 */
public class Node {
	private int value;
	private Node left;
	private Node right;
	
	public Node(){
		this(0);
	}
	
	public Node(int value){
		this.setValue(value);
		setLeft(null);
		setRight(null);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
	
	public Node getRight() {
		return right;
	}
	
	public boolean isLeaf(){
		return left == null && right == null;
	}
}
