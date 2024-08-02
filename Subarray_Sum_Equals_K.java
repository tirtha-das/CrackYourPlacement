import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k) 
    {
        long sum=0;
        HashMap<Long,Long> map=new HashMap<Long,Long>();
  
        int n=nums.length;
        int res=0;
        for(int i=0;i<n;i++)
        {
            map.put(sum,map.getOrDefault(sum,(long)0)+1);
            sum+=nums[i];
            if(map.containsKey(sum-k))
            {
                res+=map.get(sum-k);
            }
        }
        return res;
     
        
    }
}