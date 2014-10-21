
public class LinkedList {
	/*
	 * Tester Code:
	 */
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.add('b');
		l.add('c');
		l.add('d');
		l.remove(1);
		l.print();
	}

	/*
	 * Linked List Code: 
	 */
	Node first;
	int size;

	public LinkedList() {
		first = new Node('0');
		size=1;
	}

	private Node get(int index, Node n) {
		if(index==0) return n;
		if(n.link==null) return null;
		return get(index-1, n.link);
	}

	public char get(int index) {
		return get(index+1,first).value;
	}

	public void set(char c, int index) {
		get(index, first).value=c;
	}

	public void add(char c) {
		get(size-1, first).link = new Node(c);
		size++;
	}

	void add(char c, int index) {
		Node p = get(index,first);
		Node t = p.link;
		p.link = new Node(c);
		p.link.link = t;
	}

	char remove(int index) {
		Node p = get(index, first);
		Node t = p.link;
		p.link = p.link.link;
		return t.value;
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
	public Node(char c) {
		value = c;
	}

	char value;
	Node link;
}