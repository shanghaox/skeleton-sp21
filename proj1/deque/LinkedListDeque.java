package deque;

public class LinkedListDeque<T> {
    private class Node {
        public T item;
        public Node next;
        public Node prev;
        Node() {
            item = null;
            next = null;
            prev = null;
        }
        Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node head;
    private int size;

    LinkedListDeque() {
        head = new Node();
        size = 0;
    }
    public void addFirst(T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node newNode = new Node(item, head, head.next);
        head.next.prev = newNode;
        head.next = newNode;
        size++;
    }
    public void addLast(T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node newNode = new Node(item, head.prev, head);
        head.prev.next = newNode;
        head.prev = newNode;
        size++;
    }
    public T removeFirst() {
        T temp = head.next.item;
        head.next.next.prev = head;
        head.next=head.next.next;
        size--;
        return temp;
    }
    public T removeLast() {
        T temp = head.prev.item;
        head.prev.prev.next=head;
        head.prev=head.prev.prev;
        return temp;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void printDeque() {
        Node ptr=head;
        for (int i = 1; i <= size; i++) {
            ptr=ptr.next;
            System.out.print(ptr.item + " ");
        }
        System.out.println();
    }

    public T get(int index) {
        Node ptr=head;
        for (int i = 1; i <= index; i++) {
            ptr=ptr.next;
        }
        return ptr.item;
    }
    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelp(head,index);
    }
    public T getRecursiveHelp(Node pos,int index) {
        if (index == 0) {
            return pos.item;
        }
        else {
            return getRecursiveHelp(pos.next, index - 1);
        }

    }

}

