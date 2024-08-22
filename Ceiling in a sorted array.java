class Solution {
    public int searchInsert(int[] nums, int target) {
        int low= 0 ,high = nums.length-1;

        int ans = -1;

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]<target){
                ans = Math.max(mid,ans);
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

       

        return (ans+1)<nums.length? nums[ans+1] : -1;
    }
}

