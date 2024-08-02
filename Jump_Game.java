class Solution {
    public boolean canJump(int[] nums) {
        int max_idx =0;
       
        for(int i=0;i<nums.length;i++){
            if(i>max_idx) return false;
            max_idx = Math.max(max_idx, i+nums[i]);
        }
        return true;   
    }
}