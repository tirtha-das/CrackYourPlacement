class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode curr =head;
        int tl= 0;
        while(curr!=null){
            curr = curr.next;
            tl++;
        }
        int x = tl- n+1;
        System.out.println(x);
        curr=head;
        while(x>1){
          prev = curr;
          curr= curr.next;
          x--;
        }
        if(curr== head){
            return curr.next;
        }else{
            prev.next= curr.next;
            return head;
        }
      
        
    }
}