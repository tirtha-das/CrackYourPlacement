class ListNode {
     int val;
      ListNode next;
     ListNode(int val) { this.val = val; }
}
class Solution {
    void reverse (ListNode start,ListNode end){
        ListNode prv= null,current=start;
        while(prv!=end){
            ListNode nextNode =current.next;
            current.next=prv;
            prv=current;
            current=nextNode;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null||k==1)return head;
        ListNode dummy = new ListNode (0);
        dummy.next=head;
        ListNode beforeNode = dummy , end = head;
        int i=0;
        while(end!=null){
            ++i;
            if(i%k==0){
                ListNode start= beforeNode.next,temp=end.next;
                reverse(start,end);
                beforeNode.next=end;
                start.next=temp;
                end = temp;
                beforeNode=start;
            }else{
                end=end.next;
            }
        }
        return dummy.next;
      
    }
}

