class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b)->{
            if(a.val>b.val) return 1;
            else if(a.val==b.val) return 0;
            else return -1;

        } );

        for(ListNode head:lists){
            if(head!=null){
             pq.add(head);
            // head = head.next;
            }
        }
     ListNode head=null,temp=null;
        while(pq.size()>0){
            ListNode cur = pq.poll();
            if(head==null){
                head = cur;
                temp = cur;
            }
            else{
                temp.next = cur;
                temp = temp.next;
            }
          
          
            cur = cur.next;
             temp.next = null;

            if(cur!=null) pq.add(cur);

           
        }

        return head;

    //  while(pq.size()>0){
    //     System.out.println(pq.poll().val);
    //  }

    //  return null;
    }
}