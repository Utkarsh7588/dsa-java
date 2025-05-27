package LinkedLists;

public class Main {
    public static void main(String[] args) {
        LL list=new LL();
        list.insertFirst(2);
        list.insertFirst(10);
        list.insertFirst(5);
        list.insert(100,2);
        list.display();
        list.delete(2);
        list.display();
    }
}
