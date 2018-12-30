public class LinkedList<T extends Comparable<T>> {

	private Node<T> head; // the main element which constitutes a LinkedList
	private int sizeCounter; // the integer that helps us to count the size of list

	public void insert(T data) { // inserting an item to list
		++this.sizeCounter; // increasing the size information

		if (head == null) { // if we don't have a node
			head = new Node<>(data); // we create a new node for insertion
		} else {
			insertDataBeginning(data);
		}
	}

	private void insertDataBeginning(T data) {
		// insertion of a data to a non-node list
		Node<T> newNode = new Node<>(data); // creating a new Node
		newNode.setNextNode(head);
		// writing the information of which node will be come after the node
		// this allows us to make a chain system which is a requisite for a Linked List
		this.head = newNode;
	}

	public T get(int index) {
		// returns the data in the head, and sets the head to the next node
		// in order to move on within the linked list.
		checkElementIndex(index);
		T x = head.getData();
		if (head.getNextNode() != null)
			head = head.getNextNode();
		return x;

	}

	private void checkElementIndex(int index) {
		// this method tries to find an element and returns the index of it
		if (!isElementIndex(index))
			System.out.println("ERROR INDEX NOT FOUND!");

	}

	private boolean isElementIndex(int index) {
		// checks if the index in the LinkedList's boundary
		return index >= 0 && index < sizeCounter;
	}

	public int size() {
		// returns the size of the Linked List
		return this.sizeCounter;
	}

	// this code is implemented using java's LinkedList class, with the worksheet's
	// linked list class
	// used in our courses.
}
