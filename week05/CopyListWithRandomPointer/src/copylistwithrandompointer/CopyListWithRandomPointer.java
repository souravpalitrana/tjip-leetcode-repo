/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copylistwithrandompointer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class CopyListWithRandomPointer {
 
    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);
        
        node7.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;
        
        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;
        
        copyRandomList(node7);
        System.out.println();
    }
    
    /**
     * First create new node based on original list and connect. During doing that
     * put new node which is equivalent of our original node into a map. This 
     * will help us to connect random pointer later. So after first pass we 
     * have copy of original list. Now we need to connect the random. To do that
     * loop through the original list and find the original equivalent random from
     * the map and connect it.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        Node current = head;
        Node copied = dummy;
        
        Map<Node, Node> map = new HashMap<>();
        
        while (current != null) {
            Node newCopiedNode = new Node(current.val);
            map.put(current, newCopiedNode);
            copied.next = newCopiedNode;
            copied = copied.next;
            current = current.next;
        }
        
        copied = dummy.next;
        current = head;
        while (current != null) {
            Node currentRandom = current.random;
            
            if (map.containsKey(currentRandom)) {
                Node copiedRandomNode = map.get(currentRandom);
                copied.random = copiedRandomNode;
            }
            
            current = current.next;
            copied = copied.next;
        }
        
        
        return dummy.next;
    }
    
}
