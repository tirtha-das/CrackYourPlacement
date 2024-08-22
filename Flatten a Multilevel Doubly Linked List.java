import java.util.*;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};


class Solution {
    public Node flatten(Node head) {
        Stack<Node> st = new Stack<>();

        Node temp = head, prev = head;
        while(temp != null) {
            if(temp.child != null){
                if(temp.next != null){
                    st.push(temp.next);
                }
                temp.next = temp.child;
                temp.child.prev = temp;
                temp.child = null;
               
            }

            prev = temp;
            temp = temp.next;

            if(temp == null  && !st.isEmpty()){
                temp = st.pop();
                prev.next = temp;
                temp.prev = prev;
            }
        }

        return head;
    }
}