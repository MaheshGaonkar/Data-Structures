package tree.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;
import tree.Traversal;
import tree.TreeOperation;

/**
 * 
 * @author Mahesh
 *
 * @param <T>
 */

public class BinaryTree extends TreeNode implements Traversal, TreeOperation{
	private TreeNode root;
	
	public BinaryTree() {
		super();
		root = null;
	}
	
	@Override
	public ArrayList<Integer> levelOrderTravesal() {
		if(root == null) return null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			result.add(temp.getValue());
			if(temp.getLeft() != null)
				queue.add(temp.getLeft());
			if(temp.getRight() != null)
				queue.add(temp.getRight());
		}
		return result;
	}
	
	@Override
	public ArrayList<Integer> inOrderTravesal() {
		if(root == null) return null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		inOrderTravesal(root, result);
		return result;
	}
	
	private void inOrderTravesal(TreeNode root, ArrayList<Integer> result) {
		if(root != null){
			inOrderTravesal(root.getLeft(), result);
			result.add(root.getValue());
			inOrderTravesal(root.getRight(), result);
		}
	}
	
	@Override
	public ArrayList<Integer> preOrderTravesal() {
		if(root == null) return null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		preOrderTravesal(root, result);
		return result;
	}
	
	private void preOrderTravesal(TreeNode root, ArrayList<Integer> result) {
		if(root != null){
			result.add(root.getValue());
			inOrderTravesal(root.getLeft(), result);
			inOrderTravesal(root.getRight(), result);
		}
	}
	
	@Override
	public ArrayList<Integer> postOrderTravesal() {
		if(root == null) return null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		postOrderTravesal(root, result);
		return result;
	}

	private void postOrderTravesal(TreeNode root, ArrayList<Integer> result) {
		if(root != null){
			inOrderTravesal(root.getLeft(), result);
			inOrderTravesal(root.getRight(), result);
			result.add(root.getValue());
		}
	}
	public boolean add(int[] values) {
		boolean isAddedSuccessful = false;
		for(int i = 0; i < values.length; i++){
			isAddedSuccessful = add(values[i]);
		}
		return isAddedSuccessful;
	}
	@Override
	public boolean add(int value) {
		boolean isAdded = false;
		try{
			TreeNode newNode = new TreeNode(value);
			if(root == null){
				root = newNode;
				isAdded =  true;
			}else{
				Queue<TreeNode> queue = new LinkedList<TreeNode>();
				queue.add(root);
				while(!queue.isEmpty()){
					TreeNode temp = queue.poll();
					if(temp.getLeft() == null){
						temp.setLeft(newNode);
						break;
					}else
						queue.add(temp.getLeft());
					if(temp.getRight() == null){
						temp.setRight(newNode);
						break;
					}else
						queue.add(temp.getRight());
				}
			}
		}catch(Exception ex){
			isAdded =  false;
		}
		return isAdded;
	}

	@Override
	public boolean contain(int value) {
		return false;
	}

	@Override
	public boolean remove(int value) {
		return false;
	}
	
	public TreeNode getRoot(){
		return root;
	}
}