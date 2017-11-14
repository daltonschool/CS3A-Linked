
public class LinkedListTester {
	public static void main(String[] args) {
		int step1 = step1();
		int step2 = step2();
		int step3 = step3();
		int step4 = step4();
		
		System.out.println("Linked List Self Grader:");
		System.out.println("Part 1: " + step1 + "/5");
		System.out.println("Part 2: " + step2 + "/5");
		System.out.println("Part 3: " + step3 + "/3 (+2)");
		System.out.println("Part 4: " + step4 + "/7");
		System.out.println("Score: " + (70+step1+step2+step3+step4));
	}


	static int step1() { //toString 5 points
		//test1:
		LinkedList test1 = new LinkedList();
		test1.add('c', 0);
		test1.add('b', 0);
		test1.add('a', 0);
		if(!test1.toString().trim().equalsIgnoreCase("A > B > C")) return 0;

		//test2:
		LinkedList test2 = new LinkedList();
		test2.add('a', 0);
		test2.add('b', 1);
		test2.add('c', 2);
		test2.remove(1);
		test2.remove(1);
		test2.add('z', 1);
		if(!test1.toString().trim().equalsIgnoreCase("A > Z")) return 0;

		return 5;
	}

	static int step2() { //doubly linked 5 points

		//test add:
		LinkedList l = new LinkedList();
		l.add('e', 0);
		l.add('d', 0);
		l.add('c', 0);
		l.add('b', 0);
		l.add('a', 0);
		if(!nodeIntegrity(l.get(0, l.first))) return 0;
		if(!nodeIntegrity(l.get(3, l.first))) return 0;
		if(!nodeIntegrity(l.get(5,  l.first))) return 0;
		l.add('z', 2);
		if(!nodeIntegrity(l.get(1, l.first))) return 0;
		if(!nodeIntegrity(l.get(2, l.first))) return 0;
		if(!nodeIntegrity(l.get(3,  l.first))) return 0;
		l.add('q', 6);
		if(!nodeIntegrity(l.get(5,  l.first))) return 0;
		if(!nodeIntegrity(l.get(6,  l.first))) return 0;

		//test remove:
		l.remove(2);
		if(!nodeIntegrity(l.get(1, l.first))) return 0;
		if(!nodeIntegrity(l.get(2, l.first))) return 0;
		if(!nodeIntegrity(l.get(3, l.first))) return 0;
		l.remove(3);
		l.remove(0);
		if(!nodeIntegrity(l.get(0, l.first))) return 0;
		if(!nodeIntegrity(l.get(1, l.first))) return 0;
		l.remove(0);
		l.remove(0);
		if(l.size!=0) return 0;

		return 5;

	}

	static int step3() { //swap 3 points (+2 bonus)
		LinkedList l = new LinkedList();
		l.add('e', 0);
		l.add('d', 0);
		l.add('c', 0);
		l.add('b', 0);
		l.add('a', 0);

		l.swap(1, 2);
		if(l.get(1)!='c') return 0;
		if(l.get(2)!='b') return 0;

		l.swap(0, 1);
		if(l.get(0)!='c') return 0;
		if(l.get(1)!='a') return 0;

		l.swap(0, 4);
		if(l.get(0)!='e') return 0;
		if(l.get(4)!='c') return 0;

		if(l.first.value!='e') return 0;

		//test for link swap:
		Node n = l.first;
		Node n2 = l.first.next;
		l.swap(0, 1);
		if(l.get(0, l.first) == n2 && l.get(1, l.first)==n) return 5;

		return 3;
	}

	static int step4() { //bubblesort 7 points
		//test add:
		LinkedList test1 = new LinkedList();
		test1.add('c', 0);
		test1.add('b', 0);
		test1.add('a', 0);
		test1.add('d', 0);
		test1.add('e', 0);
		test1.bubblesort();
		if(!nodeIntegrity(test1.get(0, test1.first))) return 0;
		if(!nodeIntegrity(test1.get(3, test1.first))) return 0;
		if(!nodeIntegrity(test1.get(5,  test1.first))) return 0;
		if(!test1.toString().trim().equalsIgnoreCase("A > B > C > D > E")) return 0;

		LinkedList test2 = new LinkedList();
		test2.add('a', 0);
		test2.add('a', 0);
		test2.add('a', 0);
		test2.add('z', 0);
		test2.add('z', 0);
		test1.bubblesort();
		if(!nodeIntegrity(test1.get(0, test1.first))) return 0;
		if(!nodeIntegrity(test1.get(3, test1.first))) return 0;
		if(!nodeIntegrity(test1.get(5,  test1.first))) return 0;
		if(!test1.toString().trim().equalsIgnoreCase("A > A > A > Z > Z")) return 0;

		return 7;
	}


	static boolean nodeIntegrity(Node n) {
		if(n.next!=null && n.next.prev.value!=n.value) return false;
		if(n.prev!=null && n.prev.next.value!=n.value) return false;
		return true;
	}

}
