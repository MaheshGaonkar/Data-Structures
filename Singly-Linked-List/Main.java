package linkedlist;

public class Main {

	public static void main(String[] args) {
		int values[] = {1,2,3,4,5,6,7,8,9};
		
		SinglyLinkedList head = new SinglyLinkedList();
		head.add(values);
		
		System.out.println("Original");
		head.printList();
		
		System.out.println("After Swap");
		head.swapNodes();
		head.printList();
			
		System.out.println("Reverse");
		head.reverse();
		head.printList();
		
		System.out.print("Middle Node : ");
		Node middleNode = head.getMiddleNode();
		System.out.println(middleNode.getValue());
		
		System.out.println("Rearrange List");
		head.rearrangeList();
		head.printList();
	}
}
