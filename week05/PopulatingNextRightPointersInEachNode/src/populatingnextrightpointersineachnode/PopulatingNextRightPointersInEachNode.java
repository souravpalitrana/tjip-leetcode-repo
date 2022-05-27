/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populatingnextrightpointersineachnode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author souravpalit
 */
public class PopulatingNextRightPointersInEachNode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Node root = new Node(1);
        insert(root, new int[]{2, 3, 4, 5, 6, 7}, 0);
        //root.left.right.right = new Node(10);
        //root.right.left.left = new Node(11);
        //root.right.right.left = new Node(12);
        //root.right.right.right = new Node(13);
        //root.right.left.left.left = new Node(14);
        connect(root);
    }

    public static Node connect(Node root) {
        connectRight(root, null, false);
        return root;
    }

    private static void connectRight(Node node, Node parent, boolean isLeftNode) {
        if (node == null) {
            return;
        }

        Node left = node.left;
        Node right = node.right;

        connectRight(left, node, true);

        if (parent == null) {
            node.right = null;
        } else if (isLeftNode) {
            node.right = parent.right;
        } else {
            if (parent.right != null) {
                node.right = parent.right.left;
            } else {
                node.right = null;
            }
        }

        connectRight(right, node, false);
    }

    public static void insert(Node root, int[] values, int i) {
        if (i >= values.length) {
            return;
        }
        Deque<Node> queue = new ArrayDeque<Node>();
        queue.addLast(root);
        while (queue.size() > 0) {
            Node current = queue.pollFirst();
            if (current.left == null) {
                current.left = new Node(values[i]);
                break;
            }
            queue.addLast(current.left);
            if (current.right == null) {
                current.right = new Node(values[i]);
                break;
            }
            queue.addLast(current.right);
        }
        insert(root, values, i + 1);
    }

}
