import java.util.*;


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node newHead = new Node(0);
        Node newCurr = newHead;
        Node curr = head;
        Map<Node, Node> umap = new HashMap<>();

        while (curr != null) {
            Node temp = new Node(curr.val);
            umap.put(curr, temp);

            newCurr.next = temp;
            newCurr = newCurr.next;
            curr = curr.next;
        }

        curr = head;
        newCurr = newHead.next;

        while (curr != null) {
            Node random = curr.random;
            Node newNode = umap.get(random);
            newCurr.random = newNode;

            newCurr = newCurr.next;
            curr = curr.next;
        }

        return newHead.next;
    }
}