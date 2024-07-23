class Solution {
    static TreeNode helper(int preStart,int preEnd, int postStart, int postEnd,int[] preOrder,int[] postOrder){
        //System.out.printf("%d %d %d %d\n",preStart,preEnd,postStart,postEnd);
        if(preStart>preEnd || postStart>postEnd) return null;

        TreeNode cur = new TreeNode(preOrder[preStart],null,null);

        if(preStart==preEnd) return cur;

        int leftPreStart = preStart+1;
        int rightPostEnd = postEnd-1;
        int rightPreEnd = preEnd;
        int leftPostStart = postStart;

        int leftPostEnd =-1;

        for(int i=postStart;i<=postEnd;i++){
            if(postOrder[i]==preOrder[preStart+1]){
                leftPostEnd = i;
                break;
            }
        }

        int rightPostStart = leftPostEnd+1;
        int leftPreEnd = leftPreStart+(leftPostEnd-postStart);
        int rightPreStart = rightPreEnd-(rightPostEnd-rightPostStart);
       
        cur.left = helper(leftPreStart,leftPreEnd,leftPostStart,leftPostEnd,preOrder,postOrder);
        cur.right = helper(rightPreStart,rightPreEnd,rightPostStart,rightPostEnd,preOrder,postOrder);

     return cur;


    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(0,preorder.length-1,0,postorder.length-1,preorder,postorder);
    }
}