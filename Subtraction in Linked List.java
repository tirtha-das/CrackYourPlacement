class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}



class Solution {
    
    public static Node reverse(Node head) {
        Node prev = null, cur = head, next = null;
        
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    
    public static int length(Node head) {
        Node cur = head;
        int l = 0;
        while (cur != null) {
            cur = cur.next;
            l++;
        }
        return l;
    }
    
    public static Node subtract(Node head1, Node head2) {
        Node h1 = head1;
        Node h2 = head2;
        int car = 0;
        
        Node ans = new Node(-1);
        Node a = ans;
        
        while (h1 != null && h2 != null) {
            int res = h1.data - h2.data + car;
            
            if (res < 0) {
                res += 10;
                car = -1;
            } else {
                car = 0;
            }
            
            Node temp = new Node(res);
            a.next = temp;
            a = temp;
            h1 = h1.next;
            h2 = h2.next;
        }
        
        while (h1 != null) {
            int res = h1.data + car;
            
            if (res < 0) {
                res += 10;
                car = -1;
            } else {
                car = 0;
            }
            
            Node temp = new Node(res);
            a.next = temp;
            a = temp;
            h1 = h1.next;
        }
        
        Node result = reverse(ans.next);
        
       while (result != null && result.data == 0) {
            result = result.next;
        }
        
        return result == null ? new Node(0) : result;
    }
    
    public Node subLinkedList(Node head1, Node head2) {
       while (head1 != null && head1.data == 0) head1 = head1.next;
        while (head2 != null && head2.data == 0) head2 = head2.next;
        
        if (head1 == null && head2 == null) {
            return new Node(0);
        }
        
        int l1 = length(head1);
        int l2 = length(head2);
        
        Node ml = null;
        Node sl = null;
        
        if (l1 > l2) {
            ml = head1;
            sl = head2;
        } else if (l1 < l2) {
            ml = head2;
            sl = head1;
        } else {
            Node h1 = head1;
            Node h2 = head2;
            int c = 0;
            while (h1 != null && h2 != null) {
                if (h1.data > h2.data) {
                    ml = head1;
                    sl = head2;
                    break;
                } else if (h1.data < h2.data) {
                    ml = head2;
                    sl = head1;
                    break;
                }
                c++;
                h1 = h1.next;
                h2 = h2.next;
            }
            if (c == l1) {
                return new Node(0);
            }
        }
        
        ml = reverse(ml);
        sl = reverse(sl);
        
        return subtract(ml, sl);
    }
}