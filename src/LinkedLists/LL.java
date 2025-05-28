package LinkedLists;

public class LL {
    protected Node head;
    protected Node tail;

    protected int size;

    public LL() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void display() {
        Node temp = head;
        while (temp != null && temp.next != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
        }
        Node node = new Node(val);
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public void deleteFirst() {
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
    }

    public void deleteLast() {
        if (size == 1) {
            deleteFirst();
            return;
        }
        Node temp = head;
        for (int i = 1; i < size - 1; i++) {
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;
    }

    public void delete(int index) {
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size) {
            deleteLast();
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node temp2 = temp.next;
        temp.next = temp2.next;


    }

    public void recursiveInsert(int index, int value){
        head=recursiveInsert(index,value,head);
    }

    public Node recursiveInsert(int index, int value, Node node) {
        if (index == 0) {
            Node temp = new Node(node, value);
            size++;
            return temp;
        }
        node.next = recursiveInsert(index-1, value, node.next);
        return node;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.val == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    protected class Node {
        public int val;
        public Node next;


        public Node(int value) {
            this.val = value;
        }

        public Node(Node next, int value) {
            this.next = next;
            this.val = value;
        }
    }


}