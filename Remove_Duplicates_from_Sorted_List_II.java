class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        TreeMap<Integer,Integer> s = new TreeMap<>();
        ListNode temp = head;
        while(temp!=null){
            if(s.containsKey(temp.val)){
                int t = s.get(temp.val)+1;
                s.put(temp.val,t);
            }
            else{
                s.put(temp.val,1);
            }
            temp = temp.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for(Map.Entry<Integer,Integer> m:s.entrySet()){
            if(m.getValue()==1){
                cur.next=new ListNode(m.getKey());
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}