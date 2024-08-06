class Node {
    int data;
    Node next;
 
   Node(int data) {
       this.data = data;
   }
 }
 
 class Solution
 {
     
     Node reverse(Node head){
         Node prev = null;
         Node temp = head;
         Node next = head.next;
         
         while(temp!=null){
             temp.next = prev;
             prev = temp;
             temp = next;
             if(next!=null) next = next.next;
         }
         
         return prev;
     }
     
     void print(Node head){
         Node temp = head;
         
         while(temp!=null){
             System.out.printf("%d ",temp.data);
             
             temp = temp.next;
         }
         System.out.println();
     }
     
     Node compute(Node head)
     {
         head = reverse(head);
         
         //print(head);
         // your code here
         Node dummy = new Node(0);
         dummy.next = head;
         
         Node temp = dummy.next;
         //Node prev = dummy;
         while(temp.next!=null){
             if(temp.data>temp.next.data){
                 temp.next = temp.next.next;
             }
             else{
                 temp = temp.next;
             }
         }
         
         return reverse(dummy.next);
         
     }
 }