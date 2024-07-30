class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode p1 = head;
        int n = 0;

        while(p1 != null){
            n++;
            p1 = p1.next;
        }

        int sum = 0;
        p1 = head;

        while(p1 != null){
            sum = sum + p1.val * (int)Math.pow(2, --n);
            p1 = p1.next;
        }

        return sum;

    }
}