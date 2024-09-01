
class Node {
    int data;
    Node next;
    Node(int new_data) {
        data = new_data;
        next = null;
    }
}


class Solution {
  
    static void sortList(Node head) {
      
       int[] cnt = { 0, 0, 0 };
        Node ptr = head;

        while (ptr != null) {
            cnt[ptr.data] += 1;
            ptr = ptr.next;
        }

        int idx = 0;
        ptr = head;
        
       while (ptr != null) {
            if (cnt[idx] == 0)
                idx += 1;
            else {
                ptr.data = idx;
                cnt[idx] -= 1;
                ptr = ptr.next;
            }
        }
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
      
       Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(0);

        System.out.print("Linked List before Sorting:");
        printList(head);

        sortList(head);

        System.out.print("Linked List after Sorting:");
        printList(head);
    }
}
