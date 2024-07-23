
public class ListNode {
      int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {

    static ListNode merge(ListNode left,ListNode right){
        ListNode newHead = null,temp = null;

        while(left!=null && right!=null){
            if(left.val<=right.val){
               if(newHead==null){
                    newHead=left;
                    temp = left;
                }else{
                    temp.next = left;
                    temp = temp.next;
                }
                left = left.next;
                temp.next = null;
                }
            else{
                if(newHead==null){
                    newHead=right;
                    temp = right;
                }else{
                    temp.next = right;
                    temp = temp.next;
                }
                right = right.next;
                temp.next = null;
            }
        }

        if(left!=null) temp.next = left;
        else temp.next = right;

        return newHead;
    }
    
    static ListNode mergeSort(ListNode head){
         if(head==null || head.next==null){
            return head;
         }

         ListNode slow = head;
         ListNode fast = head;

         if(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
         }

         ListNode left = head;
         ListNode right = slow.next;
         slow.next = null;

        left =  mergeSort(left);
       right =  mergeSort(right);
     
     return merge(left,right);

    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}