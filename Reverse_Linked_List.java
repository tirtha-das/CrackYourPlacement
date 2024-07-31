class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode previous=null;
        ListNode current = head;
        ListNode next;
        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
           }
        return previous;
    }
}