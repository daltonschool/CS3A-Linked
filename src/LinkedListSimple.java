public class LinkedListSimple {
    public static void main(String[] args) {
        LinkedListSimple ll = new LinkedListSimple();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);

        ll.remove(2);



    }

    Node first;
    int size;

    void add(int x) {
        Node n = new Node();
        n.value = x;

        if(size==0) first = n;
        else {
            Node last = get(size-1);
            last.link = n;
        }

        size++;
    }

    Node get(int i) {
        return get(i, first);
    }

    Node get(int i, Node n) {
        if(i==0) return n;
        else return get(i-1, n.link);
    }

    void remove(int i) {
        Node t = get(i-1);
        t.link = t.link.link;
        size--;
    }

    static class Node {
        int value;
        Node link;
    }
}
