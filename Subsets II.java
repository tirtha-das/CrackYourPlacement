import java.util.*;

class Solution {
    void helper(int i,int[]nums, List<Integer> al,List<List<Integer>>ans){
        if(i>= nums.length){
            ans.add(new ArrayList<Integer>(al));
            return;
        }
        al.add(nums[i]);
        helper(i+1,nums,al,ans);
        al.remove(al.size()-1);
        while(i+1<nums.length && nums[i] == nums[i+1]) i++;
        helper(i+1,nums,al,ans);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        Arrays.sort(nums);
        helper(0,nums,al,ans);
        return ans;
    }
}