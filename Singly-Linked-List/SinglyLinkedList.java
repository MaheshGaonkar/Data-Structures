package linkedlist;

/**
 * @author Mahesh Gaonkar
 *
 */

class Node{
	private int value;
	private Node next;
	
	public Node(){
		this(0);
	}
	
	public Node(int value){
		this.value = value;
		next = null;
	}
	
	public static void swap(Node A, Node B){
		
		if((A != null && B != null) || (A.value != B.value)){
			int value = A.value;
			A.value = B.value;
			B.value = value;
		}	
	}
	
	public static void swap(Node previousNode, Node currentNode, Node nextNode){
		previousNode.next = nextNode;
		currentNode.next = nextNode.next;
		nextNode.next = currentNode;
	}
	
	public int getValue(){
		return value;
	}
	
	public Node next(){
		return next;
	}
	
	public void next(Node nextNode){
		next = nextNode;
	}
}

public class SinglyLinkedList {
	Node head;
	
	public SinglyLinkedList(){
		head = null;
	}
	
	public void printList(){
		Node temp = head;
		System.out.print("\tHead->");
		while(temp != null){
			System.out.print(temp.getValue());
			System.out.print("->");
			temp = temp.next();
				
		}
		System.out.println("NULL");
	}
	
	public void add(int value){
		Node newNode = new Node(value);
		newNode.next(head);
		head = newNode;
	}
	
	public void add(int[] values){
		for(int i = 0; i < values.length; i++){
			add(values[i]);
		}
	}
	
	public boolean isEmppty(){
		return (head == null) ? true : false;
	}
	
	public void swapNodes(){
		head = swapNode(head);
	}
	
	private Node swapNode(Node head){
		if(isEmppty()){
			return head;
		}
		
		Node tempNewNode = new Node(-1);
		tempNewNode.next(head);
		
		Node previousNode = tempNewNode;
		
		while(head != null && head.next() != null){
			Node.swap(previousNode, head, head.next());
			previousNode = head;
			head = head.next();
		}
		return tempNewNode.next();
	}
	
	public Node getMiddleNode(){
		if(isEmppty()){
			return head;
		}
		
		Node fast = head; // fast node will travel two nodes at a time
		
		Node slow = head; // slow node will travel one node at a time
		
		while(fast.next() != null && fast.next().next() != null){
			fast = fast.next().next();
			slow = slow.next();
		}
		
		return slow;
	}
	
	
	public void reverse(){
		if(!isEmppty())
			head = reverse(head);
	}
	
	private Node reverse(Node head){
		
		Node previousNode = null;
		Node nextNode = null;
		
		while(head != null){
			nextNode = head.next();
			head.next(previousNode);
			previousNode = head;
			head = nextNode;				
		}
		return previousNode;
	}
	
	public void rearrangeList(){
		
		if(!isEmppty()){
			Node middleNode = getMiddleNode();
			
			Node secondHalf = middleNode.next();
			middleNode.next(null);
			
			secondHalf = reverse(secondHalf);
			
			head = alternativeMerge(head,secondHalf);
		}
	}
	
	private static Node alternativeMerge(Node firstHead, Node secondHead){
		
		Node newHead = new Node(-1);
		Node temp = newHead;
		 
		while(firstHead != null || secondHead != null){
			if(firstHead != null){
				temp.next(firstHead);
				firstHead = firstHead.next();
				temp = temp.next();
			}
			
			if(secondHead != null){
				temp.next(secondHead);
				secondHead = secondHead.next();
				temp = temp.next();
			}
		}
		return newHead.next();
	} 	
}
