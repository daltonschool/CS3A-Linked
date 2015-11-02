public class LinkedList {
	/*
	 * Tester Code:
	 */
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.add('a',0);
		l.add('b',1);
		l.add('c',2);
		System.out.println(l.get(0));
		System.out.println(l.get(2));
		System.out.println(l.remove(0));
		System.out.println(l.get(0));
		l.set(1, 'X');
		System.out.println(l.get(1));
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

	public void add(char c, int index) {
		Node n = new Node();
		n.value = c;
		
		if(index==0) {
			n.link = first;
			first = n;
		}
		else {
		  Node p = get(index-1, first);
			n.link = p.link;
			p.link = n;
		}

		size++;
	}

	public char remove(int index) {
		if(index==0) {
			Node t = first;
			first = t.link;
			return t.value;
		}
		Node p = get(index-1, first);
		Node t = p.link;
		p.link = t.link;
		return t.value;
	}

	public void set(int index, char c) {
		get(index, first).value = c;
	}

	public char get(int index) {
		return get(index, first).value;
	}

	public Node get(int index, Node n) {
		//base case:
		if(n==null) {
			System.err.println("out of bounds, fool!");
			return null;
		}

		if(index==0) {
			return n;
		}

		return get(index-1, n.link);
	}

	/* 
	 * 1. print the list.
	 * ex. "a > b > c > d"
	 */
	void print() {

	}

	/*
	 * 3. sort the list
	 */
	void bubblesort() {

	}

}

/*
 * 2. modify the node to be doubly linked
 * (you will need to do some work above, too)
 */
class Node {
	char value;
	Node link;
}
