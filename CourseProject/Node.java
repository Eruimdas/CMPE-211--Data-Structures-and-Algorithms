
public class Node<T extends Comparable<T>> {

	/*
	 * 	this class' main purpose is to store the data
	 *	within nodes, which will be used in linked list.   
	 */
	
	private T data; //data that one node holds
	private Node<T> nextNode; // the information of on next node to create a linked list 

	public Node(T data) { 
		this.data = data; 
	}

	public T getData() {
		return data; // read the data 
	}

	public Node<T> getNextNode() {
		return nextNode; // read the next node information
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode; // modify the next node information
	}
}
