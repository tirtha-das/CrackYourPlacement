import java.util.*;
class Solution {

    private class SegmentTree{
        int count;
        SegmentTree left;
        SegmentTree right;
        int start;
        int end;

         public SegmentTree(int start,int end){
            this.start = start;
            this.end = end;
        }

    }
    public SegmentTree buildTree(int start,int end){
        if(start == end){
            return new SegmentTree(start,end);
        }

        SegmentTree cur = new SegmentTree(start,end);
         int mid = start + (end - start) / 2;
        cur.left = buildTree(start,mid);
        cur.right = buildTree(mid+1,end);


        return cur;
    }




    public int query(SegmentTree node,int start,int end){
        if(node == null || node.start > end || node.end < start){
            return 0;
        }
       

        if(node.start >= start && node.end <= end){
            return node.count;
        }
        else{
            return query(node.left,start,end) + query(node.right,start,end);
        }


    }

    public void update(SegmentTree node,int val){
        if(node == null || node.start > val || node.end < val){
            return ;
        }

        node.count++;
        update(node.left,val);
        update(node.right,val);
    }
    public List<Integer> countSmaller(int[] nums) {

        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] -= min;
        }

        SegmentTree root = buildTree(0, max - min);

        for (int i = nums.length - 1; i >= 0; i--) {
            result.add(0, query(root, 0, nums[i] - 1));
            update(root, nums[i]);
        }

        return result;

    }
}