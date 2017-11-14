public class LinkedList {
	/*
	 * Tester Code:
	 */
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		//sure, you can put your own tests here.
	}


	/*
	 * Linked List Code: 
	 */
	Node first;
	int size;

	public LinkedList() {
		first = null;
		size=0;
	}

	/*
	 * 2. modify add and remove to be doubly linked
	 */
	public void add(char c, int index) {
		Node n = new Node();
		n.value = c;
		
		if(index==0) {
			n.next = first;
			first = n;
		}
		else {
		  Node p = get(index-1, first);
			n.next = p.next;
			p.next = n;
		}

		size++;
	}

	public char remove(int index) {
		if(index==0) {
			Node t = first;
			first = t.next;
			return t.value;
		}
		Node p = get(index-1, first);
		Node t = p.next;
		p.next = t.next;
		return t.value;
	}

	public void set(int index, char c) {
		get(index, first).value = c;
	}

	public char get(int index) {
		return get(index, first).value;
	}

	protected Node get(int index, Node n) {
		//base case:
		if(n==null) {
			System.err.println("out of bounds, fool!");
			return null;
		}

		if(index==0) {
			return n;
		}

		return get(index-1, n.next);
	}

	/* 
	 * 1. make a readable string of the list.
	 * ex. "a > b > c > d"
	 * hint: do it recursively!
	 */
	public String toString() {
		return "";
	}

	
	/*
	 * 3. Write the swap function
	 * (you may swap the values, or as a bonus (+2) write swap the links)
	 */
	public void swap(int i, int j) {
		
	}
	
	/*
	 * 4. sort the list
	 */
	public void bubblesort() {

	}

}

class Node {
	char value;
	Node next;
	Node prev; //you'll need this for doubly linked
}
