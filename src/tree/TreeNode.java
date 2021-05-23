package tree;

/**
 * 
 * @author Mahesh Gaonkar
 * @Date 26-06-2017
 */
public class TreeNode {
	private int value;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(){
		this(0);
	}
	
	public TreeNode(int value){
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

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}
	
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public TreeNode getRight() {
		return right;
	}
	
	public boolean isLeaf(){
		return left == null && right == null;
	}
}
