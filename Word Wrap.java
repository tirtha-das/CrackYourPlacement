import java.util.*;

class Solution
{
    List<List<Integer>> dp = new ArrayList<>();
   public int helper(int curr,int spaces,int[] nums,int k){
        if(curr==nums.length){
            return 0;
        }
       if (dp.get(curr).get(spaces) != -1) {
  return dp.get(curr).get(spaces);
} 
        int a=Integer.MAX_VALUE;
        int newspaces=spaces+1+nums[curr];
        if(newspaces<=k){
        a=helper(curr+1,newspaces,nums,k)  ;
        }
        
        int b=helper(curr+1,nums[curr],nums,k) +((k-spaces)*(k-spaces));
      
     dp.get(curr).set(spaces, Math.min(a, b));
return dp.get(curr).get(spaces);
        
    }

    public int solveWordWrap (int[] nums, int k)
    { int n=nums.length;
  for (int i = 0; i <= n; i++) {
  dp.add(new ArrayList<>(Collections.nCopies(k + 1, -1)));
}
      return  helper(1,nums[0],nums,k);
        
    }
}