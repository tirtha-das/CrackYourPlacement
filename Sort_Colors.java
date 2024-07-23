class Solution {
    static void swap(int idx1,int idx2,int[]nums){
        if(idx1 == idx2) return;
        
        nums[idx1]+=nums[idx2];
        nums[idx2] = nums[idx1]-nums[idx2];
         nums[idx1] = nums[idx1]-nums[idx2];

    }
    public void sortColors(int[] nums) {
        int low = 0,mid = 0,high = nums.length-1;

        while(mid<=high){
            if(nums[mid]==0){
                swap(low,mid,nums);
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                swap(mid,high,nums);
                high--;
            }
        }
    }
}