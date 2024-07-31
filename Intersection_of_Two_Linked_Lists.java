public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenFirst=getLen(headA);
        int lenSecond=getLen(headB);

        int diff=Math.max(lenFirst, lenSecond)-Math.min(lenFirst,lenSecond);
        
        if(lenFirst>lenSecond){
            int difPoint=0;
            while(difPoint<diff){
                headA=headA.next;
                difPoint++;
            }
        }else{
            int difPoint=0;
            while(difPoint<diff){
                headB=headB.next;
                difPoint++;
            }
        }

        while(headA!=null && headB!=null && headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }

        return headA;
    }

    int getLen(ListNode head){
        int lenFirst=0;
        ListNode pointA=head;
        while(pointA!=null){
            lenFirst++;
            pointA=pointA.next;
        }
        return lenFirst;
    }
}