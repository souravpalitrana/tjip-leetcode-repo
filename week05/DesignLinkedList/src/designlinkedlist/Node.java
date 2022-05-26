package designlinkedlist;

public class Node {
    
    public int value;
    public Node next;

    public Node(int value, Node node) {
        this.next = node;
        this.value = value;
    }
}
