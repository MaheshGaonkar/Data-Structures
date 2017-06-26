package tree;

import java.util.ArrayList;

public interface Traversal {
	public ArrayList<Integer> levelOrderTravesal();
	public ArrayList<Integer> inOrderTravesal();
	public ArrayList<Integer> preOrderTravesal();
	public ArrayList<Integer> postOrderTravesal();
}
